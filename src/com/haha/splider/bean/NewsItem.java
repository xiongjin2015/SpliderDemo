package com.haha.splider.bean;

import com.haha.splider.Utils.Type;

public class NewsItem {
    
    private int id;
    
    /**标题*/
    private String title;
    
    /**链接*/
    private String link;
    
    /**发布日期*/
    private String date;
    
    /**图片的链接*/
    private String imgUrl;
    
    /**内容*/
    private String content;
    
    /**类型*/
    private Type newsType;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Type getNewsType() {
        return newsType;
    }

    public void setNewsType(Type newsType) {
        this.newsType = newsType;
    }

    @Override
    public String toString() {
        return "NewsItem [id=" + id + ", title=" + title + ", link=" + link + ", date=" + date
                + ", imgUrl=" + imgUrl + ", content=" + content + ", newsType=" + newsType + "]";
    }
    

    
}
