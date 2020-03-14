package com.example.demo.enums;

/**
 * 错误代码及含义
 */
public enum ErrorCode {
    OK(200, "成功"),
    FAIL(201, "操作失败"),
    FAIL_INFO(202, "操作失败"),
    UN_LOGIN(-10, "未登陆"),
    BUSINESS_ERROR(400, "业务错误"),
    MESSAGE_TOO_OFTEN(401, "消息太频繁请稍后再试"),
    NOT_FOUND_ERROR(404, "信息未找到"),
    UNAVAILABLE_ERROR(405, "信息不可用"),
    REPEAT_ERROR(406, "信息重复"),
    REQUEST_REPEAT(407, "重复提交，请至少1分钟后再试"),
    DB_ERROR(412, "数据库错误"),
    SERVER_ERROR(500, "服务器内部错误"),

    DATA_TTRANSFER_ING(1000, "数据正在同步中"),
    NO_PARAMETERS(1001, "参数不能为空"),
    ;

    private int code;
    private String message;

    private ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static ErrorCode getByCode(final int code) {
        final ErrorCode[] values = ErrorCode.values();
        for (final ErrorCode value : values) {
            if (value.getCode() == code) {
                return value;
            }
        }
        return null;
    }
}
