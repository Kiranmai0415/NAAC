package com.adiverse.erp.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.adiverse.erp.model.BooksandChaptersMain;
import com.adiverse.erp.payload.response.MessageResponse;
import com.adiverse.erp.service.BookandChapterService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class BookandChaptersController {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	
    @Autowired
    private BookandChapterService bookandChapterService;
   
     
    @PostMapping(value = "/bookData", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<MessageResponse> booksandChapters(@RequestPart(name = "booksInfo") BooksandChaptersMain booksInfo,
    		@RequestPart(name="booksFiles",required = false) MultipartFile[] booksFiles)
	{
    	ObjectMapper mappper=new ObjectMapper();
    	try {
			System.out.println("mapper====>"+mappper.writeValueAsString(booksInfo));
		} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
    	 String message = "";
    	    try {
    	   
    	    	bookandChapterService.booksandChapterInfo(booksInfo,booksFiles);

    	      message = "Uploaded the file successfully:";
    	      return ResponseEntity.status(HttpStatus.OK).body(new MessageResponse(message));
    	    } catch (Exception e) {
    	      message = "Could not upload the file: ";
    	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessageResponse(message));
    	    }
    	

	}
    
    @GetMapping("/getallbookandchapterdata")
    public ResponseEntity<List<BooksandChaptersMain>> getCriteria1ListFiles() {
      List<BooksandChaptersMain> files = bookandChapterService.getAllBookandChapterData( );
        

      return ResponseEntity.status(HttpStatus.OK).body(files);
    }
    
	
}















