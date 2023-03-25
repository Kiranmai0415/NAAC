//package com.adiverse.erp.controller;
//import java.io.IOException;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.adiverse.erp.model.OpenPdfModel;
//import com.adiverse.erp.openpdf.SamplePDFGen;
//import com.adiverse.erp.service.Modelservice;
//import com.lowagie.text.DocumentException;
//@Controller
//public class Modelcontroller {
//
//	@Autowired
//	private  Modelservice service;
//  
//    @GetMapping("/pdf")
//	public void generatePdf(HttpServletResponse response) throws DocumentException, IOException {
//		
//		response.setContentType("application/pdf");
//		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
//		String currentDateTime = dateFormat.format(new Date());
//		String headerkey = "Content-Disposition";
//		String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
//		response.setHeader(headerkey, headervalue);
//		
//		List<Model> valueList = service.getAllModelData();
//		SamplePDFGen generator = new SamplePDFGen();
//		generator.generate(response,valueList);
//	}
//}
