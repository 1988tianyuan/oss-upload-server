package com.tianyuan.objectstorageuploadserver.error;

import com.tianyuan.objectstorageuploadserver.vo.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalErrorHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<CommonResponse> error(Exception e) {
        log.warn("global error", e);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(CommonResponse.error(e.getMessage()));
    }
}
