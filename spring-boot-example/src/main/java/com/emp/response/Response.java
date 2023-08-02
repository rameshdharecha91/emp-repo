package com.emp.response;

import lombok.*;

@Setter
@Getter
public class Response<T> {
   private Integer statusCode;
   private String message;
   private T result;

    public Response(T result,Integer statusCode, String message) {
        this.result = result;
        this.statusCode = statusCode;
        this.message = message;
    }
}
