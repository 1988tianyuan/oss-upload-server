package com.tianyuan.objectstorageuploadserver.config;

import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "qiniu")
@Getter
@Setter
public class QiniuConfig implements InitializingBean {

    private String accessKey;

    private String secretKey;

    private String bucketName;

    private String outLinkDomain;

    private Auth auth;

    private UploadManager uploadManager;

    @Override
    public void afterPropertiesSet() throws Exception {
        com.qiniu.storage.Configuration conf = new com.qiniu.storage.Configuration(Region.autoRegion());
        conf.useHttpsDomains = false;
        uploadManager = new UploadManager(conf);
        auth = Auth.create(accessKey, secretKey);
    }
}
