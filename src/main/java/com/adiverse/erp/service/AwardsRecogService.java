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
import com.adiverse.erp.model.AwardsRecognitionMain;
import com.adiverse.erp.model.AwardsandRecognitionFileUpload;
import com.adiverse.erp.repository.AwardsRecognitionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class AwardsRecogService {

	private final Logger logger = LoggerFactory.getLogger(AwardsRecogService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private AwardsRecognitionRepository awardsRecognitionRepository;

	public AwardsRecognitionMain awardsRecogInfo(AwardsRecognitionMain awardsRecogInfo, MultipartFile[] awardsRecogFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(awardsRecogInfo));
			List<AwardsandRecognitionFileUpload> file1 = new ArrayList<>();
if(awardsRecogFiles != null) {
			for (int i = 0; i < awardsRecogFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = awardsRecogFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(awardsRecogFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				AwardsandRecognitionFileUpload fileUpload1 = new AwardsandRecognitionFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+awardsRecogInfo.getCriteriaId().getFinancialYear()));
				fileUpload1.setAwardsRecogFileName(filename);
				fileUpload1.setAwardsRecogFilePath(filepath);
				fileUpload1.setAwardsRecogFileType(awardsRecogFiles[i].getContentType());
				fileUpload1.setCriteriaId(awardsRecogInfo.getCriteriaId());

				file1.add(fileUpload1);

			}
			awardsRecogInfo.setAwardsandRecognitionFileUpload(file1);
}
			return awardsRecognitionRepository.save(awardsRecogInfo);

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

	

	public List<AwardsRecognitionMain> getAllFacultyData() {
		try {
			List<AwardsRecognitionMain> criteria1 = new ArrayList<AwardsRecognitionMain>();

			awardsRecognitionRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
