package com.tianyuan.objectstorageuploadserver.upload;

import org.springframework.core.io.Resource;

public interface OSSUploader {

    String upload(String bucketName, Resource resource, String fileKey);

    String upload(Resource resource, String fileKey);
}
