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
import com.adiverse.erp.model.FullTimeTeacherSanctionMain;
import com.adiverse.erp.model.FullTimeTeacherSanctionedPostFileUpload;
import com.adiverse.erp.model.ResearchGuideFileUpload;
import com.adiverse.erp.model.ResearchGuidesMain;
import com.adiverse.erp.model.SeedMoneyFileUpload;
import com.adiverse.erp.model.SeedMoneyMain;
import com.adiverse.erp.model.StudentSatisfactionMain;
import com.adiverse.erp.model.StudentSatisfactorySurveyFileUpload;
import com.adiverse.erp.repository.FellowshipRepository;
import com.adiverse.erp.repository.FullTimeTeacherSacnctionRepository;
import com.adiverse.erp.repository.ResearchGuidesRepository;
import com.adiverse.erp.repository.SeedMoneyRepository;
import com.adiverse.erp.repository.StudentSatisfactionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class FullTimeTeachSanctionService {

	private final Logger logger = LoggerFactory.getLogger(FullTimeTeachSanctionService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private FullTimeTeacherSacnctionRepository fullTimeTeacherSacnctionRepository;

	public FullTimeTeacherSanctionMain ftTeachSanctionInfo(FullTimeTeacherSanctionMain ftTeachSanct, MultipartFile[] ftTeachSanctFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(ftTeachSanct));
			List<FullTimeTeacherSanctionedPostFileUpload> file1 = new ArrayList<>();

			for (int i = 0; i < ftTeachSanctFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = ftTeachSanctFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(ftTeachSanctFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				FullTimeTeacherSanctionedPostFileUpload fileUpload1 = new FullTimeTeacherSanctionedPostFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+ftTeachSanct.getCriteriaId().getFinancialYear()));
				fileUpload1.setSancPostFileName(filename);
				fileUpload1.setSancPostFilePath(filepath);
				fileUpload1.setSancPostFileType(param);
				fileUpload1.setCriteriaId(ftTeachSanct.getCriteriaId());

				file1.add(fileUpload1);

			}
			ftTeachSanct.setFullTimeTeacherSanctionedPostFileUpload(file1);
			return fullTimeTeacherSacnctionRepository.save(ftTeachSanct);

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

	

	public List<FullTimeTeacherSanctionMain> getAllFtTeachSanctData() {
		try {
			List<FullTimeTeacherSanctionMain> criteria1 = new ArrayList<FullTimeTeacherSanctionMain>();

			fullTimeTeacherSacnctionRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
