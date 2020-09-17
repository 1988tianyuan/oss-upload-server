package com.tianyuan.objectstorageuploadserver.controller;

import com.tianyuan.objectstorageuploadserver.upload.OSSUploader;
import com.tianyuan.objectstorageuploadserver.upload.OSSUploaderHolder;
import com.tianyuan.objectstorageuploadserver.vo.CommonResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.channels.AsynchronousFileChannel;

import static com.tianyuan.objectstorageuploadserver.config.Constants.API_PREFIX;

@RestController
@RequestMapping(API_PREFIX)
public class UploadController {
    @Autowired
    private OSSUploaderHolder uploaderHolder;

    @PostMapping("/upload/{oss-name}")
    public Object upload(@PathVariable("oss-name") String ossName,
                           @RequestParam(required = false) String bucketName,
                           @RequestParam(required = false) String fileKey,
                           @RequestParam("upload-file") MultipartFile file) {
        fileKey = StringUtils.isEmpty(fileKey) ? file.getOriginalFilename() : fileKey;
        OSSUploader<?> ossUploader = uploaderHolder.getUploader(ossName);
        if (StringUtils.isEmpty(bucketName)) {
            return CommonResponse.ok(ossUploader.upload(file.getResource(), fileKey));
        } else {
            return CommonResponse.ok(ossUploader.upload(bucketName, file.getResource(), fileKey));
        }
    }
}
