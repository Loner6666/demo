package com.example.demo.common;

import com.example.demo.enums.ErrorCode;
import lombok.Data;

import java.io.Serializable;

@Data
public class Result implements Serializable {
    private static final long serialVersionUID = 1L;

    public int code;
    public String message;

    public Result() {
        this.code = ErrorCode.OK.getCode();
        this.message = ErrorCode.OK.getMessage();
    }

    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

}
