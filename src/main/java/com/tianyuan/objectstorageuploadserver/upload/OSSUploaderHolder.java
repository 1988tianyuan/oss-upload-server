package com.tianyuan.objectstorageuploadserver.upload;

import com.tianyuan.objectstorageuploadserver.upload.qiniu.QiniuUploader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class OSSUploaderHolder implements InitializingBean {
    @Autowired
    private QiniuUploader qiniuUploader;

    private Map<String, OSSUploader<?>> uploaderMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        uploaderMap.put("qiniu", qiniuUploader);
    }

    public OSSUploader<?> getUploader(@NonNull String ossName) {
        OSSUploader<?> uploader = uploaderMap.get(ossName);
        if (uploader == null) {
            log.warn("oss服务:{} 尚未配置，请检查参数", ossName);
        }
        return uploader;
    }
}
