package com.bean;

import com.alibaba.fastjson.JSONObject;

/*类与表对象；
* 属性与列对应；
* 对象与行对应；
* 使用包装类；
* 实现序列化接口；
* */

public class User extends Common{

    private static final long serialVersionUID = 7812975645366858713L;
    private Integer userId;
    private String realName;
    private String userName;
    private String userPwd;
    /*新添加用户角色--*/
    private Role role;
    public User() {
    }

    public User(Integer userId, String realName, String userName, String userPwd) {
        this.userId = userId;
        this.realName = realName;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public User(String realName, String userName, String userPwd) {
        this.realName = realName;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public User(Integer userId, String realName, String userName, String userPwd, Role role) {
        this.userId = userId;
        this.realName = realName;
        this.userName = userName;
        this.userPwd = userPwd;
        this.role = role;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

/* public String toString() {
        return "User{" +
                "userId=" + userId +
                ", realName='" + realName + '\'' +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }*/

/*重写toString*/
    public String toString() {
        return JSONObject.toJSONString( this);

    }
}
