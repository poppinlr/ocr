package com.zhuochen.ocr.service;

import net.sourceforge.tess4j.Tesseract;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class MTesseract extends Tesseract {

    @Override
    @PostConstruct
    protected void init() {
        this.setDatapath("/usr/local/Cellar/tesseract/3.05.02/share/tessdata");
        this.setLanguage("chi_sim");//TODO
        super.init();
    }
}
