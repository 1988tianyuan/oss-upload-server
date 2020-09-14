package com.tianyuan.objectstorageuploadserver.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommonResponse {

    private Object data;

    private boolean success;

    private String message;

    public static CommonResponse of(Object data, String message, boolean success) {
        return CommonResponse.builder().data(data).message(message).success(success).build();
    }

    public static CommonResponse ok(Object data) {
        return CommonResponse.of(data, null, true);
    }

    public static CommonResponse error(String message) {
        return CommonResponse.of(null, message, false);
    }
}
