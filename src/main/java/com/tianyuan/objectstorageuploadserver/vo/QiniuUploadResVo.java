package com.tianyuan.objectstorageuploadserver.vo;

import lombok.Data;

@Data
public class QiniuUploadResVo {

    private String fileKey;

    private String outLink;

    private boolean success;
}
