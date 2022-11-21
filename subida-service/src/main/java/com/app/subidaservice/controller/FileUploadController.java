package com.app.subidaservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.app.subidaservice.service.FileUploadService;
import com.app.subidaservice.service.IngresoSalidaService;

@Controller
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    FileUploadService fileUploadService;

    @Autowired
    IngresoSalidaService ingresoSalidaService;

    @RequestMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try{
            String fileName = file.getOriginalFilename();
            fileUploadService.save(file);
            ingresoSalidaService.eliminarIngresosSalidas();
            ingresoSalidaService.leerArchivoSubido(fileName);
            return ResponseEntity.ok().body("Archivo subido correctamente");
        }catch(Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    } 
}
