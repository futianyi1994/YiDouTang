package com.example.yidoutangdemo.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by 天一 on 2016/11/3.
 */
public class SerachJianHuoEntity {

    /**
     * count : {"guide":"134","thread":"0","case":"313","pic":"713","shareing":"3921"}
     * guides : [{"tid":"6818","subject":"夏天睡这样的床才够爽","tagname":"购物攻略","views":8071,"replies":17,"sharings":7,"feature":"http://img.yidoutang.com/upload/community/guide/57a074b946bb4.JPG!app620","header_image":"http://img.yidoutang.com/upload/community/guide/57a074b946bb4.JPG!app620","recommend_note":"","authorid":86200,"author":"phyllis","user_pic":"http://img.yidoutang.com/upload/user//201604/03/201604271749f303.gif","vip":2},{"tid":"5950","subject":"一日之计在于晨，我要在最好的床品上醒来","tagname":"购物攻略","views":10111,"replies":15,"sharings":5,"feature":"http://img.yidoutang.com/upload/community/guide/56de7339e9609.png!app620","header_image":"http://img.yidoutang.com/upload/community/guide/56de73b1aa4fa.png!app620","recommend_note":"","authorid":28627,"author":"小敏宝妈","user_pic":"http://img.yidoutang.com/upload/user//201506/58/2015063018137758.jpg","vip":0},{"tid":"4239","subject":"床品家纺控，睡得舒服比什么都重要","tagname":"购物攻略","views":8498,"replies":20,"sharings":5,"feature":"http://img.yidoutang.com/upload/community/guide/56220656e8f03.png!app620","header_image":"http://img.yidoutang.com/upload/community/guide/562208cea10a8.png!app620","recommend_note":"","authorid":16671,"author":"橘子兄","user_pic":"http://img.yidoutang.com/upload/user//201508/6b/201508171016736b.jpg","vip":0},{"tid":"1567","subject":"【开学季】以宿舍为家  怎能没有一张舒适的床","tagname":"购物攻略","views":7493,"replies":8,"sharings":9,"feature":"http://img.yidoutang.com/upload/community/guide/55d6101424bcd.jpg!app620","header_image":"http://img.yidoutang.com/upload/sharing/normal/201508/4d/201508210155cb4d.jpg!app620","recommend_note":"","authorid":15548,"author":"伊莎","user_pic":"http://img.yidoutang.com/upload/user//201412/83/2014120815149d83.jpg","vip":0},{"tid":"6557","subject":"五五立夏 | 夏天来啦，没床也要打个盹","tagname":"购物攻略","views":2860,"replies":25,"sharings":15,"feature":"http://img.yidoutang.com/upload/community/guide/57285c42d6453.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/57285c42d6453.jpg!app620","recommend_note":"","authorid":24937,"author":"kk","user_pic":"http://img.yidoutang.com/upload/user//201608/5f/2016082516511b5f.jpg","vip":0},{"tid":"1894","subject":"美貌实用兼具的美式床品（回馈群友,有更新）","tagname":"购物攻略","views":22817,"replies":50,"sharings":13,"feature":"http://img.yidoutang.com/upload/sharing/normal/201509/9a/2015091400088c9a.jpg!app620","header_image":"http://img.yidoutang.com/upload/sharing/normal/201509/35/201509140006a135.jpg!app620","recommend_note":"","authorid":11210,"author":"月","user_pic":"http://img.yidoutang.com/upload/user//201405/d6/201405061202e8d6.gif","vip":0},{"tid":"1471","subject":"提升床笫间的性感技能，点燃爱的欲火","tagname":"购物攻略","views":15574,"replies":15,"sharings":11,"feature":"http://img.yidoutang.com/upload/community/guide/55cc81563f785.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/55cd6c1ca1c31.png!app620","recommend_note":"","authorid":35470,"author":"扛饿精神食粮","user_pic":"http://img.yidoutang.com/upload/user//201509/bb/20150909154119bb.jpg","vip":0},{"tid":"1920","subject":"十种不同风格的大床 哪一款是你的最爱（附床单选购攻略）","tagname":"搭配指南","views":18245,"replies":21,"sharings":11,"feature":"http://img.yidoutang.com/upload/community/guide/55f7e5080f87e.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/55f7e539181b9.JPG!app620","recommend_note":"","authorid":24944,"author":"糖主","user_pic":"http://img.yidoutang.com/upload/user//201609/f3/201609071450f7f3.jpg","vip":0},{"tid":"7128","subject":"原来\u201c滚床单\u201d和\u201c滚\u201d只差一套好床品的距离","tagname":"购物攻略","views":2591,"replies":22,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5811e6df5dd1e.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/5811e6937fa88.jpg!app620","recommend_note":"","authorid":24944,"author":"糖主","user_pic":"http://img.yidoutang.com/upload/user//201609/f3/201609071450f7f3.jpg","vip":0},{"tid":"5523","subject":"睡得好扛百病，盘点那些一看就想裸睡的床品","tagname":"购物攻略","views":9370,"replies":28,"sharings":4,"feature":"http://img.yidoutang.com/upload/community/guide/56c4393ef05c8.png!app620","header_image":"http://img.yidoutang.com/upload/community/guide/56c4393ef05c8.png!app620","recommend_note":"","authorid":15555,"author":"Hello树先生","user_pic":"http://img.yidoutang.com/upload/user//201412/ef/2014120816088fef.jpg","vip":0},{"tid":"6976","subject":"床对厕所、房门对房门\u2026之前说好的风水疑难答案全在这","tagname":"风水宝典","views":11841,"replies":15,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/57d92a407ff55.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/57d92a43b827b.jpg!app620","recommend_note":"","authorid":24944,"author":"糖主","user_pic":"http://img.yidoutang.com/upload/user//201609/f3/201609071450f7f3.jpg","vip":0},{"tid":"827","subject":"早晨起不来床 没关系有它们让你清爽一早晨 各种创意闹钟小推荐","tagname":"购物攻略","views":5259,"replies":7,"sharings":5,"feature":"http://img.yidoutang.com/upload/community/guide/55ac5df9a15ae.gif!app620","header_image":"http://img.yidoutang.com/upload/community/guide/55ac5dfb9285b.jpg!app620","recommend_note":"","authorid":28988,"author":"温暖的家","user_pic":"http://img.yidoutang.com/upload/user//201507/8a/201507100806ce8a.gif","vip":2}]
     * pagination : {"record_count":134,"page_count":12,"first":1,"last":12,"next":2,"prev":1,"current":1,"page_size":12,"page_base":1}
     */

    private DataBean data;
    /**
     * data : {"count":{"guide":"134","thread":"0","case":"313","pic":"713","shareing":"3921"},"guides":[{"tid":"6818","subject":"夏天睡这样的床才够爽","tagname":"购物攻略","views":8071,"replies":17,"sharings":7,"feature":"http://img.yidoutang.com/upload/community/guide/57a074b946bb4.JPG!app620","header_image":"http://img.yidoutang.com/upload/community/guide/57a074b946bb4.JPG!app620","recommend_note":"","authorid":86200,"author":"phyllis","user_pic":"http://img.yidoutang.com/upload/user//201604/03/201604271749f303.gif","vip":2},{"tid":"5950","subject":"一日之计在于晨，我要在最好的床品上醒来","tagname":"购物攻略","views":10111,"replies":15,"sharings":5,"feature":"http://img.yidoutang.com/upload/community/guide/56de7339e9609.png!app620","header_image":"http://img.yidoutang.com/upload/community/guide/56de73b1aa4fa.png!app620","recommend_note":"","authorid":28627,"author":"小敏宝妈","user_pic":"http://img.yidoutang.com/upload/user//201506/58/2015063018137758.jpg","vip":0},{"tid":"4239","subject":"床品家纺控，睡得舒服比什么都重要","tagname":"购物攻略","views":8498,"replies":20,"sharings":5,"feature":"http://img.yidoutang.com/upload/community/guide/56220656e8f03.png!app620","header_image":"http://img.yidoutang.com/upload/community/guide/562208cea10a8.png!app620","recommend_note":"","authorid":16671,"author":"橘子兄","user_pic":"http://img.yidoutang.com/upload/user//201508/6b/201508171016736b.jpg","vip":0},{"tid":"1567","subject":"【开学季】以宿舍为家  怎能没有一张舒适的床","tagname":"购物攻略","views":7493,"replies":8,"sharings":9,"feature":"http://img.yidoutang.com/upload/community/guide/55d6101424bcd.jpg!app620","header_image":"http://img.yidoutang.com/upload/sharing/normal/201508/4d/201508210155cb4d.jpg!app620","recommend_note":"","authorid":15548,"author":"伊莎","user_pic":"http://img.yidoutang.com/upload/user//201412/83/2014120815149d83.jpg","vip":0},{"tid":"6557","subject":"五五立夏 | 夏天来啦，没床也要打个盹","tagname":"购物攻略","views":2860,"replies":25,"sharings":15,"feature":"http://img.yidoutang.com/upload/community/guide/57285c42d6453.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/57285c42d6453.jpg!app620","recommend_note":"","authorid":24937,"author":"kk","user_pic":"http://img.yidoutang.com/upload/user//201608/5f/2016082516511b5f.jpg","vip":0},{"tid":"1894","subject":"美貌实用兼具的美式床品（回馈群友,有更新）","tagname":"购物攻略","views":22817,"replies":50,"sharings":13,"feature":"http://img.yidoutang.com/upload/sharing/normal/201509/9a/2015091400088c9a.jpg!app620","header_image":"http://img.yidoutang.com/upload/sharing/normal/201509/35/201509140006a135.jpg!app620","recommend_note":"","authorid":11210,"author":"月","user_pic":"http://img.yidoutang.com/upload/user//201405/d6/201405061202e8d6.gif","vip":0},{"tid":"1471","subject":"提升床笫间的性感技能，点燃爱的欲火","tagname":"购物攻略","views":15574,"replies":15,"sharings":11,"feature":"http://img.yidoutang.com/upload/community/guide/55cc81563f785.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/55cd6c1ca1c31.png!app620","recommend_note":"","authorid":35470,"author":"扛饿精神食粮","user_pic":"http://img.yidoutang.com/upload/user//201509/bb/20150909154119bb.jpg","vip":0},{"tid":"1920","subject":"十种不同风格的大床 哪一款是你的最爱（附床单选购攻略）","tagname":"搭配指南","views":18245,"replies":21,"sharings":11,"feature":"http://img.yidoutang.com/upload/community/guide/55f7e5080f87e.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/55f7e539181b9.JPG!app620","recommend_note":"","authorid":24944,"author":"糖主","user_pic":"http://img.yidoutang.com/upload/user//201609/f3/201609071450f7f3.jpg","vip":0},{"tid":"7128","subject":"原来\u201c滚床单\u201d和\u201c滚\u201d只差一套好床品的距离","tagname":"购物攻略","views":2591,"replies":22,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5811e6df5dd1e.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/5811e6937fa88.jpg!app620","recommend_note":"","authorid":24944,"author":"糖主","user_pic":"http://img.yidoutang.com/upload/user//201609/f3/201609071450f7f3.jpg","vip":0},{"tid":"5523","subject":"睡得好扛百病，盘点那些一看就想裸睡的床品","tagname":"购物攻略","views":9370,"replies":28,"sharings":4,"feature":"http://img.yidoutang.com/upload/community/guide/56c4393ef05c8.png!app620","header_image":"http://img.yidoutang.com/upload/community/guide/56c4393ef05c8.png!app620","recommend_note":"","authorid":15555,"author":"Hello树先生","user_pic":"http://img.yidoutang.com/upload/user//201412/ef/2014120816088fef.jpg","vip":0},{"tid":"6976","subject":"床对厕所、房门对房门\u2026之前说好的风水疑难答案全在这","tagname":"风水宝典","views":11841,"replies":15,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/57d92a407ff55.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/57d92a43b827b.jpg!app620","recommend_note":"","authorid":24944,"author":"糖主","user_pic":"http://img.yidoutang.com/upload/user//201609/f3/201609071450f7f3.jpg","vip":0},{"tid":"827","subject":"早晨起不来床 没关系有它们让你清爽一早晨 各种创意闹钟小推荐","tagname":"购物攻略","views":5259,"replies":7,"sharings":5,"feature":"http://img.yidoutang.com/upload/community/guide/55ac5df9a15ae.gif!app620","header_image":"http://img.yidoutang.com/upload/community/guide/55ac5dfb9285b.jpg!app620","recommend_note":"","authorid":28988,"author":"温暖的家","user_pic":"http://img.yidoutang.com/upload/user//201507/8a/201507100806ce8a.gif","vip":2}],"pagination":{"record_count":134,"page_count":12,"first":1,"last":12,"next":2,"prev":1,"current":1,"page_size":12,"page_base":1}}
     * error : false
     * message : success
     */

    private boolean error;
    private String message;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * guide : 134
         * thread : 0
         * case : 313
         * pic : 713
         * shareing : 3921
         */

        private CountBean count;
        /**
         * record_count : 134
         * page_count : 12
         * first : 1
         * last : 12
         * next : 2
         * prev : 1
         * current : 1
         * page_size : 12
         * page_base : 1
         */

        private PaginationBean pagination;
        /**
         * tid : 6818
         * subject : 夏天睡这样的床才够爽
         * tagname : 购物攻略
         * views : 8071
         * replies : 17
         * sharings : 7
         * feature : http://img.yidoutang.com/upload/community/guide/57a074b946bb4.JPG!app620
         * header_image : http://img.yidoutang.com/upload/community/guide/57a074b946bb4.JPG!app620
         * recommend_note :
         * authorid : 86200
         * author : phyllis
         * user_pic : http://img.yidoutang.com/upload/user//201604/03/201604271749f303.gif
         * vip : 2
         */

        private List<GuidesBean> guides;

        public CountBean getCount() {
            return count;
        }

        public void setCount(CountBean count) {
            this.count = count;
        }

        public PaginationBean getPagination() {
            return pagination;
        }

        public void setPagination(PaginationBean pagination) {
            this.pagination = pagination;
        }

        public List<GuidesBean> getGuides() {
            return guides;
        }

        public void setGuides(List<GuidesBean> guides) {
            this.guides = guides;
        }

        public static class CountBean {
            private String guide;
            private String thread;
            @JSONField(name = "case")
            private String caseX;
            private String pic;
            private String shareing;

            public String getGuide() {
                return guide;
            }

            public void setGuide(String guide) {
                this.guide = guide;
            }

            public String getThread() {
                return thread;
            }

            public void setThread(String thread) {
                this.thread = thread;
            }

            public String getCaseX() {
                return caseX;
            }

            public void setCaseX(String caseX) {
                this.caseX = caseX;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getShareing() {
                return shareing;
            }

            public void setShareing(String shareing) {
                this.shareing = shareing;
            }
        }

        public static class PaginationBean {
            private int record_count;
            private int page_count;
            private int first;
            private int last;
            private int next;
            private int prev;
            private int current;
            private int page_size;
            private int page_base;

            public int getRecord_count() {
                return record_count;
            }

            public void setRecord_count(int record_count) {
                this.record_count = record_count;
            }

            public int getPage_count() {
                return page_count;
            }

            public void setPage_count(int page_count) {
                this.page_count = page_count;
            }

            public int getFirst() {
                return first;
            }

            public void setFirst(int first) {
                this.first = first;
            }

            public int getLast() {
                return last;
            }

            public void setLast(int last) {
                this.last = last;
            }

            public int getNext() {
                return next;
            }

            public void setNext(int next) {
                this.next = next;
            }

            public int getPrev() {
                return prev;
            }

            public void setPrev(int prev) {
                this.prev = prev;
            }

            public int getCurrent() {
                return current;
            }

            public void setCurrent(int current) {
                this.current = current;
            }

            public int getPage_size() {
                return page_size;
            }

            public void setPage_size(int page_size) {
                this.page_size = page_size;
            }

            public int getPage_base() {
                return page_base;
            }

            public void setPage_base(int page_base) {
                this.page_base = page_base;
            }
        }

        public static class GuidesBean {
            private String tid;
            private String subject;
            private String tagname;
            private int views;
            private int replies;
            private int sharings;
            private String feature;
            private String header_image;
            private String recommend_note;
            private int authorid;
            private String author;
            private String user_pic;
            private int vip;

            public String getTid() {
                return tid;
            }

            public void setTid(String tid) {
                this.tid = tid;
            }

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }

            public String getTagname() {
                return tagname;
            }

            public void setTagname(String tagname) {
                this.tagname = tagname;
            }

            public int getViews() {
                return views;
            }

            public void setViews(int views) {
                this.views = views;
            }

            public int getReplies() {
                return replies;
            }

            public void setReplies(int replies) {
                this.replies = replies;
            }

            public int getSharings() {
                return sharings;
            }

            public void setSharings(int sharings) {
                this.sharings = sharings;
            }

            public String getFeature() {
                return feature;
            }

            public void setFeature(String feature) {
                this.feature = feature;
            }

            public String getHeader_image() {
                return header_image;
            }

            public void setHeader_image(String header_image) {
                this.header_image = header_image;
            }

            public String getRecommend_note() {
                return recommend_note;
            }

            public void setRecommend_note(String recommend_note) {
                this.recommend_note = recommend_note;
            }

            public int getAuthorid() {
                return authorid;
            }

            public void setAuthorid(int authorid) {
                this.authorid = authorid;
            }

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getUser_pic() {
                return user_pic;
            }

            public void setUser_pic(String user_pic) {
                this.user_pic = user_pic;
            }

            public int getVip() {
                return vip;
            }

            public void setVip(int vip) {
                this.vip = vip;
            }
        }
    }
}
