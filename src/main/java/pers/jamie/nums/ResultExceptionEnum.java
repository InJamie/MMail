package pers.jamie.nums;

public enum ResultExceptionEnum {
    USER_ERROR(0,"用户信息错误。"),
    USER_ERROR1(0,"用户信息错误。"),
    USER_ERROR2(0,"用户信息错误。"),
    USER_ERROR3(0,"用户信息错误。")
    ;
    private Integer code;
    private String msg;

    ResultExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
