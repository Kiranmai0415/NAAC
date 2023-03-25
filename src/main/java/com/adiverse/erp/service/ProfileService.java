
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
import com.adiverse.erp.model.MousFileUpload;
import com.adiverse.erp.model.MousMain;
import com.adiverse.erp.model.ProfileFileUpload;
import com.adiverse.erp.model.ProfileMain;
import com.adiverse.erp.repository.MousRepository;
import com.adiverse.erp.repository.ProfileRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
@Transactional
public class ProfileService {

	private final Logger logger = LoggerFactory.getLogger(ProfileService.class);

	@Value("${upload.files.path}")
	private String uploadFilePath;

	@Autowired
	private ProfileRepository profileRepository;

	public ProfileMain profileInfo(ProfileMain profileobj, MultipartFile[] profileFiles) {

		try {
			ObjectMapper mapper=new ObjectMapper();
			System.out.println("values====>" +mapper.writeValueAsString(profileobj));
			List<ProfileFileUpload> file1 = new ArrayList<>();
if(profileFiles != null) {
			for (int i = 0; i < profileFiles.length; i++) {
				// Get the filename and build the local file path
				String filename = profileFiles[i].getOriginalFilename();
				logger.info("File name is : " + filename);
				// String directory = this.dirLocation;
				logger.info("uploadFilePath ==>"+uploadFilePath);
				String filepath = Paths.get(uploadFilePath, filename).toString();
				logger.info("path:" + filepath);
				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(profileFiles[i].getBytes());

				stream.close();
				
				String param=filename.substring(0,filename.indexOf("-"));

				ProfileFileUpload fileUpload1 = new ProfileFileUpload();
				fileUpload1.setUniqueKey1(param.concat("-"+profileobj.getCriteriaId().getFinancialYear()));
				fileUpload1.setProfileFileName(filename);
				fileUpload1.setProfileFilePath(filepath);
				fileUpload1.setProfileFileType(param);
				fileUpload1.setCriteriaId(profileobj.getCriteriaId());

				file1.add(fileUpload1);

			}
			profileobj.setProfileFileUpload(file1);
}
			return profileRepository.save(profileobj);

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

	

	public List<ProfileMain> getAllProfileData() {
		try {
			List<ProfileMain> criteria1 = new ArrayList<ProfileMain>();

			profileRepository.findAll().forEach(criteria1::add);

			return criteria1;

		} catch (Exception e) {
			return null;
		}
	}

}
