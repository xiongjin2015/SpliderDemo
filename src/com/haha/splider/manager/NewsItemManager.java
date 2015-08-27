package com.haha.splider.manager;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.haha.splider.Utils.DataUtil;
import com.haha.splider.Utils.Type;
import com.haha.splider.Utils.URLUtil;
import com.haha.splider.bean.NewsItem;

/**
 * 产生newItem的业务类：
 * 核心的splider类：核心的爬虫业务
 *
 */
public class NewsItemManager {
    
    /**
     * 获取相应的类型文章列表
     * @param type
     * @param curPage
     * @return
     * @throws Exception
     */
    public List<NewsItem> getNewsItem(Type type,int curPage) throws Exception{
        
        String url = URLUtil.generateUrl(type, curPage);
        String htmlStr = DataUtil.doGet(url);
        
        List<NewsItem> list = new ArrayList<NewsItem>();
        NewsItem newsItem = null;
        
        Document doc = Jsoup.parse(htmlStr);
        Elements units = doc.getElementsByClass("unit");
        
        for(int i=0; i<units.size();i++){
            
            newsItem = new NewsItem();
            newsItem.setNewsType(type);
            
            Element unit_ele = units.get(i);
            
            Element h1_ele = unit_ele.getElementsByTag("h1").get(0);
            Element h1_a_ele = h1_ele.child(0);
            String title = h1_a_ele.text();
            String href = h1_a_ele.attr("href");
            
            newsItem.setLink(href);
            newsItem.setTitle(title);
            
            Element h4_ele = unit_ele.getElementsByTag("h4").get(0);
            Element ago_ele = h4_ele.getElementsByClass("ago").get(0);
            String date = ago_ele.text();
            
            newsItem.setDate(date);
            
            Element dl_ele = unit_ele.getElementsByTag("dl").get(0);//dl
            Element dt_ele = dl_ele.child(0);//dt
            try{
                //可能没有图片
                Element img_ele = dt_ele.child(0);
                String imgUrl = img_ele.child(0).attr("src");
                newsItem.setImgUrl(imgUrl);
            }catch(Exception e){
                //e.printStackTrace();
            }
            
            Element content_ele = dl_ele.child(1); //dd
            String content = content_ele.text();
            newsItem.setContent(content);
            list.add(newsItem);
        }
        
        return list;
                
    }

}
