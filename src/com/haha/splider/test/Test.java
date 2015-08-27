package com.haha.splider.test;

import java.util.List;

import com.haha.splider.Utils.Type;
import com.haha.splider.bean.NewsItem;
import com.haha.splider.manager.NewsItemManager;

public class Test {
    
    public static void main(String[] args) {
        
        NewsItemManager manager = new NewsItemManager();
        int curPage = 1;  
        
        try {
            
            /**business*/
            List<NewsItem> list;
            list = manager.getNewsItem(Type.BUSINESS, curPage);
            for(NewsItem item : list){
                System.out.println(item);
            }
            
            System.out.println("------------------------");
            
            /**程序员杂志*/
            list = manager.getNewsItem(Type.PROGAMMER, curPage);
            for(NewsItem item : list){
                System.out.println(item);
            }
            
            System.out.println("------------------------");
            
            /**研发*/
            list = manager.getNewsItem(Type.DEV, curPage);
            for(NewsItem item : list){
                System.out.println(item);
            }
            
            System.out.println("------------------------");
            
            /**移动*/
            list = manager.getNewsItem(Type.MOBILE, curPage);
            for(NewsItem item : list){
                System.out.println(item);
            }
            
            System.out.println("------------------------");
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
