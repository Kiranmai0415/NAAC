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
import com.adiverse.erp.model.ResearchGuideFileUpload;
import com.adiverse.erp.model.ResearchGuidesMain;
import com.adiverse.erp.model.SeedMoneyFileUpload;
import com.adiverse.erp.model.SeedMoneyMain;
import com.adiverse.erp.repository.FellowshipRepository;
import com.adiverse.erp.repository.ResearchGuidesRepository;
import com.adiverse.erp.repository.SeedMoneyRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class ResearchGuidesService {

	private final Logger logger = LoggerFactory.getLogger(ResearchGuidesService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private ResearchGuidesRepository researchGuidesRepository;

	public ResearchGuidesMain researchInfo(ResearchGuidesMain researchGuides, MultipartFile[] researchGuidesFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(researchGuides));
			List<ResearchGuideFileUpload> file1 = new ArrayList<>();
if(researchGuidesFiles != null) {
			for (int i = 0; i < researchGuidesFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = researchGuidesFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(researchGuidesFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				ResearchGuideFileUpload fileUpload1 = new ResearchGuideFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+researchGuides.getCriteriaId().getFinancialYear()));
				fileUpload1.setResearchGuideFileName(filename);
				fileUpload1.setResearchGuideFilePath(filepath);
				fileUpload1.setResearchGuideFileType(param);
				fileUpload1.setCriteriaId(researchGuides.getCriteriaId());

				file1.add(fileUpload1);

			}
			researchGuides.setResearchGuideFileUpload(file1);
}
			return researchGuidesRepository.save(researchGuides);

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

	

	public List<ResearchGuidesMain> getAllResearchGuidesData() {
		try {
			List<ResearchGuidesMain> criteria1 = new ArrayList<ResearchGuidesMain>();

			researchGuidesRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
