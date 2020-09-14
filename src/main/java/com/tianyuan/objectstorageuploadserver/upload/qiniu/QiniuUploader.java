package com.tianyuan.objectstorageuploadserver.upload.qiniu;

import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.tianyuan.objectstorageuploadserver.config.QiniuConfig;
import com.tianyuan.objectstorageuploadserver.error.OSSUploadException;
import com.tianyuan.objectstorageuploadserver.upload.OSSUploader;
import com.tianyuan.objectstorageuploadserver.utils.JsonUtil;
import com.tianyuan.objectstorageuploadserver.vo.QiniuUploadResVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.text.MessageFormat;

@Component
@Slf4j
public class QiniuUploader implements OSSUploader<QiniuUploadResVo> {
    @Autowired
    private QiniuConfig config;

    @Override
    public QiniuUploadResVo upload(String bucketName, Resource resource, String fileKey) {
        String uploadToken = config.getAuth().uploadToken(bucketName);
        try(InputStream inputStream = resource.getInputStream()) {
            Response response = config.getUploadManager().put(inputStream, fileKey,
                    uploadToken, null, null);
            log.info("success to upload file:{} to bucket:{}, result is:{}", fileKey, bucketName, response);
            return genResponse(fileKey, response);
        } catch (Exception e) {
            throw new OSSUploadException(MessageFormat.format("failed to upload file:{0} to bucket:{1}",
                    fileKey, bucketName), e);
        }
    }

    @Override
    public QiniuUploadResVo upload(Resource resource, String fileKey) {
        return upload(config.getBucketName(), resource, fileKey);
    }

    private QiniuUploadResVo genResponse(String fileKey, Response response) {
        QiniuUploadResVo resVo = new QiniuUploadResVo();
        resVo.setFileKey(fileKey);
        resVo.setSuccess(true);
        resVo.setOutLink(config.getOutLinkDomain() + fileKey);
        return resVo;
    }
}
