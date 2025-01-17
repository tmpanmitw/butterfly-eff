package com.example.butterflyeff;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto<T> {
    private boolean success;
    private T data;
    private Error error;

    public static <T> ResponseDto<T> success(T data) {
        return new ResponseDto<>(true, data, null);
    }

    public static <T> ResponseDto<T> fail(Integer httpStatus, String message, String detail){
        return new ResponseDto<>(false, null, new Error(httpStatus, message, detail));
    }

    // detail : Not Found, Bad request
    // message : 사용자를 찾을 수 없습니다.

    @Getter
    @AllArgsConstructor
    static class Error{
        private Integer httpStatus;
        private String message;
        private String detail;
    }
}
