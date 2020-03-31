package com.human.model;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;

/**
 *  create by hq on 2019/5/9;
 * 用户表
 */

public class  User implements Serializable {

    private static final long serialVersionUID = 8430941165882152228L;
    private Integer user_Id;
    private String user_Name;
    private String user_Password;
    private String user_RealName;
    private String user_Sex;
    private String user_City;
    private String user_IntentionalPost;
    private String user_Email;
    private String UserImg;
    private String user_Status;
    private String user_Resume;
    private String user_Province;

    public String getUser_Province() {
        return user_Province;
    }

    public void setUser_Province(String user_Province) {
        this.user_Province = user_Province;
    }

    public String getUser_Resume() {
        return user_Resume;
    }

    public void setUser_Resume(String user_Resume) {
        this.user_Resume = user_Resume;
    }

    public String getUser_Status() {
        return user_Status;
    }

    public void setUser_Status(String user_Status) {
        this.user_Status = user_Status;
    }

    public String getUser_City() {
        return user_City;
    }

    public void setUser_City(String user_City) {
        this.user_City = user_City;
    }

    public String getUserImg() {
        return UserImg;
    }

    public void setUserImg(String userImg) {
        UserImg = userImg;
    }

    public String getUser_Sex() {
        return user_Sex;
    }

    public void setUser_Sex(String user_Sex) {
        this.user_Sex = user_Sex;
    }


    public Integer getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(Integer user_Id) {
        this.user_Id = user_Id;
    }

    public String getUser_Name() {
        return user_Name;
    }

    public void setUser_Name(String user_Name) {
        this.user_Name = user_Name;
    }

    @JSONField(serialize=false)
    public String getUser_Password() {
        return user_Password;
    }

    public void setUser_Password(String user_Password) {
        this.user_Password = user_Password;
    }

    public String getUser_RealName() {
        return user_RealName;
    }

    public void setUser_RealName(String user_RealName) {
        this.user_RealName = user_RealName;
    }


    public String getUser_IntentionalPost() {
        return user_IntentionalPost;
    }

    public void setUser_IntentionalPost(String user_IntentionalPost) {
        this.user_IntentionalPost = user_IntentionalPost;
    }

    public String getUser_Email() {
        return user_Email;
    }

    public void setUser_Email(String user_Email) {
        this.user_Email = user_Email;
    }
}
