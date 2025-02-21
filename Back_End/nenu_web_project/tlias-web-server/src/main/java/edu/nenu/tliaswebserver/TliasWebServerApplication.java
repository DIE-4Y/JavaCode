package edu.nenu.tliaswebserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class TliasWebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasWebServerApplication.class, args);
    }

}
