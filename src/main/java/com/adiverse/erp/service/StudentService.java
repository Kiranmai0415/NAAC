package com.adiverse.erp.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.model.CourseRegistrationform_WB;
import com.adiverse.erp.model.CourseRegistreFileUpload1;
import com.adiverse.erp.model.FacultydailyReport_WB;
import com.adiverse.erp.model.LaptopAvailability_WB;
import com.adiverse.erp.model.StudentFileupload;
import com.adiverse.erp.model.StudentForm_WB;
import com.adiverse.erp.model.StudentInternshipForm_WB;

import com.adiverse.erp.repository.CmrRepository;
import com.adiverse.erp.repository.LaptopAvailabilityrepository;
import com.adiverse.erp.repository.StudentIntershipFormRepository;
import com.adiverse.erp.repository.StudentformRepository;

@Service
@Transactional
public class StudentService {
	@Autowired
	private StudentformRepository studentformRepository;

	@Autowired
	private LaptopAvailabilityrepository laptopRepository;

	@Autowired
	private StudentIntershipFormRepository studentIntershipFormRepository;

	@Autowired
	private CmrRepository cmrRepository;

	@Autowired
	private StudentIntershipFormRepository StudentIntershipFormRepository;

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public StudentForm_WB studentInfo(StudentForm_WB studentform, MultipartFile[] studentfileUpload) {

		try {
			log.info("uploadfile=========" + studentfileUpload.length);
			log.info("student info===" + studentform);
			List<StudentFileupload> studentFile = new ArrayList<>();

			studentform.setStudent_id(new Integer(6).longValue());
			for (int i = 0; i < studentfileUpload.length; i++) {
				// Get the filename and build the local file path
				String filename = studentfileUpload[i].getOriginalFilename();
				log.info("File name is : " + filename);
				String directory = "C:\\seema\\FileUpload";
				String filepath = Paths.get(directory, filename).toString();

				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(studentfileUpload[i].getBytes());

				stream.close();

				// save it into file_upload_details table DB
				// String path = "C:\\Users\\risha\\Desktop\\uploads\\"; tb
				StudentFileupload studentfile = new StudentFileupload();
				studentfile.setStudentFilename(filename);
				studentfile.setStudentFilepath(filepath);
				studentfile.setStudentFileType(studentfileUpload[i].getContentType());

				studentFile.add(studentfile);

			}
			studentform.setStudentFileupload(studentFile);

//    		log.info("employee details are"+employee);
//    		_tutorial = inputRepository.save(employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return studentformRepository.save(studentform);

	}

	public List<StudentForm_WB> getAllStudentFiles() {
		try {
			List<StudentForm_WB> student = new ArrayList<StudentForm_WB>();

			studentformRepository.findAll().forEach(student::add);

			return student;

		} catch (Exception e) {
			return null;
		}
	}

	public LaptopAvailability_WB laptopInfo(LaptopAvailability_WB laptop) {

		return laptopRepository.save(laptop);

	}

	public List<LaptopAvailability_WB> getAllLaptopData() {
		try {
			List<LaptopAvailability_WB> availability = new ArrayList<LaptopAvailability_WB>();

			laptopRepository.findAll().forEach(availability::add);

			return availability;

		} catch (Exception e) {
			return null;
		}
	}

	public List<StudentInternshipForm_WB> getAllstudentIntern() {
		try {
			List<StudentInternshipForm_WB> availability1 = new ArrayList<StudentInternshipForm_WB>();

			studentIntershipFormRepository.findAll().forEach(availability1::add);

			return availability1;

		} catch (Exception e) {
			return null;
		}
	}

	public List<CourseRegistrationform_WB> getAllCourseRegistre() {
		try {
			List<CourseRegistrationform_WB> availability2 = new ArrayList<CourseRegistrationform_WB>();

			cmrRepository.findAll().forEach(availability2::add);

			return availability2;

		} catch (Exception e) {
			return null;
		}
	}

	public CourseRegistrationform_WB Cmr1(CourseRegistrationform_WB courseRegistrationformWB) {

		return cmrRepository.save(courseRegistrationformWB);

	}

//public StudentInternshipForm_WB ST(StudentInternshipForm_WB studentInternshipForm_WB, MultipartFile[] studentFileInternshipFile)
//{
//
//try {
//log.info("uploadfile========="+studentFileInternshipFile.length);
//log.info("student info==="+studentFileInternshipFile);
//List<StudentIntershipFileUpload> studentFileInternshipFile1 = new ArrayList<>();
//
//((StudentIntershipFileUpload) studentFileInternshipFile1).setStudentFile_id(0);
//for (int i = 0; i < studentFileInternshipFile.length; i++) {
//	// Get the filename and build the local file path
//	String filename =studentFileInternshipFile [i].getOriginalFilename();
//	log.info("File name is : "+filename);
//	String directory = "C:\\seema\\FileUpload";
//	String filepath = Paths.get(directory, filename).toString();	   
//	
//	// =============Save the file locally====================
//	BufferedOutputStream stream =
//			new BufferedOutputStream(new FileOutputStream(new File(filepath)));
//	
//		stream.write(studentFileInternshipFile[i].getBytes());
//	
//	stream.close();
//	
//	// save it into file_upload_details table DB
//	//String path = "C:\\Users\\risha\\Desktop\\uploads\\"; tb
//	StudentIntershipFileUpload student= new StudentIntershipFileUpload();
//	student.setStudentFilename(filename);
//	student.setStudentFilepath(filepath);
//	student.setStudentFileType(filepath);
//	
//
//	studentFileInternshipFile1.add(student);
//	
//}
//studentInternshipForm_WB.setStudentFileupload(studentFileInternshipFile1);
//
//
//
////log.info("employee details are"+employee);
////_tutorial = inputRepository.save(employee);
//}catch (Exception e) {
//	System.out.println(e.getMessage());
//}
//return StudentIntershipFormRepository.save(studentInternshipForm_WB);
//
//}
//
/////
//
	public CourseRegistrationform_WB Cmr1(CourseRegistrationform_WB courseRegistrationformWB,
			MultipartFile[] CourseRegistreFileUpload1) {

		try {
			log.info("uploadfile=========" + CourseRegistreFileUpload1.length);
			log.info("student info===" + CourseRegistreFileUpload1);
			List<CourseRegistreFileUpload1> CourseRegistreFileUpload11 = new ArrayList<>();

			((CourseRegistreFileUpload1) CourseRegistreFileUpload11).setCmr_id(new Integer(6).longValue());
			for (int i = 0; i < CourseRegistreFileUpload1.length; i++) {
				// Get the filename and build the local file path
				String filename = CourseRegistreFileUpload1[i].getOriginalFilename();
				log.info("File name is : " + filename);
				String directory = "C:\\seema\\FileUpload";
				String filepath = Paths.get(directory, filename).toString();

				// =============Save the file locally====================
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(new File(filepath)));

				stream.write(CourseRegistreFileUpload1[i].getBytes());

				stream.close();

				// save it into file_upload_details table DB
				// String path = "C:\\Users\\risha\\Desktop\\uploads\\"; tb
				CourseRegistreFileUpload1 course = new CourseRegistreFileUpload1();
				course.setCourseRegistrename(filename);
				course.setCourseRegistretFilepath(filepath);
				course.setCourseRegistreType(CourseRegistreFileUpload1[i].getContentType());

				CourseRegistreFileUpload11.add(course);

			}
	//		courseRegistrationformWB.setCourseRegistreFileUpload1(CourseRegistreFileUpload11);

//log.info("employee details are"+employee);
//_tutorial = inputRepository.save(employee);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return cmrRepository.save(courseRegistrationformWB);

	}
	
	
	
	
	public List<StudentInternshipForm_WB> getAllForms() {
		try {
			List<StudentInternshipForm_WB> availability3 = new ArrayList<StudentInternshipForm_WB>();

			StudentIntershipFormRepository.findAll().forEach(availability3::add);

			return availability3;

		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
