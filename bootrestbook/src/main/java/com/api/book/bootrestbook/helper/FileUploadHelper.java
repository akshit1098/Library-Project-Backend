package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {

    public final String UPLOAD_DIR = "/Users/akshitsaxena/Desktop/Masters/SpringBoot Concepts/Library-Project/Library-Project-Backend/bootrestbook/src/main/resources/static/image";

    public boolean uploadFile(MultipartFile multipartFile){
        boolean f = false;
        try{

            // Method-1

            // InputStream is=multipartFile.getInputStream();
            // byte data[] = new byte[is.available()];

            // // write
            // FileOutputStream fos = new FileOutputStream(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename());
            // fos.write(data);

            // fos.flush();
            // fos.close();
            // f=true;

            // method-2
            
            Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()), StandardCopyOption.REPLACE_EXISTING);



        } catch(Exception e){
            e.printStackTrace();

        }
        return f;

    }

}
