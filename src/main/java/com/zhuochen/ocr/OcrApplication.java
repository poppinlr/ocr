package com.zhuochen.ocr;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Tesseract1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OcrApplication {

//    @Bean
//    public Tesseract tesseract() {
//        Tesseract tesseract = new Tesseract();
//        tesseract.setDatapath("/usr/local/Cellar/tesseract/3.05.02/share/tessdata");
//        return tesseract;
//    }

    @Bean
    public RestTemplate template() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(OcrApplication.class, args);
    }
}
