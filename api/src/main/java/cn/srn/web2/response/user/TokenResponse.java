package cn.srn.web2.response.user;

import cn.srn.web2.errorinfo.ErrorInfo;
import cn.srn.web2.response.ResponseInfo;

/**
 * Created by Winter on 2016/5/17.
 */
public class TokenResponse extends ResponseInfo {

    private String token;

    public TokenResponse() {
    }

    public TokenResponse(ErrorInfo errorInfo, String token) {
        super(errorInfo);
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "TokenResponse{" + super.toString() +
                ", token='" + token + '\'' +
                '}';
    }
}
