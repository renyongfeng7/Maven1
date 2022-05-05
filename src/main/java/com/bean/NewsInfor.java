package com.bean;

import com.alibaba.fastjson.JSONObject;

import java.util.Date;

public class NewsInfor extends Common {

    private static final long serialVersionUID = 4485080709327238577L;

    private Integer newsId;
    private String newsTitle;
    private String newsContent;
    private String newsImg;
    private NewsType newsType;
    private User sendUser;
    private Date sendTime;

    public NewsInfor() {
    }

    public NewsInfor( String newsTitle, String newsContent, String newsImg, NewsType newsType, User sendUser, Date sendTime) {
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsImg = newsImg;
        this.newsType = newsType;
        this.sendUser = sendUser;
        this.sendTime = sendTime;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg;
    }

    public Integer getNewsId() {

        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {

        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public NewsType getNewsType() {
        return newsType;
    }

    public void setNewsType(NewsType newsType) {
        this.newsType = newsType;
    }

    public User getSendUser() {
        return sendUser;
    }

    public void setSendUser(User sendUser) {
        this.sendUser = sendUser;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public String toString() {

        return JSONObject.toJSONString(this);
    }

}
