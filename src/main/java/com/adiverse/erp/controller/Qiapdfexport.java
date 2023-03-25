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

import com.adiverse.erp.openpdf.IiqaReport;

import com.adiverse.erp.service.QiaService;
import com.lowagie.text.DocumentException;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class Qiapdfexport {
	



		private final Logger log = LoggerFactory.getLogger(this.getClass());
		
		
	    @Autowired
	    private QiaService qiaService;
	    
	   
	    
	    @Autowired
	    private  IiqaReport  iiqaReport;
	    
	 
	    @GetMapping("/iiqaReport/generate")
	 	public void generateaffiliatedCriteria5Report(HttpServletResponse response) throws DocumentException, IOException {
	 		
	 		response.setContentType("application/pdf");
	 		DateFormat dateFormatter=new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
	 		String currentDateTime=dateFormatter.format(new Date());
	 		
	 		String headerKey="Content-Disposition";
	 	  String headerValue="attachment;filename=pdf_"+ currentDateTime+".pdf";
	 		response.setHeader(headerKey, headerValue);
	 		
	 		iiqaReport.generateReport();
	 	}  
	
	    
//	    @GetMapping("/pdf/generate21")
//		public void generatePDF(HttpServletResponse response) throws DocumentException, IOException {
//			
//			response.setContentType("application/pdf");
//			DateFormat dateFormatter=new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
//			String currentDateTime=dateFormatter.format(new Date());
//			
//			String headerKey="Content-Disposition";
//		  String headerValue="attachment;filename=pdf_"+ currentDateTime+".pdf";
//			response.setHeader(headerKey, headerValue);
//			
//			iiqaService.export(response);
//	    }
	    
	    
	    


}
