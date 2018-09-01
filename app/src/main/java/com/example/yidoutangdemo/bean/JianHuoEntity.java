package com.example.yidoutangdemo.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by 天一 on 2016/11/1.
 */
public class JianHuoEntity {

    /**
     * info : {"tag":""}
     * guides : [{"tid":"7143","subject":"利用角落做收纳","tagname":"居家心得","views":257,"replies":15,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5817f56107f18.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/5817f56107f18.jpg!app620","recommend_note":"4#New","authorid":151058,"author":"小瓜子","user_pic":"http://img.yidoutang.com/upload/user//201609/0b/201609011923cf0b.gif","vip":0},{"tid":"7137","subject":"旧物巧改造为居家添新彩","tagname":"居家心得","views":1033,"replies":20,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5815faf58b997.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/5815fb3bc51bb.jpg!app620","recommend_note":"4#New","authorid":12573,"author":"城内城外","user_pic":"http://img.yidoutang.com/upload/user//201412/66/2014121117525066.jpg","vip":0},{"tid":"7129","subject":"抹在脸上的化妆水都这样挑剔，喝进肚子的饮用水又怎么可以随便！","tagname":"居家心得","views":581,"replies":13,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5816ab5d49ebf.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/5816ab5d49ebf.jpg!app620","recommend_note":"4#New","authorid":24944,"author":"糖主","user_pic":"http://img.yidoutang.com/upload/user//201609/f3/201609071450f7f3.jpg","vip":0},{"tid":"7138","subject":"爱生活，爱烘焙。唯有美食与爱不可辜负","tagname":"居家心得","views":601,"replies":18,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5815f6b1c211c.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/581609cf55195.jpg!app620","recommend_note":"4#New","authorid":161391,"author":"大小姐","user_pic":"http://img.yidoutang.com/upload/user//201610/43/2016102511032243.jpg","vip":0},{"tid":"7128","subject":"原来\u201c滚床单\u201d和\u201c滚\u201d只差一套好床品的距离","tagname":"购物攻略","views":1997,"replies":20,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5811e6df5dd1e.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/5811e6937fa88.jpg!app620","recommend_note":"4#New","authorid":24944,"author":"糖主","user_pic":"http://img.yidoutang.com/upload/user//201609/f3/201609071450f7f3.jpg","vip":0},{"tid":"7124","subject":"亲，确定了解你家烤箱的脾性嘛？","tagname":"居家心得","views":1237,"replies":18,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/58119cb975897.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/58119ce191de4.jpg!app620","recommend_note":"4#New","authorid":153899,"author":"宝宝就这样","user_pic":"http://img.yidoutang.com/upload/user//201610/f8/201610271359bbf8.jpg","vip":0},{"tid":"7123","subject":"你不知道的风灯的妙用，发挥创意和想象~","tagname":"购物攻略","views":1457,"replies":28,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5810b378dc6fc.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/5810af3a69de9.jpg!app620","recommend_note":"4#New","authorid":143975,"author":"chic-home","user_pic":"http://img.yidoutang.com/upload/user//201608/40/201608102213d540.gif","vip":0},{"tid":"6955","subject":"3千元竟然把出租房装修得如此温馨，完全大变样","tagname":"家装经验","views":4271,"replies":34,"sharings":6,"feature":"http://img.yidoutang.com/upload/community/catch/57ce697127b56.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/catch/57ce698a7d88e.jpg!app620","recommend_note":"","authorid":152274,"author":"本","user_pic":"http://img.yidoutang.com/upload/user//201609/2b/201609061206782b.gif","vip":0},{"tid":"6971","subject":"图里的幻想--儿童房","tagname":"搭配指南","views":3061,"replies":27,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/57d23873df7dc.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/57d233f29c3e3.jpg!app620","recommend_note":"","authorid":150719,"author":"卿","user_pic":"http://img.yidoutang.com/upload/user//201608/cb/201608311652d3cb.jpg","vip":0},{"tid":"6970","subject":"他们说这些是花盆界的\u201c霍建华\u201d，颜高低调有内涵","tagname":"居家心得","views":12778,"replies":19,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/57d216ae2d09c.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/57d21df92cc4e.jpg!app620","recommend_note":"","authorid":24944,"author":"糖主","user_pic":"http://img.yidoutang.com/upload/user//201609/f3/201609071450f7f3.jpg","vip":0},{"tid":"6969","subject":"浪漫表白季\u2014\u2014送给女神的小户新\u201c装\u201d","tagname":"家装经验","views":5447,"replies":17,"sharings":3,"feature":"http://img.yidoutang.com/upload/community/guide/57d21218befb3.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/57d21218befb3.jpg!app620","recommend_note":"","authorid":152628,"author":"花花麻麻","user_pic":"http://img.yidoutang.com/upload/user//201609/cb/201609071529d3cb.jpg","vip":2},{"tid":"6968","subject":"1㎡ 犄角旮旯怎么用？你需要一块实惠又万用的「搁板」","tagname":"搭配指南","views":34642,"replies":26,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/57d235e4e082a.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/57d1532b9d461.jpg!app620","recommend_note":"","authorid":24944,"author":"糖主","user_pic":"http://img.yidoutang.com/upload/user//201609/f3/201609071450f7f3.jpg","vip":0},{"tid":"7099","subject":"【盘点北欧简约风搭配vol.3】-卫生间搭配（物件篇）","tagname":"搭配指南","views":2619,"replies":54,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5808de79c6c17.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/5808e4862e4f1.jpg!app620","recommend_note":"","authorid":158181,"author":"直方大","user_pic":"http://img.yidoutang.com/upload/user//201609/4e/201609270008784e.gif","vip":0},{"tid":"7103","subject":"吐槽装修中的遗憾","tagname":"家装经验","views":24666,"replies":60,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5809a061525d5.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/58099d7cb43fe.jpg!app620","recommend_note":"","authorid":151058,"author":"小瓜子","user_pic":"http://img.yidoutang.com/upload/user//201609/0b/201609011923cf0b.gif","vip":0},{"tid":"6956","subject":"十款小众抱枕推荐|用对抱枕，让你的家焕然一新","tagname":"搭配指南","views":30950,"replies":19,"sharings":11,"feature":"http://img.yidoutang.com/upload/community/guide/57ce83631649b.JPG!app620","header_image":"http://img.yidoutang.com/upload/sharing/normal/201609/ea/201609061620b0ea.jpg!app620","recommend_note":"","authorid":86200,"author":"phyllis","user_pic":"http://img.yidoutang.com/upload/user//201604/03/201604271749f303.gif","vip":2}]
     * pagination : {"record_count":939,"page_count":63,"first":1,"last":63,"next":2,"prev":1,"current":1,"page_size":15,"page_base":1}
     * recommend_tag : [{"title":"日用杂货","icon":"http://img.yidoutang.com/upload/community/tag/5682037cb6b48.png!s95","data":{"class":"30"}},{"title":"装饰布置","icon":"http://img.yidoutang.com/upload/community/tag/5682037cc8b8b.png!s95","data":{"tag":"28"}},{"title":"搭配宝典","icon":"http://img.yidoutang.com/upload/community/tag/5682037d19e90.png!s95","data":{"class":"69"}},{"title":"白菜价","icon":"http://img.yidoutang.com/upload/community/tag/5682037d275c9.png!s95","data":{"tag":"38"}},{"title":"烹饪厨具","icon":"http://img.yidoutang.com/upload/community/tag/5682037d35f36.png!s95","data":{"tag":"25"}},{"title":"实用主义","icon":"http://img.yidoutang.com/upload/community/tag/5682037d472ba.png!s95","data":{"class":"33"}},{"title":"餐具杯具","icon":"http://img.yidoutang.com/upload/community/tag/5682037d59c35.png!s95","data":{"tag":"26"}},{"icon":"http://img.yidoutang.com/upload/community/tag/5682037d6a637.png!s95","data":null}]
     * banners : [{"banner_id":"342","position_id":"2","title":"厕所瓷砖","image":"http://img.yidoutang.com/upload/bannel/578f3fab6c4da.jpg!banner240","type":"5","attr":"6728","data_ext":null,"start":"0","end":"0","order":"0","created":"1469005739"},{"banner_id":"338","position_id":"2","title":"沿途厨房","image":"http://img.yidoutang.com/upload/bannel/578c47a497124.jpg!banner240","type":"5","attr":"6726","data_ext":null,"start":"0","end":"0","order":"1","created":"1468811171"},{"banner_id":"339","position_id":"2","title":"看书","image":"http://img.yidoutang.com/upload/bannel/578c47d58ee5e.jpg!banner240","type":"5","attr":"6679","data_ext":null,"start":"0","end":"0","order":"2","created":"1468811221"}]
     */

    private DataBean data;
    /**
     * data : {"info":{"tag":""},"guides":[{"tid":"7143","subject":"利用角落做收纳","tagname":"居家心得","views":257,"replies":15,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5817f56107f18.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/5817f56107f18.jpg!app620","recommend_note":"4#New","authorid":151058,"author":"小瓜子","user_pic":"http://img.yidoutang.com/upload/user//201609/0b/201609011923cf0b.gif","vip":0},{"tid":"7137","subject":"旧物巧改造为居家添新彩","tagname":"居家心得","views":1033,"replies":20,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5815faf58b997.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/5815fb3bc51bb.jpg!app620","recommend_note":"4#New","authorid":12573,"author":"城内城外","user_pic":"http://img.yidoutang.com/upload/user//201412/66/2014121117525066.jpg","vip":0},{"tid":"7129","subject":"抹在脸上的化妆水都这样挑剔，喝进肚子的饮用水又怎么可以随便！","tagname":"居家心得","views":581,"replies":13,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5816ab5d49ebf.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/5816ab5d49ebf.jpg!app620","recommend_note":"4#New","authorid":24944,"author":"糖主","user_pic":"http://img.yidoutang.com/upload/user//201609/f3/201609071450f7f3.jpg","vip":0},{"tid":"7138","subject":"爱生活，爱烘焙。唯有美食与爱不可辜负","tagname":"居家心得","views":601,"replies":18,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5815f6b1c211c.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/581609cf55195.jpg!app620","recommend_note":"4#New","authorid":161391,"author":"大小姐","user_pic":"http://img.yidoutang.com/upload/user//201610/43/2016102511032243.jpg","vip":0},{"tid":"7128","subject":"原来\u201c滚床单\u201d和\u201c滚\u201d只差一套好床品的距离","tagname":"购物攻略","views":1997,"replies":20,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5811e6df5dd1e.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/5811e6937fa88.jpg!app620","recommend_note":"4#New","authorid":24944,"author":"糖主","user_pic":"http://img.yidoutang.com/upload/user//201609/f3/201609071450f7f3.jpg","vip":0},{"tid":"7124","subject":"亲，确定了解你家烤箱的脾性嘛？","tagname":"居家心得","views":1237,"replies":18,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/58119cb975897.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/58119ce191de4.jpg!app620","recommend_note":"4#New","authorid":153899,"author":"宝宝就这样","user_pic":"http://img.yidoutang.com/upload/user//201610/f8/201610271359bbf8.jpg","vip":0},{"tid":"7123","subject":"你不知道的风灯的妙用，发挥创意和想象~","tagname":"购物攻略","views":1457,"replies":28,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5810b378dc6fc.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/5810af3a69de9.jpg!app620","recommend_note":"4#New","authorid":143975,"author":"chic-home","user_pic":"http://img.yidoutang.com/upload/user//201608/40/201608102213d540.gif","vip":0},{"tid":"6955","subject":"3千元竟然把出租房装修得如此温馨，完全大变样","tagname":"家装经验","views":4271,"replies":34,"sharings":6,"feature":"http://img.yidoutang.com/upload/community/catch/57ce697127b56.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/catch/57ce698a7d88e.jpg!app620","recommend_note":"","authorid":152274,"author":"本","user_pic":"http://img.yidoutang.com/upload/user//201609/2b/201609061206782b.gif","vip":0},{"tid":"6971","subject":"图里的幻想--儿童房","tagname":"搭配指南","views":3061,"replies":27,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/57d23873df7dc.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/57d233f29c3e3.jpg!app620","recommend_note":"","authorid":150719,"author":"卿","user_pic":"http://img.yidoutang.com/upload/user//201608/cb/201608311652d3cb.jpg","vip":0},{"tid":"6970","subject":"他们说这些是花盆界的\u201c霍建华\u201d，颜高低调有内涵","tagname":"居家心得","views":12778,"replies":19,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/57d216ae2d09c.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/57d21df92cc4e.jpg!app620","recommend_note":"","authorid":24944,"author":"糖主","user_pic":"http://img.yidoutang.com/upload/user//201609/f3/201609071450f7f3.jpg","vip":0},{"tid":"6969","subject":"浪漫表白季\u2014\u2014送给女神的小户新\u201c装\u201d","tagname":"家装经验","views":5447,"replies":17,"sharings":3,"feature":"http://img.yidoutang.com/upload/community/guide/57d21218befb3.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/57d21218befb3.jpg!app620","recommend_note":"","authorid":152628,"author":"花花麻麻","user_pic":"http://img.yidoutang.com/upload/user//201609/cb/201609071529d3cb.jpg","vip":2},{"tid":"6968","subject":"1㎡ 犄角旮旯怎么用？你需要一块实惠又万用的「搁板」","tagname":"搭配指南","views":34642,"replies":26,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/57d235e4e082a.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/57d1532b9d461.jpg!app620","recommend_note":"","authorid":24944,"author":"糖主","user_pic":"http://img.yidoutang.com/upload/user//201609/f3/201609071450f7f3.jpg","vip":0},{"tid":"7099","subject":"【盘点北欧简约风搭配vol.3】-卫生间搭配（物件篇）","tagname":"搭配指南","views":2619,"replies":54,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5808de79c6c17.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/5808e4862e4f1.jpg!app620","recommend_note":"","authorid":158181,"author":"直方大","user_pic":"http://img.yidoutang.com/upload/user//201609/4e/201609270008784e.gif","vip":0},{"tid":"7103","subject":"吐槽装修中的遗憾","tagname":"家装经验","views":24666,"replies":60,"sharings":0,"feature":"http://img.yidoutang.com/upload/community/guide/5809a061525d5.jpg!app620","header_image":"http://img.yidoutang.com/upload/community/guide/58099d7cb43fe.jpg!app620","recommend_note":"","authorid":151058,"author":"小瓜子","user_pic":"http://img.yidoutang.com/upload/user//201609/0b/201609011923cf0b.gif","vip":0},{"tid":"6956","subject":"十款小众抱枕推荐|用对抱枕，让你的家焕然一新","tagname":"搭配指南","views":30950,"replies":19,"sharings":11,"feature":"http://img.yidoutang.com/upload/community/guide/57ce83631649b.JPG!app620","header_image":"http://img.yidoutang.com/upload/sharing/normal/201609/ea/201609061620b0ea.jpg!app620","recommend_note":"","authorid":86200,"author":"phyllis","user_pic":"http://img.yidoutang.com/upload/user//201604/03/201604271749f303.gif","vip":2}],"pagination":{"record_count":939,"page_count":63,"first":1,"last":63,"next":2,"prev":1,"current":1,"page_size":15,"page_base":1},"recommend_tag":[{"title":"日用杂货","icon":"http://img.yidoutang.com/upload/community/tag/5682037cb6b48.png!s95","data":{"class":"30"}},{"title":"装饰布置","icon":"http://img.yidoutang.com/upload/community/tag/5682037cc8b8b.png!s95","data":{"tag":"28"}},{"title":"搭配宝典","icon":"http://img.yidoutang.com/upload/community/tag/5682037d19e90.png!s95","data":{"class":"69"}},{"title":"白菜价","icon":"http://img.yidoutang.com/upload/community/tag/5682037d275c9.png!s95","data":{"tag":"38"}},{"title":"烹饪厨具","icon":"http://img.yidoutang.com/upload/community/tag/5682037d35f36.png!s95","data":{"tag":"25"}},{"title":"实用主义","icon":"http://img.yidoutang.com/upload/community/tag/5682037d472ba.png!s95","data":{"class":"33"}},{"title":"餐具杯具","icon":"http://img.yidoutang.com/upload/community/tag/5682037d59c35.png!s95","data":{"tag":"26"}},{"icon":"http://img.yidoutang.com/upload/community/tag/5682037d6a637.png!s95","data":null}],"banners":[{"banner_id":"342","position_id":"2","title":"厕所瓷砖","image":"http://img.yidoutang.com/upload/bannel/578f3fab6c4da.jpg!banner240","type":"5","attr":"6728","data_ext":null,"start":"0","end":"0","order":"0","created":"1469005739"},{"banner_id":"338","position_id":"2","title":"沿途厨房","image":"http://img.yidoutang.com/upload/bannel/578c47a497124.jpg!banner240","type":"5","attr":"6726","data_ext":null,"start":"0","end":"0","order":"1","created":"1468811171"},{"banner_id":"339","position_id":"2","title":"看书","image":"http://img.yidoutang.com/upload/bannel/578c47d58ee5e.jpg!banner240","type":"5","attr":"6679","data_ext":null,"start":"0","end":"0","order":"2","created":"1468811221"}]}
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
         * tag :
         */

        private InfoBean info;
        /**
         * record_count : 939
         * page_count : 63
         * first : 1
         * last : 63
         * next : 2
         * prev : 1
         * current : 1
         * page_size : 15
         * page_base : 1
         */

        private PaginationBean pagination;
        /**
         * tid : 7143
         * subject : 利用角落做收纳
         * tagname : 居家心得
         * views : 257
         * replies : 15
         * sharings : 0
         * feature : http://img.yidoutang.com/upload/community/guide/5817f56107f18.jpg!app620
         * header_image : http://img.yidoutang.com/upload/community/guide/5817f56107f18.jpg!app620
         * recommend_note : 4#New
         * authorid : 151058
         * author : 小瓜子
         * user_pic : http://img.yidoutang.com/upload/user//201609/0b/201609011923cf0b.gif
         * vip : 0
         */

        private List<GuidesBean> guides;
        /**
         * title : 日用杂货
         * icon : http://img.yidoutang.com/upload/community/tag/5682037cb6b48.png!s95
         * data : {"class":"30"}
         */

        private List<RecommendTagBean> recommend_tag;
        /**
         * banner_id : 342
         * position_id : 2
         * title : 厕所瓷砖
         * image : http://img.yidoutang.com/upload/bannel/578f3fab6c4da.jpg!banner240
         * type : 5
         * attr : 6728
         * data_ext : null
         * start : 0
         * end : 0
         * order : 0
         * created : 1469005739
         */

        private List<BannersBean> banners;

        public InfoBean getInfo() {
            return info;
        }

        public void setInfo(InfoBean info) {
            this.info = info;
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

        public List<RecommendTagBean> getRecommend_tag() {
            return recommend_tag;
        }

        public void setRecommend_tag(List<RecommendTagBean> recommend_tag) {
            this.recommend_tag = recommend_tag;
        }

        public List<BannersBean> getBanners() {
            return banners;
        }

        public void setBanners(List<BannersBean> banners) {
            this.banners = banners;
        }

        public static class InfoBean {
            private String tag;

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
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

        public static class RecommendTagBean {
            private String title;
            private String icon;
            /**
             * class : 30
             */

            private DataBean1 data;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getIcon() {
                return icon;
            }

            public void setIcon(String icon) {
                this.icon = icon;
            }

            public DataBean1 getData() {
                return data;
            }

            public void setData(DataBean1 data) {
                this.data = data;
            }

            public static class DataBean1 {
               // @com.google.gson.annotations.SerializedName("class")
                @JSONField(name="class")
                private String classX;

                private String tag;

                public String getTag() {
                    return tag;
                }

                public void setTag(String tag) {
                    this.tag = tag;
                }

                public String getClassX() {
                    return classX;
                }

                public void setClassX(String classX) {
                    this.classX = classX;
                }
            }
        }

        public static class BannersBean {
            private String banner_id;
            private String position_id;
            private String title;
            private String image;
            private String type;
            private String attr;
            private Object data_ext;
            private String start;
            private String end;
            private String order;
            private String created;

            public String getBanner_id() {
                return banner_id;
            }

            public void setBanner_id(String banner_id) {
                this.banner_id = banner_id;
            }

            public String getPosition_id() {
                return position_id;
            }

            public void setPosition_id(String position_id) {
                this.position_id = position_id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getAttr() {
                return attr;
            }

            public void setAttr(String attr) {
                this.attr = attr;
            }

            public Object getData_ext() {
                return data_ext;
            }

            public void setData_ext(Object data_ext) {
                this.data_ext = data_ext;
            }

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }

            public String getOrder() {
                return order;
            }

            public void setOrder(String order) {
                this.order = order;
            }

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }
        }
    }
}
