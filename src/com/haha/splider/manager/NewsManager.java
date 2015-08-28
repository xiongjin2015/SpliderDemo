package com.haha.splider.manager;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.haha.splider.Utils.DataUtil;
import com.haha.splider.bean.News;
import com.haha.splider.bean.News.NewsType;
import com.haha.splider.bean.NewsDto;

/**
 * 把html字符串转换成List对象
 *
 */
public class NewsManager {
    
    public NewsDto getNews(String urlStr) throws Exception{
        NewsDto newsDto = new NewsDto();
        List<News> newses = new ArrayList<News>();
        String htmlStr = DataUtil.doGet(urlStr);
        Document doc = Jsoup.parse(htmlStr);
        
        /**获取文章中的第一个detail*/
        Element detailEle = doc.select(".left .detail").get(0);
        /**标题*/
        Element titleEle = detailEle.select("h1.title").get(0);
        News news = new News();
        news.setTitle(titleEle.text());
        news.setType(NewsType.TITLE);
        newses.add(news);
        
        /**摘要*/
        Element summaryEle = detailEle.select("div.summary").get(0);
        news = new News();
        news.setSummary(summaryEle.text());
        newses.add(news);
        
        /**内容*/
        Element contentEle = detailEle.select("div.con.news_content").get(0);
        Elements childrenEle = contentEle.children();
        
        for(Element child : childrenEle){
            Elements imgEles = child.getElementsByTag("img");
            /**图片*/
            if(imgEles.size()>0){
                for(Element imgEle : imgEles){
                    if(imgEle.attr("src").equals(""))
                        continue;
                    news = new News();
                    news.setImgUrl(imgEle.attr("src"));
                    newses.add(news);
                }
            }
            /**移除图片*/
            imgEles.remove();
            
            if(child.text().equals(""))
                continue;
            
            news = new News();
            news.setType(NewsType.CONTENT);
            
            try{
                if(child.children().size() == 1){
                    Element cc = child.child(0);
                    if("b".equals(cc.tagName())){
                        news.setType(NewsType.BOLD_TITLE);
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }
            
            news.setContent(child.outerHtml());
            newses.add(news);
        }
        
        newsDto.setNewses(newses);
        
        return newsDto;
        
    }

}
