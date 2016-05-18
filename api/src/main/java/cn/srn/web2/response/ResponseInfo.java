package cn.srn.web2.response;

import cn.srn.web2.errorinfo.ErrorInfo;

import java.io.Serializable;

/**
 * Created by Winter on 2016/3/30.
 */
public class ResponseInfo implements Serializable {

    private int code;
    private String msg;

    public ResponseInfo() {
    }

    public ResponseInfo(ErrorInfo errorInfo) {
        this.code = errorInfo.getCode();
        this.msg = errorInfo.getMsg();
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.code = errorInfo.getCode();
        this.msg = errorInfo.getMsg();
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
        return "ResponseInfo{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
