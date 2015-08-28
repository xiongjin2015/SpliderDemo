package com.haha.splider.test;

import java.util.List;

import com.haha.splider.bean.News;
import com.haha.splider.bean.NewsDto;
import com.haha.splider.manager.NewsManager;

public class Test01 {
    
    private final static String url = "http://www.csdn.net/article/2014-04-17/2819363-all-about-ddos";
    
    public static void main(String[] args) {

        try{
            NewsManager newsManager = new NewsManager();
            NewsDto newsDto = newsManager.getNews(url);
            
            List<News> newses = newsDto.getNewses();
            for(News news : newses){
                System.out.println(news);
            }
            
            System.out.println("-------------------");
            System.out.println(newsDto.getNextPageUrl());
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
