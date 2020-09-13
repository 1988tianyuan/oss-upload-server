package com.tianyuan.objectstorageuploadserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class OSSUploadingServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OSSUploadingServerApplication.class, args);
    }

}
