package com.tianyuan.objectstorageuploadserver.upload.qiniu;

import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.tianyuan.objectstorageuploadserver.config.QiniuConfig;
import com.tianyuan.objectstorageuploadserver.upload.OSSUploader;
import com.tianyuan.objectstorageuploadserver.utils.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class QiniuUploader implements OSSUploader {
    @Autowired
    private QiniuConfig config;

    @Override
    public String upload(String bucketName, Resource resource, String fileKey) {
        String uploadToken = config.getAuth().uploadToken(bucketName);
        Response response = config.getUploadManager().put(resource.getInputStream(), fileKey,
                uploadToken, null, null);
        return JsonUtil.toJson(response);
    }

    @Override
    public String upload(Resource resource, String fileKey) {
        return upload(config.getBucketName(), resource, fileKey);
    }
}
