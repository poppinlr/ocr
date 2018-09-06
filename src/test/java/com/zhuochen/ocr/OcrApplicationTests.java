package com.zhuochen.ocr;

import lombok.extern.log4j.Log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(JUnit4.class)
@Log4j
public class OcrApplicationTests {

    @Test
    public void contextLoads() {
        System.getenv("TESSDATA_PREFIX");
    }

}
