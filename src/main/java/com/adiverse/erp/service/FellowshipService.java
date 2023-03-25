package com.adiverse.erp.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.exception.FileStorageException;
import com.adiverse.erp.model.FellowshipFileUpload;
import com.adiverse.erp.model.FellowshipMain;
import com.adiverse.erp.model.SeedMoneyFileUpload;
import com.adiverse.erp.model.SeedMoneyMain;
import com.adiverse.erp.repository.FellowshipRepository;
import com.adiverse.erp.repository.SeedMoneyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class FellowshipService {

	private final Logger logger = LoggerFactory.getLogger(FellowshipService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private FellowshipRepository fellowshipRepository;

	public FellowshipMain fellowshipInfo(FellowshipMain fellowship, MultipartFile[] fellowshipFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(fellowship));
			List<FellowshipFileUpload> file1 = new ArrayList<>();
if(fellowshipFiles != null) {
			for (int i = 0; i < fellowshipFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = fellowshipFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(fellowshipFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				FellowshipFileUpload fileUpload1 = new FellowshipFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+fellowship.getCriteriaId().getFinancialYear()));
				fileUpload1.setFellowshipFileName(filename);
				fileUpload1.setFellowshipFilePath(filepath);
				fileUpload1.setFellowshipFileType(param);
				fileUpload1.setCriteriaId(fellowship.getCriteriaId());

				file1.add(fileUpload1);

			}
			fellowship.setFellowshipFileUpload(file1);
}
			return fellowshipRepository.save(fellowship);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
		

	}

	public void init() {
		// TODO Auto-generated method stub
		try {
			Files.createDirectories(Paths.get(uploadFilePath));
		} catch (Exception ex) {
			throw new FileStorageException("Could not create upload dir!");
		}
	}

	public String saveFile(MultipartFile file) {
		// TODO Auto-generated method stub
		try {
			String fileName = file.getOriginalFilename();
			Path root = Paths.get(uploadFilePath);
            if (!Files.exists(root)) {
                init();
            }
			Files.copy(file.getInputStream(), root.resolve(file.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);
			return fileName;

		} catch (Exception e) {
			throw new FileStorageException("Could not upload file");
		}
	}

	

	public List<FellowshipMain> getAllFellowshipData() {
		try {
			List<FellowshipMain> criteria1 = new ArrayList<FellowshipMain>();

			fellowshipRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
