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
import com.adiverse.erp.model.EContentDevelopedByTeacherFileUpload;
import com.adiverse.erp.model.EcontentDevbyTeachMain;
import com.adiverse.erp.repository.AwardsRecognitionRepository;
import com.adiverse.erp.repository.EContentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class EContentService {

	private final Logger logger = LoggerFactory.getLogger(EContentService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private EContentRepository eContentRepository;

	public EcontentDevbyTeachMain eContentInfo(EcontentDevbyTeachMain eContentobj, MultipartFile[]  eContentFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(eContentobj));
			List<EContentDevelopedByTeacherFileUpload> file1 = new ArrayList<>();
if(eContentFiles != null) {
			for (int i = 0; i < eContentFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = eContentFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(eContentFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				EContentDevelopedByTeacherFileUpload fileUpload1 = new EContentDevelopedByTeacherFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+eContentobj.getCriteriaId().getFinancialYear()));
				fileUpload1.setEcontentDevelopedbyTeacherFileName(filename);
				fileUpload1.setEcontentDevelopedbyTeacherFilePath(filepath);
				fileUpload1.setEcontentDevelopedbyTeacherFileType(param);
				fileUpload1.setCriteriaId(eContentobj.getCriteriaId());

				file1.add(fileUpload1);

			}
			eContentobj.seteContentDevelopedByTeacherFileUpload(file1);
}
			return eContentRepository.save(eContentobj);

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

	

	public List<EcontentDevbyTeachMain> getAllEContentData() {
		try {
			List<EcontentDevbyTeachMain> criteria1 = new ArrayList<EcontentDevbyTeachMain>();

			eContentRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
