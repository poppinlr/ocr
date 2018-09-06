package com.zhuochen.ocr.controller;

import com.zhuochen.ocr.service.MTesseract;
import lombok.extern.log4j.Log4j2;
import net.sourceforge.tess4j.Tesseract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.util.Optional;

@RestController
@Log4j2
public class OcrController {

    @Autowired
    private MTesseract tesseract;

    @PostMapping("/ocr")
    public String ocr(@Valid @NotNull MultipartFile multipartFile) {

        return Optional.ofNullable(multipartFile.getOriginalFilename())
                .map(fileName -> {
//                    File file = new File(multipartFile.getOriginalFilename());
                    File file = new File("/Users/zhuochen_shen/Desktop/123.png");
                    try {
//                        multipartFile.transferTo(file);
                        return tesseract.doOCR(file);
                    } catch (Exception e) {
                        log.error("ocr fail: ", e);
                        return null;
                    }
                }).orElse(null);
    }
}
