package com.tianyuan.objectstorageuploadserver.error;

public class OSSUploadException extends RuntimeException {

    public OSSUploadException(String message, Throwable cause) {
        super(message, cause);
    }

    public OSSUploadException(String message) {
        super(message);
    }
}
