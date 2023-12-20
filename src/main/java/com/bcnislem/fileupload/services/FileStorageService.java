package com.bcnislem.fileupload.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class FileStorageService {

    @Value("${file.upload.dir}")
    private String uploadDir;

    public void saveFile(String fileName, MultipartFile file) throws IOException {
        String filePath = uploadDir + "\\" + fileName;
        file.transferTo(new File(filePath));
    }
}
