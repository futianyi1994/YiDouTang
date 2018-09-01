package com.example.yidoutangdemo.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by 天一 on 2016/11/3.
 */
public class SerachShaiJiaEntity {


   /**
     * count : {"thread":"0","guide":"134","case":"313","pic":"712","shareing":"3921"}
     * cases : [{"user_name":"小洗","user_pic":"http://img.yidoutang.com/upload/user//201303/58/2013030415549758.gif","group_id":"1146","type":"1","title":"1.8米大床是一定要的！背景墙用的是螺旋纹理壁纸，浅紫色图案和窗帘的颜色非常协调，灯具与房间的格调相得益彰。","user_id":"3587","image":"http://img.yidoutang.com/upload/match/normal/51fbae8164886.jpg!app620","cover":"/upload/match/normal/51fbae8164886.jpg","style":"现代简约","size":"四居室","comment_num":"259","share_num":"10","like_num":"139","sharing_num":"14","click_num":"32253","created":"1372685908","header_image":"http://img.yidoutang.com/upload/match/normal/51fbae8164886.jpg!app620"},{"user_name":"helloCYH","user_pic":"http://img.yidoutang.com/upload/user//201507/32/2015072015577532.jpg","group_id":"161136","type":"1","title":"金窝银窝，不及让我欲罢不能的狗窝~~","user_id":"29620","image":"http://img.yidoutang.com/upload/match/normal/201601/ba/20160128134333c0ba.jpg!app620","cover":"/upload/match/normal/201601/ba/20160128134333c0ba.jpg","style":"其他风格","size":"单身公寓","comment_num":"85","share_num":"37","like_num":"326","sharing_num":"39","click_num":"17049","created":"1453960321","header_image":"http://img.yidoutang.com/upload/match/normal/201601/ba/20160128134333c0ba.jpg!app620"},{"user_name":"糖 饼","user_pic":"http://img.yidoutang.com/upload/user//201503/9e/201503200928139e.gif","group_id":"35565","type":"1","title":"自己的小家  自己混搭   ","user_id":"4256","image":"http://img.yidoutang.com/upload/match/normal/5361a88b48c91.JPG!app620","cover":null,"style":"混搭","size":"两居室","comment_num":"231","share_num":"7","like_num":"109","sharing_num":"11","click_num":"17898","created":"1398861407","header_image":"http://img.yidoutang.com/upload/match/normal/5361a88b48c91.JPG!app620"},{"user_name":"江超","user_pic":"http://img.yidoutang.com/upload/user//201609/86/201609091037b186.gif","group_id":"292423","type":"1","title":"嘉莉朵的甜蜜  我们家的美式田园风","user_id":"153039","image":"http://img.yidoutang.com/upload/match/normal/201609/f1/201609091133310ef1.jpg!app620","cover":"/upload/match/normal/201609/f1/201609091133310ef1.jpg","style":"美式","size":"两居室","comment_num":"139","share_num":"54","like_num":"179","sharing_num":"2","click_num":"16918","created":"1473402661","header_image":"http://img.yidoutang.com/upload/match/normal/201609/f1/201609091133310ef1.jpg!app620"},{"user_name":"Lava_楽天","user_pic":"http://img.yidoutang.com/upload/user//201410/c5/2014102115550fc5.gif","group_id":"99219","type":"1","title":"上海老公房 33平方超小户型装修毕业照","user_id":"14788","image":"http://img.yidoutang.com/upload/match/normal/544624dfcabb1.jpg!app620","cover":"/upload/match/normal/544624dfcabb1.jpg","style":"北欧","size":"一居室","comment_num":"304","share_num":"568","like_num":"961","sharing_num":"32","click_num":"71406","created":"1413885725","header_image":"http://img.yidoutang.com/upload/match/normal/544624dfcabb1.jpg!app620"},{"user_name":"Omani","user_pic":"http://img.yidoutang.com/upload/user//201412/38/2014120814599238.jpg","group_id":"85305","type":"1","title":"旧房改造田园风一居室爱巢","user_id":"13876","image":"http://img.yidoutang.com/upload/match/normal/54266bd02d39c.jpg!app620","cover":null,"style":"田园风尚","size":"一居室","comment_num":"45","share_num":"37","like_num":"45","sharing_num":"12","click_num":"9268","created":"1411804371","header_image":"http://img.yidoutang.com/upload/match/normal/54266bd02d39c.jpg!app620"},{"user_name":"唇上一支烟","user_pic":"http://img.yidoutang.com/upload/user//201307/24/201307311506a424.gif","group_id":"30752","type":"1","title":" 两个天秤座的混搭美家","user_id":"5897","image":"http://img.yidoutang.com/upload/match/normal/5333bdeb4056d.jpg!app620","cover":null,"style":"地中海","size":"两居室","comment_num":"8","share_num":"18","like_num":"82","sharing_num":"11","click_num":"13910","created":"1395899731","header_image":"http://img.yidoutang.com/upload/match/normal/5333bdeb4056d.jpg!app620"},{"user_name":"lancylala","user_pic":"http://img.yidoutang.com/upload/user//201603/47/201603311814d147.gif","group_id":"169625","type":"1","title":"租了个30平的小户型，5000块搞定！","user_id":"77449","image":"http://img.yidoutang.com/upload/match/normal/201603/3b/20160331192745c03b.jpg!app620","cover":null,"style":"混搭","size":"单身公寓","comment_num":"20","share_num":"32","like_num":"59","sharing_num":"0","click_num":"7557","created":"1459424056","header_image":"http://img.yidoutang.com/upload/match/normal/201603/3b/20160331192745c03b.jpg!app620"},{"user_name":"葡萄","user_pic":"http://img.yidoutang.com/upload/user//201412/3c/201412061621b43c.jpg","group_id":"34548","type":"2","title":"【天涯群醉美家】葡萄姐姐的美式乡村混搭之家~","user_id":"9913","image":"http://img.yidoutang.com/upload/match/normal/5358a1b49ff2c.jpg!app620","cover":null,"style":"混搭","size":"三居室","comment_num":"89","share_num":"9","like_num":"91","sharing_num":"5","click_num":"18885","created":"1398317514","header_image":"http://img.yidoutang.com/upload/match/normal/5358a1b49ff2c.jpg!app620"},{"user_name":"小洗","user_pic":"http://img.yidoutang.com/upload/user//201303/58/2013030415549758.gif","group_id":"7143","type":"1","title":"蓝色调调的童房，晚上有星星的墙纸","user_id":"3587","image":"http://img.yidoutang.com/upload/match/normal/52194e113f431.JPG!app620","cover":"/upload/match/normal/52194e113f431.JPG","style":"现代简约","size":"四居室","comment_num":"125","share_num":"30","like_num":"64","sharing_num":"12","click_num":"23800","created":"1377388956","header_image":"http://img.yidoutang.com/upload/match/normal/52194e113f431.JPG!app620"},{"user_name":"蒋丽萍","user_pic":"http://img.yidoutang.com/upload/user//201611/6b/201611011620456b.jpg","group_id":"306356","type":"5","title":"新春宠物篇第一季","user_id":"156262","image":"http://img.yidoutang.com/upload/match/normal/201609/00/201609231656068800.jpg!app620","cover":"/upload/match/normal/201609/00/201609231656068800.jpg","style":"北欧","size":"三居室","comment_num":"33","share_num":"36","like_num":"117","sharing_num":"0","click_num":"5395","created":"1474623949","header_image":"http://img.yidoutang.com/upload/match/normal/201609/00/201609231656068800.jpg!app620"},{"user_name":"云朵儿","user_pic":"http://img.yidoutang.com/upload/user//201607/a0/20160718161185a0.gif","group_id":"273091","type":"1","title":"儿童房增加移动衣柜和两米黑板墙就大变样了，棒棒哒！","user_id":"133040","image":"http://img.yidoutang.com/upload/match/normal/201608/3f/20160823142719da3f.jpg!app620","cover":"/upload/match/normal/201608/3f/20160823142719da3f.jpg","style":"宜家","size":"两居室","comment_num":"19","share_num":"10","like_num":"86","sharing_num":"2","click_num":"4372","created":"1471934420","header_image":"http://img.yidoutang.com/upload/match/normal/201608/3f/20160823142719da3f.jpg!app620"},{"user_name":"九艺阳光","user_pic":"http://img.yidoutang.com/upload/user//201307/cc/201307020942d8cc.gif","group_id":"1166","type":"1","title":"只要认真，用心。其实网购也可以打造一个别致的家","user_id":"27","image":"http://img.yidoutang.com/upload/match/normal/51dd04dec1ec4.jpg!app620","cover":null,"style":"现代简约","size":"三居室","comment_num":"45","share_num":"10","like_num":"91","sharing_num":"28","click_num":"20518","created":"1373439315","header_image":"http://img.yidoutang.com/upload/match/normal/51dd04dec1ec4.jpg!app620"},{"user_name":"多多","user_pic":"http://img.yidoutang.com/upload/user//201512/9d/201512021446f99d.jpg","group_id":"150317","type":"1","title":"♥♥♥♥♥文艺暖心的北欧小窝，装修毕业照","user_id":"25681","image":"http://img.yidoutang.com/upload/match/normal/565e8d0c6a19b.jpg!app620","cover":"/upload/match/normal/565e8d0c6a19b.jpg","style":"北欧","size":"两居室","comment_num":"353","share_num":"273","like_num":"1147","sharing_num":"12","click_num":"45294","created":"1449037398","header_image":"http://img.yidoutang.com/upload/match/normal/565e8d0c6a19b.jpg!app620"}]
     * pagination : {"record_count":313,"page_count":21,"first":1,"last":21,"next":2,"prev":1,"current":1,"page_size":15,"page_base":1}
     */

    private DataBean data;
    /**
     * data : {"count":{"thread":"0","guide":"134","case":"313","pic":"712","shareing":"3921"},"cases":[{"user_name":"小洗","user_pic":"http://img.yidoutang.com/upload/user//201303/58/2013030415549758.gif","group_id":"1146","type":"1","title":"1.8米大床是一定要的！背景墙用的是螺旋纹理壁纸，浅紫色图案和窗帘的颜色非常协调，灯具与房间的格调相得益彰。","user_id":"3587","image":"http://img.yidoutang.com/upload/match/normal/51fbae8164886.jpg!app620","cover":"/upload/match/normal/51fbae8164886.jpg","style":"现代简约","size":"四居室","comment_num":"259","share_num":"10","like_num":"139","sharing_num":"14","click_num":"32253","created":"1372685908","header_image":"http://img.yidoutang.com/upload/match/normal/51fbae8164886.jpg!app620"},{"user_name":"helloCYH","user_pic":"http://img.yidoutang.com/upload/user//201507/32/2015072015577532.jpg","group_id":"161136","type":"1","title":"金窝银窝，不及让我欲罢不能的狗窝~~","user_id":"29620","image":"http://img.yidoutang.com/upload/match/normal/201601/ba/20160128134333c0ba.jpg!app620","cover":"/upload/match/normal/201601/ba/20160128134333c0ba.jpg","style":"其他风格","size":"单身公寓","comment_num":"85","share_num":"37","like_num":"326","sharing_num":"39","click_num":"17049","created":"1453960321","header_image":"http://img.yidoutang.com/upload/match/normal/201601/ba/20160128134333c0ba.jpg!app620"},{"user_name":"糖 饼","user_pic":"http://img.yidoutang.com/upload/user//201503/9e/201503200928139e.gif","group_id":"35565","type":"1","title":"自己的小家  自己混搭   ","user_id":"4256","image":"http://img.yidoutang.com/upload/match/normal/5361a88b48c91.JPG!app620","cover":null,"style":"混搭","size":"两居室","comment_num":"231","share_num":"7","like_num":"109","sharing_num":"11","click_num":"17898","created":"1398861407","header_image":"http://img.yidoutang.com/upload/match/normal/5361a88b48c91.JPG!app620"},{"user_name":"江超","user_pic":"http://img.yidoutang.com/upload/user//201609/86/201609091037b186.gif","group_id":"292423","type":"1","title":"嘉莉朵的甜蜜  我们家的美式田园风","user_id":"153039","image":"http://img.yidoutang.com/upload/match/normal/201609/f1/201609091133310ef1.jpg!app620","cover":"/upload/match/normal/201609/f1/201609091133310ef1.jpg","style":"美式","size":"两居室","comment_num":"139","share_num":"54","like_num":"179","sharing_num":"2","click_num":"16918","created":"1473402661","header_image":"http://img.yidoutang.com/upload/match/normal/201609/f1/201609091133310ef1.jpg!app620"},{"user_name":"Lava_楽天","user_pic":"http://img.yidoutang.com/upload/user//201410/c5/2014102115550fc5.gif","group_id":"99219","type":"1","title":"上海老公房 33平方超小户型装修毕业照","user_id":"14788","image":"http://img.yidoutang.com/upload/match/normal/544624dfcabb1.jpg!app620","cover":"/upload/match/normal/544624dfcabb1.jpg","style":"北欧","size":"一居室","comment_num":"304","share_num":"568","like_num":"961","sharing_num":"32","click_num":"71406","created":"1413885725","header_image":"http://img.yidoutang.com/upload/match/normal/544624dfcabb1.jpg!app620"},{"user_name":"Omani","user_pic":"http://img.yidoutang.com/upload/user//201412/38/2014120814599238.jpg","group_id":"85305","type":"1","title":"旧房改造田园风一居室爱巢","user_id":"13876","image":"http://img.yidoutang.com/upload/match/normal/54266bd02d39c.jpg!app620","cover":null,"style":"田园风尚","size":"一居室","comment_num":"45","share_num":"37","like_num":"45","sharing_num":"12","click_num":"9268","created":"1411804371","header_image":"http://img.yidoutang.com/upload/match/normal/54266bd02d39c.jpg!app620"},{"user_name":"唇上一支烟","user_pic":"http://img.yidoutang.com/upload/user//201307/24/201307311506a424.gif","group_id":"30752","type":"1","title":" 两个天秤座的混搭美家","user_id":"5897","image":"http://img.yidoutang.com/upload/match/normal/5333bdeb4056d.jpg!app620","cover":null,"style":"地中海","size":"两居室","comment_num":"8","share_num":"18","like_num":"82","sharing_num":"11","click_num":"13910","created":"1395899731","header_image":"http://img.yidoutang.com/upload/match/normal/5333bdeb4056d.jpg!app620"},{"user_name":"lancylala","user_pic":"http://img.yidoutang.com/upload/user//201603/47/201603311814d147.gif","group_id":"169625","type":"1","title":"租了个30平的小户型，5000块搞定！","user_id":"77449","image":"http://img.yidoutang.com/upload/match/normal/201603/3b/20160331192745c03b.jpg!app620","cover":null,"style":"混搭","size":"单身公寓","comment_num":"20","share_num":"32","like_num":"59","sharing_num":"0","click_num":"7557","created":"1459424056","header_image":"http://img.yidoutang.com/upload/match/normal/201603/3b/20160331192745c03b.jpg!app620"},{"user_name":"葡萄","user_pic":"http://img.yidoutang.com/upload/user//201412/3c/201412061621b43c.jpg","group_id":"34548","type":"2","title":"【天涯群醉美家】葡萄姐姐的美式乡村混搭之家~","user_id":"9913","image":"http://img.yidoutang.com/upload/match/normal/5358a1b49ff2c.jpg!app620","cover":null,"style":"混搭","size":"三居室","comment_num":"89","share_num":"9","like_num":"91","sharing_num":"5","click_num":"18885","created":"1398317514","header_image":"http://img.yidoutang.com/upload/match/normal/5358a1b49ff2c.jpg!app620"},{"user_name":"小洗","user_pic":"http://img.yidoutang.com/upload/user//201303/58/2013030415549758.gif","group_id":"7143","type":"1","title":"蓝色调调的童房，晚上有星星的墙纸","user_id":"3587","image":"http://img.yidoutang.com/upload/match/normal/52194e113f431.JPG!app620","cover":"/upload/match/normal/52194e113f431.JPG","style":"现代简约","size":"四居室","comment_num":"125","share_num":"30","like_num":"64","sharing_num":"12","click_num":"23800","created":"1377388956","header_image":"http://img.yidoutang.com/upload/match/normal/52194e113f431.JPG!app620"},{"user_name":"蒋丽萍","user_pic":"http://img.yidoutang.com/upload/user//201611/6b/201611011620456b.jpg","group_id":"306356","type":"5","title":"新春宠物篇第一季","user_id":"156262","image":"http://img.yidoutang.com/upload/match/normal/201609/00/201609231656068800.jpg!app620","cover":"/upload/match/normal/201609/00/201609231656068800.jpg","style":"北欧","size":"三居室","comment_num":"33","share_num":"36","like_num":"117","sharing_num":"0","click_num":"5395","created":"1474623949","header_image":"http://img.yidoutang.com/upload/match/normal/201609/00/201609231656068800.jpg!app620"},{"user_name":"云朵儿","user_pic":"http://img.yidoutang.com/upload/user//201607/a0/20160718161185a0.gif","group_id":"273091","type":"1","title":"儿童房增加移动衣柜和两米黑板墙就大变样了，棒棒哒！","user_id":"133040","image":"http://img.yidoutang.com/upload/match/normal/201608/3f/20160823142719da3f.jpg!app620","cover":"/upload/match/normal/201608/3f/20160823142719da3f.jpg","style":"宜家","size":"两居室","comment_num":"19","share_num":"10","like_num":"86","sharing_num":"2","click_num":"4372","created":"1471934420","header_image":"http://img.yidoutang.com/upload/match/normal/201608/3f/20160823142719da3f.jpg!app620"},{"user_name":"九艺阳光","user_pic":"http://img.yidoutang.com/upload/user//201307/cc/201307020942d8cc.gif","group_id":"1166","type":"1","title":"只要认真，用心。其实网购也可以打造一个别致的家","user_id":"27","image":"http://img.yidoutang.com/upload/match/normal/51dd04dec1ec4.jpg!app620","cover":null,"style":"现代简约","size":"三居室","comment_num":"45","share_num":"10","like_num":"91","sharing_num":"28","click_num":"20518","created":"1373439315","header_image":"http://img.yidoutang.com/upload/match/normal/51dd04dec1ec4.jpg!app620"},{"user_name":"多多","user_pic":"http://img.yidoutang.com/upload/user//201512/9d/201512021446f99d.jpg","group_id":"150317","type":"1","title":"♥♥♥♥♥文艺暖心的北欧小窝，装修毕业照","user_id":"25681","image":"http://img.yidoutang.com/upload/match/normal/565e8d0c6a19b.jpg!app620","cover":"/upload/match/normal/565e8d0c6a19b.jpg","style":"北欧","size":"两居室","comment_num":"353","share_num":"273","like_num":"1147","sharing_num":"12","click_num":"45294","created":"1449037398","header_image":"http://img.yidoutang.com/upload/match/normal/565e8d0c6a19b.jpg!app620"}],"pagination":{"record_count":313,"page_count":21,"first":1,"last":21,"next":2,"prev":1,"current":1,"page_size":15,"page_base":1}}
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
         * thread : 0
         * guide : 134
         * case : 313
         * pic : 712
         * shareing : 3921
         */

        private CountBean count;
        /**
         * record_count : 313
         * page_count : 21
         * first : 1
         * last : 21
         * next : 2
         * prev : 1
         * current : 1
         * page_size : 15
         * page_base : 1
         */

        private PaginationBean pagination;
        /**
         * user_name : 小洗
         * user_pic : http://img.yidoutang.com/upload/user//201303/58/2013030415549758.gif
         * group_id : 1146
         * type : 1
         * title : 1.8米大床是一定要的！背景墙用的是螺旋纹理壁纸，浅紫色图案和窗帘的颜色非常协调，灯具与房间的格调相得益彰。
         * user_id : 3587
         * image : http://img.yidoutang.com/upload/match/normal/51fbae8164886.jpg!app620
         * cover : /upload/match/normal/51fbae8164886.jpg
         * style : 现代简约
         * size : 四居室
         * comment_num : 259
         * share_num : 10
         * like_num : 139
         * sharing_num : 14
         * click_num : 32253
         * created : 1372685908
         * header_image : http://img.yidoutang.com/upload/match/normal/51fbae8164886.jpg!app620
         */

        private List<CasesBean> cases;

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

        public List<CasesBean> getCases() {
            return cases;
        }

        public void setCases(List<CasesBean> cases) {
            this.cases = cases;
        }

        public static class CountBean {
            private String thread;
            private String guide;
            @JSONField(name="case")
            private String caseX;
            private String pic;
            private String shareing;

            public String getThread() {
                return thread;
            }

            public void setThread(String thread) {
                this.thread = thread;
            }

            public String getGuide() {
                return guide;
            }

            public void setGuide(String guide) {
                this.guide = guide;
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

        public static class CasesBean {
            private String user_name;
            private String user_pic;
            private String group_id;
            private String type;
            private String title;
            private String user_id;
            private String image;
            private String cover;
            private String style;
            private String size;
            private String comment_num;
            private String share_num;
            private String like_num;
            private String sharing_num;
            private String click_num;
            private String created;
            private String header_image;

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getUser_pic() {
                return user_pic;
            }

            public void setUser_pic(String user_pic) {
                this.user_pic = user_pic;
            }

            public String getGroup_id() {
                return group_id;
            }

            public void setGroup_id(String group_id) {
                this.group_id = group_id;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public String getStyle() {
                return style;
            }

            public void setStyle(String style) {
                this.style = style;
            }

            public String getSize() {
                return size;
            }

            public void setSize(String size) {
                this.size = size;
            }

            public String getComment_num() {
                return comment_num;
            }

            public void setComment_num(String comment_num) {
                this.comment_num = comment_num;
            }

            public String getShare_num() {
                return share_num;
            }

            public void setShare_num(String share_num) {
                this.share_num = share_num;
            }

            public String getLike_num() {
                return like_num;
            }

            public void setLike_num(String like_num) {
                this.like_num = like_num;
            }

            public String getSharing_num() {
                return sharing_num;
            }

            public void setSharing_num(String sharing_num) {
                this.sharing_num = sharing_num;
            }

            public String getClick_num() {
                return click_num;
            }

            public void setClick_num(String click_num) {
                this.click_num = click_num;
            }

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public String getHeader_image() {
                return header_image;
            }

            public void setHeader_image(String header_image) {
                this.header_image = header_image;
            }
        }
    }
}
