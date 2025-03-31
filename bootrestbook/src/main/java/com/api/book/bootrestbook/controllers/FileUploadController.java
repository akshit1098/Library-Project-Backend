package com.api.book.bootrestbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.bootrestbook.helper.FileUploadHelper;

@RestController
public class FileUploadController {

    @Autowired
    private FileUploadHelper fileUploadHelper;

    @SuppressWarnings("null")
    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){

        System.out.println("here");
        // check if it's working
        
        //return ResponseEntity.ok("working");

        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());
        System.out.println(file.getContentType());
        System.out.println(file.getName());

        try{
            // validation
            if(file.isEmpty()){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
            }

            // if only image is allowed
            if (!file.getContentType().equals("image/jpeg")){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only JPEG content type is allowed");
            }

            // file upload code..

            boolean f = fileUploadHelper.uploadFile(file);
            System.out.println(f);
            if(f){
                // return ResponseEntity.ok("File is successfully upoaded");

                // cotextPath = localhost8080/image/fileName
                System.out.println("--->reached here...");
                return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
                // the file will get uploaded to target folder/static/iamge
            }


        } catch(Exception e){
            e.printStackTrace();
        }
        




        return ResponseEntity.ok("working");
    }

}
