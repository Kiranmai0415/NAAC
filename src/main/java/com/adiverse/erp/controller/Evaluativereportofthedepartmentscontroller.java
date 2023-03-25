package com.adiverse.erp.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import com.adiverse.erp.model.EvaluativereportMain;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.openpdf.AffiliatedEvaluationReport;
import com.adiverse.erp.openpdf.AutonomousExtendedProfileReport;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.EvalutiveReportService;
import com.adiverse.erp.service.TrackingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lowagie.text.DocumentException;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class Evaluativereportofthedepartmentscontroller {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private EvalutiveReportService evalutivereportservice;
	@Autowired
	private TrackingService trackingService;
	@Autowired
	private AffiliatedEvaluationReport  affiliatedEvaluationReport;

	@PostMapping(value = "/evaluativedata", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity<MessageResponse> Evaluative(@RequestPart EvaluativereportMain evaluativereportofthedepartment) {
ObjectMapper mapper =new ObjectMapper();
try {
	System.out.println("mapper===>"+mapper.writeValueAsString(evaluativereportofthedepartment));
} catch (JsonProcessingException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
		String message = "";
		try {
			evalutivereportservice.evaluativeInfo(evaluativereportofthedepartment);

			message = "Evaluative Data uploaded successfully:";
			return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
		} catch (Exception e) {
			message = "Could not upload the Evaluative Data: ";
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
		}
	}

	@GetMapping("/getallevaluativedata")
	public ResponseEntity<List<EvaluativereportMain>> getevaluativetotalData(@RequestParam Map<String, String> allParams) {
		
//		System.out.println("params are --->"+allParams);
		List<EvaluativereportMain> evaluative = evalutivereportservice.getAllEvaluativeData(allParams);
		return ResponseEntity.status(HttpStatus.OK).body(evaluative);
	}
	
	
	 @GetMapping("/affiliatedevaluation/generate")
	   	public void generate(HttpServletResponse response) throws DocumentException, IOException {
	   		
	   		response.setContentType("application/pdf");
	   		DateFormat dateFormatter=new SimpleDateFormat("YYYY-MM-dd:hh:mm:ss");
	   		String currentDateTime=dateFormatter.format(new Date());
	   		
	   		String headerKey="Content-Disposition";
	   	  String headerValue="attachment;filename=pdf_"+ currentDateTime+".pdf";
	   		response.setHeader(headerKey, headerValue);
	   		
	   		//affiliatedEvaluationReport.generateReport();
	   		
	   
	}
	 
	 
	 
	 @PostMapping("/evaluativeRepotDataSubmittoPrincipal")
		public String extendeDeanAuthorizedEmail(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)

		{
	    	System.out.println("evaluativeDatasubmittoprincipal");
	    	ObjectMapper mapper =new ObjectMapper();
	    	try {
				System.out.println("tracking"+mapper.writeValueAsString(tracking));

				System.out.println("allparams==>"+mapper.writeValueAsString(allParams));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String status1 = null;
			Map<String, String> allParams1 = new HashMap<String, String>();
			allParams1.put("collegeId", tracking.getCriteriaId().getCollegeId() );
			allParams1.put("financialYear", tracking.getCriteriaId().getFinancialYear() );
			allParams1.put("typeofInstitution", tracking.getCriteriaId().getTypeofInstitution() );
			

			
			try {
				System.out.println("allparems===++>>"+mapper.writeValueAsString(allParams1));
			} catch (JsonProcessingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			trackingService.authorizedInfo(tracking);
			System.out.println("start");
		status1 =evalutivereportservice.evalutiveMail(allParams1);
			
			return status1;
		}

	
	 @PostMapping("/evaluativeReportDeanRejectRecord")
		public String principalRejectRecord(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)
				throws JsonProcessingException

		{
			ObjectMapper mapper = new ObjectMapper();
			System.out.println(mapper.writeValueAsString(tracking));
			System.out.println("allparams==>"+mapper.writeValueAsString(allParams));
			System.out.println("all params are ==>" + allParams);
			String institutionType = allParams.get("institutionType");
			trackingService.trackingInfo(tracking);

			String status = trackingService.sendAutomatedEmail(tracking, institutionType);

			return status;
		}

	 
	 
	 
	 
	
	
}
