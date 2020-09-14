package com.tianyuan.objectstorageuploadserver.upload;

import org.springframework.core.io.Resource;

public interface OSSUploader<T> {

    T upload(String bucketName, Resource resource, String fileKey);

    T upload(Resource resource, String fileKey);
}
