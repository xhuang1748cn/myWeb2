package cn.srn.web2.repositories.entity.entities.user;

import cn.srn.web2.repositories.entity.entities.Entity;

import java.sql.Timestamp;

/**
 * Created by Winter on 2016/5/17.
 */
public class User extends Entity {

    private Long id; //管理员ID 表主键
    private String realname;  // 管理员账户的真实名字
    private String mobile;  //管理员手机号
    private Integer level;  //管理员级别
    private Long parent;    //管理员上级ID
    private Integer adminStatus;    //管理员状态：1、正常；2、已删除；3、限制登录
    private Timestamp regTime;  //注册时间

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public Integer getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(Integer adminStatus) {
        this.adminStatus = adminStatus;
    }

    public Timestamp getRegTime() {
        return regTime;
    }

    public void setRegTime(Timestamp regTime) {
        this.regTime = regTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", realname='" + realname + '\'' +
                ", mobile='" + mobile + '\'' +
                ", level=" + level +
                ", parent=" + parent +
                ", adminStatus=" + adminStatus +
                ", regTime=" + regTime +
                '}';
    }
}
