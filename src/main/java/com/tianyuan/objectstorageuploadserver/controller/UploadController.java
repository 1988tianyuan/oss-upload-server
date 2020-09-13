package com.tianyuan.objectstorageuploadserver.controller;

import com.tianyuan.objectstorageuploadserver.upload.OSSUploader;
import com.tianyuan.objectstorageuploadserver.upload.OSSUploaderHolder;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

@RestController
public class UploadController {
    @Autowired
    private OSSUploaderHolder uploaderHolder;

    @PostMapping("/upload/{oss-name}")
    public Mono<String> upload(@PathVariable("oss-name") String ossName,
                               @RequestParam(required = false) String bucketName,
                               @RequestParam(required = false) String fileKey,
                               MultipartFile file) {
        fileKey = StringUtils.isEmpty(fileKey) ? file.getName() : fileKey;
        OSSUploader ossUploader = uploaderHolder.getUploader(ossName);
        if (StringUtils.isEmpty(bucketName)) {
            ossUploader.upload();
        } else {
            ossUploader.upload(bucketName, );
        }

        return Mono.just("success");
    }
}
