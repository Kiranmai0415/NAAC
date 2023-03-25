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
import com.adiverse.erp.model.StudentSatisfactionMain;
import com.adiverse.erp.model.StudentSatisfactorySurveyFileUpload;
import com.adiverse.erp.repository.FellowshipRepository;
import com.adiverse.erp.repository.ResearchGuidesRepository;
import com.adiverse.erp.repository.SeedMoneyRepository;
import com.adiverse.erp.repository.StudentSatisfactionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class StudentSatisfactionService {

	private final Logger logger = LoggerFactory.getLogger(StudentSatisfactionService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private StudentSatisfactionRepository studentSatisfactionRepository;

	public StudentSatisfactionMain studentsSatisfyInfo(StudentSatisfactionMain studentsMain, MultipartFile[] studentsMainFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(studentsMain));
			List<StudentSatisfactorySurveyFileUpload> file1 = new ArrayList<>();

			for (int i = 0; i < studentsMainFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = studentsMainFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(studentsMainFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				StudentSatisfactorySurveyFileUpload fileUpload1 = new StudentSatisfactorySurveyFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+studentsMain.getCriteriaId().getFinancialYear()));
				fileUpload1.setStudentSatisfFileName(filename);
				fileUpload1.setStudentSatisfFilePath(filepath);
				fileUpload1.setStudentSatisfFileType(param);
				fileUpload1.setCriteriaId(studentsMain.getCriteriaId());

				file1.add(fileUpload1);

			}
			studentsMain.setStudentSatisfactorySurveyFileUpload(file1);
			return studentSatisfactionRepository.save(studentsMain);

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

	

	public List<StudentSatisfactionMain> getAllStudentsSatisfyData() {
		try {
			List<StudentSatisfactionMain> criteria1 = new ArrayList<StudentSatisfactionMain>();

			studentSatisfactionRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
