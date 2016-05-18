package cn.srn.web2.response.user;

import cn.srn.web2.errorinfo.ErrorInfo;
import cn.srn.web2.response.ResponseInfo;

/**
 * Created by Winter on 2016/5/16.
 */
public class UserInfo extends ResponseInfo {

    private long id;
    private String name;

    public UserInfo() {
    }

    public UserInfo(ErrorInfo errorInfo, long id, String name) {
        super(errorInfo);
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserInfo{" + super.toString() +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
