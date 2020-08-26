package com.javainuse.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
//import cn.hutool.json.JSONObject;

@RestController
@RequestMapping("/download")
public class FileDownloadController {

                private static final String EXTERNAL_FILE_PATH = "C:/";

                @RequestMapping(value = {"/test"}, method=RequestMethod.GET)
                public String welcome() {
                	return "Welcome MJ!!!";
                }
                
                @RequestMapping(value = {"/file"}, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
                public ResponseEntity<?> downloadPDFResource() throws IOException {

                                //File file = new File(EXTERNAL_FILE_PATH + "ecm-api-v2.yaml");
                                File file = new File(EXTERNAL_FILE_PATH + "test.pdf");
                                //File file = new File(EXTERNAL_FILE_PATH + "worddoc.docx");

                                                //String mimeType = URLConnection.guessContentTypeFromName(file.getName());

                                                InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
                                                byte[] bytes = IOUtils.toByteArray(inputStream);


                                        HttpHeaders headers = new HttpHeaders(); 
                                        headers.setContentDispositionFormData("inline", file.getName());
                                        headers.setContentLength(bytes.length);
                                        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
                                        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

                                        ResponseEntity<byte[]> response= new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
                                                
                                               return response;
}
}




//
//
//package com.javainuse.controller;
//
//import java.io.BufferedInputStream;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.apache.commons.io.IOUtils;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
////import cn.hutool.json.JSONObject;
//
//@RestController
//@RequestMapping("/download")
//public class FileDownloadController {
//
//    private static final String EXTERNAL_FILE_PATH = "C:/";
//
//
//    @RequestMapping(value = {"/file"}, method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<Object> downloadPDFResource() throws Exception {
//
//	    //File file = new File(EXTERNAL_FILE_PATH + "ecm-api-v2.yaml");
//	    //File file = new File(EXTERNAL_FILE_PATH + "test.pdf");
//	    File file = new File(EXTERNAL_FILE_PATH + "worddoc.docx");
//	
//	    //String mimeType = URLConnection.guessContentTypeFromName(file.getName());
//	
//	    InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
//	    byte[] bytes = IOUtils.toByteArray(inputStream);
//	
//	
//	    HttpHeaders headers = new HttpHeaders(); 
//	    headers.setContentDispositionFormData("inline", file.getName());
//	    headers.setContentLength(bytes.length);
//	    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
//	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//	
//	    //ResponseEntity<byte[]> response= new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);	            
//	    //return response;
//	    
//	    List<Object> entries = new ArrayList<Object>();
//	    cn.hutool.json.JSONObject obj = new cn.hutool.json.JSONObject();
//	    obj.put("id", 1);
//	    obj.put("status", "success");
//	    
//	    entries.add(obj);	    
//	    entries.add(bytes);
//	    
//	    ResponseEntity<Object> response = new ResponseEntity<Object>(entries, HttpStatus.OK);	    
//	    return response;
//    }
//}




