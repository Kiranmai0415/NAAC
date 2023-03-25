package com.adiverse.erp.controller;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adiverse.erp.service.PDFGeneratorService;
import com.adiverse.erp.utilities.AffliatedQualityProfile;
import com.adiverse.erp.utilities.QualityProfileReport;
import com.adiverse.erp.utilities.UniversityQualityProfile;
import com.lowagie.text.DocumentException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")

public class PDFExportController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
    @Autowired
    private PDFGeneratorService pdfGeneratorService;
    
	
	@Autowired
	private final QualityProfileReport pdfGeneratorUtil;
	@Autowired
	private final UniversityQualityProfile	universityQualityProfile;
	
	@Autowired 
	private final AffliatedQualityProfile affliatedQualityProfile;

	public PDFExportController(QualityProfileReport pdfGeneratorUtil, UniversityQualityProfile	universityQualityProfile, AffliatedQualityProfile affliatedQualityProfile) {
		super();
		this.pdfGeneratorUtil = pdfGeneratorUtil;
		this.universityQualityProfile= universityQualityProfile;
		this.affliatedQualityProfile =affliatedQualityProfile;
	}
	private PDFGeneratorService PDFGeneratorService() {
		// TODO Auto-generated method stub
		return null;
	}
	@GetMapping("/pdf/generate") //autonouomous
	public void generatePDF(HttpServletResponse response) throws DocumentException, IOException {
		
		response.setContentType("application/pdf");
		DateFormat dateFormatter=new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime=dateFormatter.format(new Date());
		
		String headerKey="Content-Disposition";
	  String headerValue="attachment;filename=pdf_"+ currentDateTime+".pdf";
		response.setHeader(headerKey, headerValue);
		
		pdfGeneratorUtil.export();
	}
	@GetMapping("/pdf/generate9") //university
	public void generatePDF1(HttpServletResponse response) throws DocumentException, IOException {
		
		response.setContentType("application/pdf");
		DateFormat dateFormatter=new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime=dateFormatter.format(new Date());
		
		String headerKey="Content-Disposition";
	  String headerValue="attachment;filename=pdf_"+ currentDateTime+".pdf";
		response.setHeader(headerKey, headerValue);
		
		universityQualityProfile.export();
	}
	
	@GetMapping("/pdf/generate10") //affiliated
	public void generatePDF2(HttpServletResponse response) throws DocumentException, IOException {
		
		response.setContentType("application/pdf");
		DateFormat dateFormatter=new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
		String currentDateTime=dateFormatter.format(new Date());
		
		String headerKey="Content-Disposition";
	  String headerValue="attachment;filename=pdf_"+ currentDateTime+".pdf";
		response.setHeader(headerKey, headerValue);
		
		affliatedQualityProfile.export();
	}
	
	
	

}
