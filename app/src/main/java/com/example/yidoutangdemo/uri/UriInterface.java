package com.example.yidoutangdemo.uri;

/**
 * Created by 天一 on 2016/10/31.
 */
public class UriInterface {
    //首页推荐
    public static final String SHOUYE_TUIJIAN = "http://m.yidoutang.com/apiv3/case/photo?page=%d";
    public static String getShouyeTuijian(int page) {
        return String.format(SHOUYE_TUIJIAN,page);
    }

    //首页最新
    public static final String SHOUYE_ZUIXIN = "http://m.yidoutang.com/apiv3/case/photo?dailyhome=1&order=1&page=%d";
    public static String getShouyeZuixin(int page) {
        return String.format(SHOUYE_ZUIXIN,page);
    }

    //筛选
    public static final String SHAIXUAN = "http://m.yidoutang.com/apiv3/case/albumtags";
    public static final String SHAIXUANJIEGUO = "http://m.yidoutang.com/apiv3/case/photo?order=%s&space=%s&style=%s&part=%s";
    //筛选结果
    public static String getSHAIXUAN(String order,String space,String style,String part) {
        return String.format(SHAIXUANJIEGUO,order,space,style,part);
    }

    //评论
    public static final String PINGLUN = "http://m.yidoutang.com/apiv3/case/PhotoComments?match_id=%s";
    public static String getPINGLUN(String matchi_id) {
        return String.format(PINGLUN,matchi_id);
    }

    //搜索的晒家
    public static final String SOUSUO_SHAIJIA = "http://m.yidoutang.com/apiv3/case/search?q=%s&page=%d";
    public static String getSOUSUO_SHAIJIA(String search,int page) {
        return String.format(SOUSUO_SHAIJIA,search,page);
    }
    //搜索的宝贝
    public static final String SOUSUO_BAOBEI = "http://m.yidoutang.com/apiv3/sharing/search?q=%s&page=%d";
    public static String getSOUSUO_BAOBEI(String search,int page) {
        return String.format(SOUSUO_BAOBEI,search,page);
    }
    //搜索的荐货
    public static final String SOUSUO_JIANHUO = "http://m.yidoutang.com/apiv3/community/searchguide?q=%s&page=%d";
    public static String getSOUSUO_JIANHUO(String search,int page) {
        return String.format(SOUSUO_JIANHUO,search,page);
    }



    //推荐
    public static final String TUIJIAN_URL="http://m.yidoutang.com/apiv3/recommend";
    //晒家
    public static final String SHAIJIA_URL="http://m.yidoutang.com/apiv3/case/list?order=0&page=%d";

    //荐货
    public static final String JIANHUO_URL="http://m.yidoutang.com/apiv3/community/guide?recommend_tag=1&page=%d&banner=1";

    //荐货子
    public static final String JIANHUOZI_URL="http://m.yidoutang.com/apiv3/community/guide?recommend_tag=0&page=%d&%s&banner=0";

    //晒家详情
    public static final String SHAIJIAXIANGQING_URL="http://m.yidoutang.com/apiv3/case/detail?id=%s";
    public static String getShaijiaxiangqingUrl(String s) {
        return String.format(SHAIJIAXIANGQING_URL,s);
    }

    //荐货详情
    public  static final String JIANHUOXIANGQING_URL="http://m.yidoutang.com/apiv3/community/detailHtml?tid=%s&with_comment=1";

    //更多
    public  static final String GENGDUO_URL="http://m.yidoutang.com/apiv3/community/guidetags";
    //更多详情1
    public  static final String GENGDUOXAINGQING_URL="http://m.yidoutang.com/apiv3/community/guide?recommend_tag=0&page=%d&tag=%s&banner=0";
    //更多详情2
    public static final String GENGDUOXAINGQING_URL2="http://m.yidoutang.com/apiv3/community/guide?recommend_tag=0&page=%d&class=%s&banner=0";
}
