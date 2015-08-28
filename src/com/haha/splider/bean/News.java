package com.haha.splider.bean;

public class News {
    
    public static interface NewsType{
        
        public final static int TITLE = 1;
        public final static int SUMMARY = 2;
        public final static int CONTENT = 3;
        public final static int IMG = 4;
        public final static int BOLD_TITLE = 5;
        
    }
    
    /**标题*/
    private String title;
    
    /**摘要*/
    private String summary;
    
    /**内容*/
    private String content;
    
    /**图片链接*/
    private String imgUrl;
    
    /**类型*/
    private int type;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
        this.type = NewsType.SUMMARY;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        this.type = NewsType.IMG;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "News [title=" + title + ", summary=" + summary + ", content=" + content
                + ", imgUrl=" + imgUrl + ", type=" + type + "]";
    }

    
}
