package com.example.login.controller;

import com.example.login.model.respo.FileRes;
import com.example.login.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class FileController {
    @Autowired
    private final FileService fileService;
    // Upload file
    @PostMapping("files")
    public ResponseEntity<?> uploadFile(@ModelAttribute("file")MultipartFile file){
        FileRes fileRes = fileService.uploadFile(file);
        return ResponseEntity.ok(fileRes);
    }


    // Xem thông tin file
    @GetMapping("files/{id}")
    public ResponseEntity<?> readFile(@PathVariable String id){
        byte[] bytes = fileService.readFile(id);
        return ResponseEntity.ok().
                contentType(MediaType.IMAGE_JPEG).
                body(bytes);
    }


}
