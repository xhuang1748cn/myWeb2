package cn.srn.web2.errorinfo;

/**
 * Created by developer on 2016/3/30.
 */
public enum ErrorInfo {

    SUCCESS(0, "成功"),
    LOGIN_FAIL(1, "登录失败"),
    MOBILE_LENGTH_ERROR(2, "手机号码长度错误"),
    PASSWORD_LENGTH_ERROR(3, "密码长度错误"),
    LOGIN_LIMIT(4, "限制登录"),
    ADMIN_STATUS_ERROR(5, "状态错误"),
    LOGOUT_NOLOGIN(6,"还没有登录"),

    ERROR_FINISH(0xFFFFFFFF, "错误码定义结束");


    private int code;
    private String msg;

    private ErrorInfo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ErrorInfo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
