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
import com.adiverse.erp.model.FullTimeTeacherswithSpecializationFileUpload;
import com.adiverse.erp.model.FulltimeTeachersSPLMain;
import com.adiverse.erp.repository.Criteria2Repository;
import com.adiverse.erp.repository.FulltimeSPlRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class FacultyFullSPLService {

	private final Logger logger = LoggerFactory.getLogger(FacultyFullSPLService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private FulltimeSPlRepository fulltimeSPlRepository;
	
	@Autowired
	private Criteria2Repository criteria2Repository;

	public FulltimeTeachersSPLMain FullsplInfo(FulltimeTeachersSPLMain splInfo, MultipartFile[] splFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(splInfo));
			List<FullTimeTeacherswithSpecializationFileUpload> file1 = new ArrayList<>();
if(splFiles != null) {
			for (int i = 0; i < splFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = splFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(splFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				FullTimeTeacherswithSpecializationFileUpload fileUpload1 = new FullTimeTeacherswithSpecializationFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+splInfo.getCriteriaId().getFinancialYear()));
				fileUpload1.setFulltimeTeacherswithSpecFileName(filename);
				fileUpload1.setFulltimeTeacherswithSpecFilePath(filepath);
				fileUpload1.setFulltimeTeacherswithSpecFileType(splFiles[i].getContentType());
				fileUpload1.setCriteriaId(splInfo.getCriteriaId());

				file1.add(fileUpload1);

			}
			splInfo.setFullTimeTeacherswithSpecializationFileUpload(file1);
}
//		if("autonomous".equalsIgnoreCase(splInfo.getCriteriaId().getTypeofInstitution())) {
//	    int result242 = criteria2Repository.updateYearTable2421(splInfo.getFullTimeTeacherswithSpecialization().get(0).getInputftt1(),
//	    splInfo.getFullTimeTeacherswithSpecialization().get(0).getInputftt2());
//		System.out.println("result242au=============>"+result242);
//													
//		}
//		else if ("university".equalsIgnoreCase(splInfo.getCriteriaId().getTypeofInstitution()))	{
//		int result242 = criteria2Repository.updateYearTable2421(splInfo.getFullTimeTeacherswithSpecialization().get(0).getInputftt1(),
//		 splInfo.getFullTimeTeacherswithSpecialization().get(0).getInputftt2());
//		System.out.println("result242u=============>"+result242);	
//		}			
//		else if("affiliated".equalsIgnoreCase(splInfo.getCriteriaId().getTypeofInstitution())) {
//			int result242 = criteria2Repository.updateYearTable2421(splInfo.getFullTimeTeacherswithSpecialization().get(0).getInputftt1(),
//					splInfo.getFullTimeTeacherswithSpecialization().get(0).getInputftt2()	);
//			System.out.println("result242af=============>"+result242); 
//		}	
			
		return fulltimeSPlRepository.save(splInfo);

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

	

	public List<FulltimeTeachersSPLMain> getAllFacultyData() {
		try {
			List<FulltimeTeachersSPLMain> criteria1 = new ArrayList<FulltimeTeachersSPLMain>();

			fulltimeSPlRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
