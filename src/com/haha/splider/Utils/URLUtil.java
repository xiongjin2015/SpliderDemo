
package com.haha.splider.Utils;

public final class URLUtil {

    private URLUtil() {
    }

    public final static String NEWS_LIST_URL = "http://www.csdn.net/headlines.html";
    public final static String NEWS_LIST_URL_MOBILE = "http://mobile.csdn.net/mobile";
    public final static String NEWS_LIST_URL_CLOUD = "http://cloud.csdn.net/cloud";
    public final static String NEWS_LIST_URL_PROGRAMMER = "http://programmer.csdn.net/programmer";
    public final static String NEWS_LIST_URL_BUSINESS = "http://news.csdn.net/news";
    public final static String NEWS_LIST_URL_DEV = "http://sd.csdn.net/sd";

    public static String generateUrl(Type type, int curPage) {
        curPage = curPage > 0 ? curPage : 1;
        String url = null;
        switch (type) {
            case BUSINESS:
                url = NEWS_LIST_URL_BUSINESS;
                break;
            case DEV:
                url = NEWS_LIST_URL_DEV;
                break;
            case PROGAMMER:
                url = NEWS_LIST_URL_PROGRAMMER;
                break;
            case CLOUD:
                url = NEWS_LIST_URL_CLOUD;
                break;
            case MOBILE:
                url = NEWS_LIST_URL_MOBILE;
                break;
            default:
                break;
        }

        url += "/" + curPage;

        return url;
    }
}
