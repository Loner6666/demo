package com.example.demo.common;

import com.example.demo.enums.ErrorCode;

import java.io.Serializable;

/**
 * 公共返回类型
 *
 * @param <T>
 */
public class ResultObject<T> extends Result implements Serializable {
    private static final long serialVersionUID = 1L;

    public T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultObject() {
        super();
    }

    public ResultObject(T data) {
        super();
        this.data = data;
    }

    public boolean success() {
        return this.code == ErrorCode.OK.getCode();
    }

    public boolean fail() {
        return this.code != ErrorCode.OK.getCode();
    }

    public ResultObject(T data, String msg) {
        this.code = ErrorCode.OK.getCode();
        this.message = msg;
        this.data = data;
    }

    public ResultObject(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMessage();
    }

    public ResultObject(int code, String message) {
        super(code, message);
    }

    public ResultObject(int code, String message, T data) {
        super(code, message);
        this.data = data;
    }

    public static <T> ResultObject<T> successMsg() {
        return new ResultObject<>(ErrorCode.OK.getCode(), ErrorCode.OK.getMessage());
    }

    public static <T> ResultObject<T> successMsg(String msg) {
        return new ResultObject<>(ErrorCode.OK.getCode(), msg);
    }

    public static <T> ResultObject<T> successMsg(ErrorCode errorCode) {
        return new ResultObject<>(errorCode.getCode(), errorCode.getMessage());
    }

    /**
     * 返回data的调用successData方法，特别是当data是String类型时
     */
    public static <T> ResultObject<T> successData(T data) {
        return new ResultObject<>(data);
    }

    public static <T> ResultObject<T> successData(T data, String msg) {
        return new ResultObject<>(data, msg);
    }

    public static <T> ResultObject<T> error(int code, String msg) {
        return new ResultObject<>(code, msg);
    }

    public static <T> ResultObject<T> error(String msg) {
        return new ResultObject<>(ErrorCode.FAIL.getCode(), msg);
    }

    public static <T> ResultObject<T> error(ErrorCode errorCode) {
        return new ResultObject<>(errorCode);
    }
}
