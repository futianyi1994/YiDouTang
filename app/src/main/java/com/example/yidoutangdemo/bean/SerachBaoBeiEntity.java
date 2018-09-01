package com.example.yidoutangdemo.bean;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.List;

/**
 * Created by 天一 on 2016/11/3.
 */
public class SerachBaoBeiEntity {

    /**
     * count : {"thread":"0","guide":"134","case":"313","pic":"713","shareing":"3921"}
     * sharings : [{"sharing_id":"40952","created":1414737526,"user_id":"1739","cat":"卧室","tags":"床","styles":"欧式","title":"特价 储物床 真皮床 双人床 1.8米 床 软体床 婚床 小户型床","price":"1380","special_price":"1380","color":"咖啡","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201410/61/2014103114387a61.jpg!s300","taobao_cid":0,"shop_level":0,"is_like":false},{"sharing_id":"43143","created":1426339492,"user_id":"21557","cat":"卧室","tags":"床","styles":"美式","title":"美式乡村实木四柱床 1.8米双人床 罗马柱床 主卧室床 大床 雕花床","price":"8125","special_price":"8125","color":"咖啡","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201503/6b/201503142124cf6b.jpg!s300","taobao_cid":50019997,"shop_level":0,"is_like":false},{"sharing_id":"21895","created":1355978316,"user_id":"1830","cat":"卧室","tags":"床","styles":"简约现代,北欧宜家,地中海风,欧式","title":"BENS家具订制 圆形床 圆床 布艺床 真皮床 双人大床 2.2米 8156","price":"2499","special_price":"2499","color":"白","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201212/a0/2012122012380ba0.jpg!s300","taobao_cid":50020000,"shop_level":0,"is_like":false},{"sharing_id":"37861","created":1399386706,"user_id":"6001","cat":"卧室","tags":"床","styles":"田园","title":"韩式床 公主床 田园床 简欧床 欧式床 法式床 双人床实木床 1.5","price":"1038.1","special_price":"1038.1","color":"白","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201405/e6/201405062231fce6.jpg!s300","taobao_cid":50019997,"shop_level":0,"is_like":false},{"sharing_id":"30445","created":1373442305,"user_id":"27","cat":"卧室","tags":"床","styles":"欧式","title":"欧式床 实木双人床 1.5 1.8米 新古典家具 公主床太子床婚床 特价","price":"2480","special_price":"2480","color":"白","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201307/0e/201307101545de0e.jpeg!s300","taobao_cid":50019997,"shop_level":0,"is_like":false},{"sharing_id":"39880","created":1409624910,"user_id":"6525","cat":"卧室","tags":"床","styles":"美式","title":"*80公馆*地中海风格床美式乡村双人床 实木四柱床 架子床 柱子床","price":"2780","special_price":"2780","color":"黑","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201409/fd/20140902102871fd.jpg!s300","taobao_cid":50019997,"shop_level":0,"is_like":false},{"sharing_id":"51492","created":1447901250,"user_id":"57180","cat":"卧室","tags":"床","styles":"简约现代","title":"溢美溢诚  公主款圆床  皮圆床 真皮圆床    圆床","price":"1800","special_price":"1800","color":"粉","normal_image":"http://img.yidoutang.com/upload/sharing/normal/564e82cca60e3.PNG!s300","taobao_cid":50020000,"shop_level":0,"is_like":false},{"sharing_id":"3865","created":1332513094,"user_id":"1001","cat":"卧室","tags":"床","styles":"北欧宜家,简约现代","title":"秒杀床 家用床 时尚简约床 皮床 满1000减20","price":"2260","special_price":"0","color":"黑","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201203/0c/201203232231de0c.jpg!s300","taobao_cid":50020000,"shop_level":0,"is_like":false},{"sharing_id":"17984","created":1348121240,"user_id":"1737","cat":"卧室","tags":"床","styles":"简约现代","title":"家具专营店 1500*2000皮床黑色皮床双人皮床现代简约皮床","price":"1888","special_price":"1888","color":"黑","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201209/b2/20120920140740b2.jpg!s300","taobao_cid":50020000,"shop_level":0,"is_like":false},{"sharing_id":"4826","created":1332987981,"user_id":"957","cat":"卧室","tags":"床","styles":"简约现代","title":"圆床布艺软床 圆形布艺床 双人床 布床2.0米红色时尚圆床","price":"2900","special_price":"2900","color":"红","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201203/6e/201203291026626e.jpg!s300","taobao_cid":50019999,"shop_level":0,"is_like":false},{"sharing_id":"2820","created":1331692690,"user_id":"29","cat":"卧室","tags":"床","styles":"北欧宜家,田园,欧式","title":"现货！ 板式床韩式田园床 1.5 1.8米双人床婚床公主床 品牌A3","price":"3230","special_price":"3230","color":"白","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201203/4a/201203141038064a.jpg!s300","taobao_cid":50020002,"shop_level":0,"is_like":false},{"sharing_id":"36980","created":1395900592,"user_id":"5897","cat":"卧室","tags":"床","styles":"田园","title":"三包到家 大森林家具 田园床 实木床 公主床 双人床 欧式床 婚床","price":"1899","special_price":"1899","color":"白","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201403/39/201403271409f639.jpg!s300","taobao_cid":0,"shop_level":0,"is_like":false},{"sharing_id":"3465","created":1332304956,"user_id":"877","cat":"卧室","tags":"床","styles":"简约现代","title":"潘潘家具--高档布艺床 布艺床 时尚现代床 经典圆床J001","price":"3800","special_price":"3800","color":"黑","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201203/96/2012032112424696.jpg!s300","taobao_cid":50019999,"shop_level":0,"is_like":false},{"sharing_id":"12356","created":1339826757,"user_id":"40","cat":"卧室","tags":"床","styles":"北欧宜家","title":"北山 床 1.5 1.8米床 双人床 储物 软包床 家具床","price":"3199","special_price":"0","color":"黄","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201206/35/201206161405ea35.jpg!s300","taobao_cid":50020002,"shop_level":0,"is_like":false},{"sharing_id":"18277","created":1348649245,"user_id":"1907","cat":"卧室","tags":"床","styles":"简约现代","title":"北京 布艺床 软体床 功能床 宽边床 样品处理 哈克 特价","price":"3900","special_price":"3900","color":"黑","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201209/2b/201209261647a42b.jpg!s300","taobao_cid":50019999,"shop_level":0,"is_like":false}]
     * pagination : {"record_count":3921,"page_count":262,"first":1,"last":262,"next":2,"prev":1,"current":1,"page_size":15,"page_base":1}
     */

    private DataBean data;
    /**
     * data : {"count":{"thread":"0","guide":"134","case":"313","pic":"713","shareing":"3921"},"sharings":[{"sharing_id":"40952","created":1414737526,"user_id":"1739","cat":"卧室","tags":"床","styles":"欧式","title":"特价 储物床 真皮床 双人床 1.8米 床 软体床 婚床 小户型床","price":"1380","special_price":"1380","color":"咖啡","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201410/61/2014103114387a61.jpg!s300","taobao_cid":0,"shop_level":0,"is_like":false},{"sharing_id":"43143","created":1426339492,"user_id":"21557","cat":"卧室","tags":"床","styles":"美式","title":"美式乡村实木四柱床 1.8米双人床 罗马柱床 主卧室床 大床 雕花床","price":"8125","special_price":"8125","color":"咖啡","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201503/6b/201503142124cf6b.jpg!s300","taobao_cid":50019997,"shop_level":0,"is_like":false},{"sharing_id":"21895","created":1355978316,"user_id":"1830","cat":"卧室","tags":"床","styles":"简约现代,北欧宜家,地中海风,欧式","title":"BENS家具订制 圆形床 圆床 布艺床 真皮床 双人大床 2.2米 8156","price":"2499","special_price":"2499","color":"白","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201212/a0/2012122012380ba0.jpg!s300","taobao_cid":50020000,"shop_level":0,"is_like":false},{"sharing_id":"37861","created":1399386706,"user_id":"6001","cat":"卧室","tags":"床","styles":"田园","title":"韩式床 公主床 田园床 简欧床 欧式床 法式床 双人床实木床 1.5","price":"1038.1","special_price":"1038.1","color":"白","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201405/e6/201405062231fce6.jpg!s300","taobao_cid":50019997,"shop_level":0,"is_like":false},{"sharing_id":"30445","created":1373442305,"user_id":"27","cat":"卧室","tags":"床","styles":"欧式","title":"欧式床 实木双人床 1.5 1.8米 新古典家具 公主床太子床婚床 特价","price":"2480","special_price":"2480","color":"白","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201307/0e/201307101545de0e.jpeg!s300","taobao_cid":50019997,"shop_level":0,"is_like":false},{"sharing_id":"39880","created":1409624910,"user_id":"6525","cat":"卧室","tags":"床","styles":"美式","title":"*80公馆*地中海风格床美式乡村双人床 实木四柱床 架子床 柱子床","price":"2780","special_price":"2780","color":"黑","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201409/fd/20140902102871fd.jpg!s300","taobao_cid":50019997,"shop_level":0,"is_like":false},{"sharing_id":"51492","created":1447901250,"user_id":"57180","cat":"卧室","tags":"床","styles":"简约现代","title":"溢美溢诚  公主款圆床  皮圆床 真皮圆床    圆床","price":"1800","special_price":"1800","color":"粉","normal_image":"http://img.yidoutang.com/upload/sharing/normal/564e82cca60e3.PNG!s300","taobao_cid":50020000,"shop_level":0,"is_like":false},{"sharing_id":"3865","created":1332513094,"user_id":"1001","cat":"卧室","tags":"床","styles":"北欧宜家,简约现代","title":"秒杀床 家用床 时尚简约床 皮床 满1000减20","price":"2260","special_price":"0","color":"黑","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201203/0c/201203232231de0c.jpg!s300","taobao_cid":50020000,"shop_level":0,"is_like":false},{"sharing_id":"17984","created":1348121240,"user_id":"1737","cat":"卧室","tags":"床","styles":"简约现代","title":"家具专营店 1500*2000皮床黑色皮床双人皮床现代简约皮床","price":"1888","special_price":"1888","color":"黑","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201209/b2/20120920140740b2.jpg!s300","taobao_cid":50020000,"shop_level":0,"is_like":false},{"sharing_id":"4826","created":1332987981,"user_id":"957","cat":"卧室","tags":"床","styles":"简约现代","title":"圆床布艺软床 圆形布艺床 双人床 布床2.0米红色时尚圆床","price":"2900","special_price":"2900","color":"红","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201203/6e/201203291026626e.jpg!s300","taobao_cid":50019999,"shop_level":0,"is_like":false},{"sharing_id":"2820","created":1331692690,"user_id":"29","cat":"卧室","tags":"床","styles":"北欧宜家,田园,欧式","title":"现货！ 板式床韩式田园床 1.5 1.8米双人床婚床公主床 品牌A3","price":"3230","special_price":"3230","color":"白","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201203/4a/201203141038064a.jpg!s300","taobao_cid":50020002,"shop_level":0,"is_like":false},{"sharing_id":"36980","created":1395900592,"user_id":"5897","cat":"卧室","tags":"床","styles":"田园","title":"三包到家 大森林家具 田园床 实木床 公主床 双人床 欧式床 婚床","price":"1899","special_price":"1899","color":"白","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201403/39/201403271409f639.jpg!s300","taobao_cid":0,"shop_level":0,"is_like":false},{"sharing_id":"3465","created":1332304956,"user_id":"877","cat":"卧室","tags":"床","styles":"简约现代","title":"潘潘家具--高档布艺床 布艺床 时尚现代床 经典圆床J001","price":"3800","special_price":"3800","color":"黑","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201203/96/2012032112424696.jpg!s300","taobao_cid":50019999,"shop_level":0,"is_like":false},{"sharing_id":"12356","created":1339826757,"user_id":"40","cat":"卧室","tags":"床","styles":"北欧宜家","title":"北山 床 1.5 1.8米床 双人床 储物 软包床 家具床","price":"3199","special_price":"0","color":"黄","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201206/35/201206161405ea35.jpg!s300","taobao_cid":50020002,"shop_level":0,"is_like":false},{"sharing_id":"18277","created":1348649245,"user_id":"1907","cat":"卧室","tags":"床","styles":"简约现代","title":"北京 布艺床 软体床 功能床 宽边床 样品处理 哈克 特价","price":"3900","special_price":"3900","color":"黑","normal_image":"http://img.yidoutang.com/upload/sharing/normal/201209/2b/201209261647a42b.jpg!s300","taobao_cid":50019999,"shop_level":0,"is_like":false}],"pagination":{"record_count":3921,"page_count":262,"first":1,"last":262,"next":2,"prev":1,"current":1,"page_size":15,"page_base":1}}
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
         * pic : 713
         * shareing : 3921
         */

        private CountBean count;
        /**
         * record_count : 3921
         * page_count : 262
         * first : 1
         * last : 262
         * next : 2
         * prev : 1
         * current : 1
         * page_size : 15
         * page_base : 1
         */

        private PaginationBean pagination;
        /**
         * sharing_id : 40952
         * created : 1414737526
         * user_id : 1739
         * cat : 卧室
         * tags : 床
         * styles : 欧式
         * title : 特价 储物床 真皮床 双人床 1.8米 床 软体床 婚床 小户型床
         * price : 1380
         * special_price : 1380
         * color : 咖啡
         * normal_image : http://img.yidoutang.com/upload/sharing/normal/201410/61/2014103114387a61.jpg!s300
         * taobao_cid : 0
         * shop_level : 0
         * is_like : false
         */

        private List<SharingsBean> sharings;

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

        public List<SharingsBean> getSharings() {
            return sharings;
        }

        public void setSharings(List<SharingsBean> sharings) {
            this.sharings = sharings;
        }

        public static class CountBean {
            private String thread;
            private String guide;
            @JSONField(name = "case")
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

        public static class SharingsBean {
            private String sharing_id;
            private int created;
            private String user_id;
            private String cat;
            private String tags;
            private String styles;
            private String title;
            private String price;
            private String special_price;
            private String color;
            private String normal_image;
            private int taobao_cid;
            private int shop_level;
            private boolean is_like;

            public String getSharing_id() {
                return sharing_id;
            }

            public void setSharing_id(String sharing_id) {
                this.sharing_id = sharing_id;
            }

            public int getCreated() {
                return created;
            }

            public void setCreated(int created) {
                this.created = created;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getCat() {
                return cat;
            }

            public void setCat(String cat) {
                this.cat = cat;
            }

            public String getTags() {
                return tags;
            }

            public void setTags(String tags) {
                this.tags = tags;
            }

            public String getStyles() {
                return styles;
            }

            public void setStyles(String styles) {
                this.styles = styles;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getSpecial_price() {
                return special_price;
            }

            public void setSpecial_price(String special_price) {
                this.special_price = special_price;
            }

            public String getColor() {
                return color;
            }

            public void setColor(String color) {
                this.color = color;
            }

            public String getNormal_image() {
                return normal_image;
            }

            public void setNormal_image(String normal_image) {
                this.normal_image = normal_image;
            }

            public int getTaobao_cid() {
                return taobao_cid;
            }

            public void setTaobao_cid(int taobao_cid) {
                this.taobao_cid = taobao_cid;
            }

            public int getShop_level() {
                return shop_level;
            }

            public void setShop_level(int shop_level) {
                this.shop_level = shop_level;
            }

            public boolean isIs_like() {
                return is_like;
            }

            public void setIs_like(boolean is_like) {
                this.is_like = is_like;
            }
        }
    }
}
