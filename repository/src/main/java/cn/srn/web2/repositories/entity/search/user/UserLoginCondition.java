package cn.srn.web2.repositories.entity.search.user;

import cn.srn.web2.repositories.entity.search.Condition;

import static cn.srn.web2.httpUtil.MD5Util.MD5;

/**
 * Created by Winter on 2016/4/1.
 */
public class UserLoginCondition extends Condition {

    private String mobile;
    private String password;
    private int pswdLength;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null) {
            pswdLength = 0;
        } else {
            pswdLength = password.length();
        }
        this.password = MD5(password + "A8KF1T6GV2Y5D1V ");
    }

    public int getPswdLength() {
        return pswdLength;
    }

    @Override
    public String toString() {
        return "AdminLoginCondition{" +
                "mobile='" + mobile + '\'' +
                ", password='" + password + '\'' +
                ", pswdLength=" + pswdLength +
                '}';
    }
}
