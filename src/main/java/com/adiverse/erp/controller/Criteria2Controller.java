package com.adiverse.erp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.model.Criteria1_FieldInfo;
import com.adiverse.erp.model.Criteria2_FieldInfo;
import com.adiverse.erp.model.Criteria3_FieldInfo;
import com.adiverse.erp.model.Criteria5_FieldInfo;
import com.adiverse.erp.model.Tracking;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.Criteria1Service;
import com.adiverse.erp.service.Criteria2Service;
import com.adiverse.erp.service.Criteria3Service;
import com.adiverse.erp.service.Criteria5Service;
import com.adiverse.erp.service.TrackingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class Criteria2Controller {

private final Logger log = LoggerFactory.getLogger(this.getClass());

@Autowired
    private Criteria2Service criteria2Service;

@Autowired
private Criteria1Service criteria1Service;

@Autowired
private Criteria3Service criteria3Service;

@Autowired
private Criteria5Service criteria5Service;
   
@Autowired
private TrackingService trackingService;


 @GetMapping("/viewResponseValue241")
   public ResponseEntity<Integer> getResponseValue241( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);
 
    Integer responsevalue= Integer.parseInt( files.get(0).getYearTable2112().get(0).getInput2112v());
    if (responsevalue!=null) {
    return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
    else {
    return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
   
   }
 
 @GetMapping("/viewResponseValue242")
   public ResponseEntity<Integer> getResponseValue242( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);
 
  int responsevalue= Integer.parseInt( files.get(0).getYearTable2112().get(0).getInput2112v())+
 Integer.parseInt( files.get(0).getYearTable2112().get(1).getInput2112v())+
 Integer.parseInt( files.get(0).getYearTable2112().get(2).getInput2112v())+
 Integer.parseInt( files.get(0).getYearTable2112().get(3).getInput2112v())+
 Integer.parseInt( files.get(0).getYearTable2112().get(4).getInput2112v());
  if (responsevalue>0) {
  return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
  else {
  return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
}
 
 
 @GetMapping("/viewResponseValue243")
   public ResponseEntity<Integer> getResponseValue243( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);
 
Integer responsevalue= Integer.parseInt( files.get(0).getYearTable2112().get(0).getInput2112v())+
Integer.parseInt( files.get(0).getYearTable2112().get(1).getInput2112v())+
Integer.parseInt( files.get(0).getYearTable2112().get(2).getInput2112v())+
Integer.parseInt( files.get(0).getYearTable2112().get(3).getInput2112v())+
Integer.parseInt( files.get(0).getYearTable2112().get(4).getInput2112v());
if (responsevalue!=null) {
return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
else {
return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
}
 
 
 @GetMapping("/viewResponseValue262")
   public ResponseEntity<Integer> getResponseValue262( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria1_FieldInfo> files = criteria1Service.getAllCriteria1Data(allParams);
 
int responsevalue=  Integer.parseInt( files.get(0).getCriteria12Qn().get(0).getInput1221t2());
if (responsevalue>0) {
return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
else {
return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
}
 
 
 @GetMapping("/viewResponseValue313")
   public ResponseEntity<Integer> getResponseValue313( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);
 
int responsevalue= Integer.parseInt( files.get(0).getYearTable2112().get(0).getInput2112v())+
Integer.parseInt( files.get(0).getYearTable2112().get(1).getInput2112v())+
Integer.parseInt( files.get(0).getYearTable2112().get(2).getInput2112v())+
Integer.parseInt( files.get(0).getYearTable2112().get(3).getInput2112v())+
Integer.parseInt( files.get(0).getYearTable2112().get(4).getInput2112v());
if (responsevalue>0) {
return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
else {
return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
}
 
 @GetMapping("/viewResponseValue322")
   public ResponseEntity<Integer> getResponseValue322( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);
 
int responsevalue=  Integer.parseInt(files.get(0).getYearTable2112().get(0).getInput2112v())+
Integer.parseInt(files.get(0).getYearTable2112().get(1).getInput2112v())+
Integer.parseInt(files.get(0).getYearTable2112().get(2).getInput2112v())+
Integer.parseInt(files.get(0).getYearTable2112().get(3).getInput2112v())+
Integer.parseInt(files.get(0).getYearTable2112().get(4).getInput2112v());
if (responsevalue>0) {
return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
else {
return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
}
 
 
 @GetMapping("/viewResponseValue344")
   public ResponseEntity<Integer> getResponseValue344( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);
 
int responsevalue=  Integer.parseInt(files.get(0).getYearTable2112().get(0).getInput2112v())+
Integer.parseInt(files.get(0).getYearTable2112().get(1).getInput2112v())+
Integer.parseInt(files.get(0).getYearTable2112().get(2).getInput2112v())+
Integer.parseInt(files.get(0).getYearTable2112().get(3).getInput2112v())+
Integer.parseInt(files.get(0).getYearTable2112().get(4).getInput2112v());

if (responsevalue>0) {
return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
else {
return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
}
 
 
 @GetMapping("/viewResponseValue345")
   public ResponseEntity<Integer> getResponseValue345( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);
 
int responsevalue=  Integer.parseInt(files.get(0).getYearTable2112().get(0).getInput2112v())+
Integer.parseInt(files.get(0).getYearTable2112().get(1).getInput2112v())+
Integer.parseInt(files.get(0).getYearTable2112().get(2).getInput2112v())+
Integer.parseInt(files.get(0).getYearTable2112().get(3).getInput2112v())+
Integer.parseInt(files.get(0).getYearTable2112().get(4).getInput2112v());
if (responsevalue>0) {
return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
else {
return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
}
 
 @GetMapping("/viewResponseValue412")
   public ResponseEntity<Integer> getResponseValue412( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria3_FieldInfo> files = criteria3Service.getAllCriteria3Data(allParams);
 
int responsevalue=Integer.parseInt( files.get(0).getCriteria31Ql().get(0).getResponse311());
if (responsevalue>0) {
return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
else {
return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
}


 
 @GetMapping("/viewResponseValue422")
   public ResponseEntity<Integer> getResponseValue422( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria3_FieldInfo> files = criteria3Service.getAllCriteria3Data(allParams);
 
int responsevalue= Integer.parseInt( files.get(0).getCriteria31Ql().get(0).getResponse311());
if (responsevalue>0) {
return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
else {
return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
}
 
 
 @GetMapping("/viewResponseValue432")
   public ResponseEntity<Integer> getResponseValue432( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria1_FieldInfo> files = criteria1Service.getAllCriteria1Data(allParams);
 
int responsevalue= Integer.parseInt( files.get(0).getCriteria12Qn().get(0).getResponse121());
if (responsevalue>0) {
return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
else {
return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
}
 
 
 
 @GetMapping("/viewResponseValue441")
   public ResponseEntity<Integer> getResponseValue441( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria3_FieldInfo> files = criteria3Service.getAllCriteria3Data(allParams);
 
int responsevalue= Integer.parseInt( files.get(0).getCriteria31Qn().get(0).getResponse312());
if (responsevalue>0) {
return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
else {
return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
}
 
 
 @GetMapping("/viewResponseValue511")
   public ResponseEntity<Integer> getResponseValue511( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria1_FieldInfo> files = criteria1Service.getAllCriteria1Data(allParams);
 
int responsevalue= Integer.parseInt( files.get(0).getCriteria12Qn().get(0).getResponse121());
if (responsevalue>0) {
return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
else {
return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
}
 
 
 
 
 @GetMapping("/viewResponseValue521")
   public ResponseEntity<Integer> getResponseValue521( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria1_FieldInfo> files = criteria1Service.getAllCriteria1Data(allParams);
 List<Criteria5_FieldInfo> files5 = criteria5Service.getAllCriteria5Data(allParams);
 
int responsevalue= Integer.parseInt( files.get(0).getCriteria12Qn().get(0).getResponse121())-
( Integer.parseInt(files5.get(0).getUniversityYearTable5221().get(0).getInput5221v())+
Integer.parseInt(files5.get(0).getUniversityYearTable5221().get(1).getInput5221v())+
Integer.parseInt(files5.get(0).getUniversityYearTable5221().get(2).getInput5221v())+
Integer.parseInt(files5.get(0).getUniversityYearTable5221().get(3).getInput5221v())+
Integer.parseInt(files5.get(0).getUniversityYearTable5221().get(4).getInput5221v()));
if (responsevalue>0) {
return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
else {
return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
}
 
 
 @GetMapping("/viewResponseValue522")
   public ResponseEntity<Integer> getResponseValue522( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria1_FieldInfo> files = criteria1Service.getAllCriteria1Data(allParams);
 List<Criteria5_FieldInfo> files5 = criteria5Service.getAllCriteria5Data(allParams);
 
int responsevalue= Integer.parseInt( files.get(0).getCriteria12Qn().get(0).getResponse121())-
(Integer.parseInt(files5.get(0).getCriteria52Qn().get(0).getInput522t1()));
if (responsevalue>0) {
return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
else {
return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
}
 
 
 
 
 
 
 @GetMapping("/viewResponseValue523")
   public ResponseEntity<Integer> getResponseValue523( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria1_FieldInfo> files = criteria1Service.getAllCriteria1Data(allParams);
 
int responsevalue= Integer.parseInt( files.get(0).getCriteria12Qn().get(0).getResponse121());
if (responsevalue>0) {
return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
else {
return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
}
 
 
 
 @GetMapping("/viewResponseValue632")
   public ResponseEntity<Integer> getResponseValue632( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);
 
int responsevalue= Integer.parseInt( files.get(0).getCriteria22Qn().get(0).getResponse222());
if (responsevalue>0) {
return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
else {
return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
}
 
 @GetMapping("/viewResponseValue633")
   public ResponseEntity<Integer> getResponseValue633( @RequestParam Map<String, String> allParams)
   {
   
 List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);
 
int responsevalue= Integer.parseInt( files.get(0).getCriteria22Qn().get(0).getResponse222());
if (responsevalue>0) {
return ResponseEntity.status(HttpStatus.OK).body(responsevalue);

}
else {
return ResponseEntity.status(HttpStatus.OK).body(null);
}
 
}
 
 
 
 //////////////////////////////////////////////////////////////////////
   

    @PostMapping(value = "/criteria2upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MessageResponse> Criteria2(@RequestPart(name = "criteria2Fieldinfo") Criteria2_FieldInfo criteria2Fieldinfo,  @RequestPart(name="uploadfile2") MultipartFile[] uploadfile2)
{
   
    String message = "";
       try {
        ObjectMapper mappercontroler=new ObjectMapper();
        System.out.println("mappercontroler====>"+mappercontroler.writeValueAsString(criteria2Fieldinfo));
        criteria2Service.criteria2Info(criteria2Fieldinfo,uploadfile2);

       
       
         message = "Uploaded the file successfully:";
         return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
       } catch (Exception e) {
       
         message = "Could not upload the file: ";
         return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
       }
   

}
   
   
   
   
   
   
   
   
   
   
   
    @PostMapping(value = "/criteria2submit")
    public ResponseEntity<MessageResponse> Criteria2( @RequestParam Map<String, String> allParams)
{
   
    String message = "";
       try {
        ObjectMapper mappercontroler=new ObjectMapper();
        System.out.println("mappercontroler====>"+mappercontroler.writeValueAsString(allParams));
       
//         Map<String, String> allParams = new HashMap<String, String>();
//     allParams.put("collegeId", criteria2Fieldinfo.getCriteriaId().getCollegeId() );
//     allParams.put("financialYear", criteria2Fieldinfo.getCriteriaId().getFinancialYear() );
//     allParams.put("typeofInstitution", criteria2Fieldinfo.getCriteriaId().getTypeofInstitution() );
//        
        allParams.put("role","faculty");
       
        criteria2Service.criteria2Info(allParams);
         message = "Uploaded the file successfully:";
         return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
       } catch (Exception e) {
         message = "Could not upload the file: ";
         return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
       }
   

}
   
    @PostMapping("/criteria2submittoprincipal")
  public String deanAuthorizedEmail(@RequestBody Tracking tracking, @RequestParam Map<String, String> allParams)

  {
      System.out.println("criteria2submittoprincipal");
      ObjectMapper mapper =new ObjectMapper();
      try {
  System.out.println(mapper.writeValueAsString(tracking));

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
  allParams1.put("role",tracking.getRole());
  try {
  System.out.println("allparems===++>>"+mapper.writeValueAsString(allParams1));
  } catch (JsonProcessingException e) {
  // TODO Auto-generated catch block
  e.printStackTrace();
  }
  System.out.println("start");
  status1 =criteria2Service.criteria2Info(allParams1);
 
    trackingService.authorizedInfo(tracking);

//   status1 = trackingService.sendAutomatedEmail(tracking, institutionType);

  return status1;
  }
   
   
   
   
   
   
   
   
   
   
   
   
    @GetMapping("/criteria2getallfiles")
    public ResponseEntity<List<Criteria2_FieldInfo>> getCriteria2ListFiles(@RequestParam Map<String, String> allParams) {
   
System.out.println("params are --->"+allParams);

      List<Criteria2_FieldInfo> files = criteria2Service.getAllCriteria2Data(allParams);
       

      return ResponseEntity.status(HttpStatus.OK).body(files);
    }

   


//autonomous criteria2

@PostMapping("/autonomouscriteria2Email")
public String AutonomousCriteria2Email(@RequestPart Tracking tracking)

{
String status1 = null;

trackingService.authorizedInfo(tracking);

// status1 = trackingService.sendAutonomousCriteria2Email();

return status1;
}

//affiliated criteria 2
@PostMapping("/affiliatedcriteria2Email")
public String AffiliatedCriteria2Email(@RequestPart Tracking tracking)
{
 String status1 = null;
 trackingService.authorizedInfo(tracking);
//  status1 = trackingService.sendAffiliatedCriteria2Email();
 return status1;
}

}
















