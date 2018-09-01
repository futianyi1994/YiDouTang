package com.example.yidoutangdemo.bean;

import java.util.List;

/**
 * Created by 天一 on 2016/11/1.
 */
public class ShaiXuanEntity {

    private DataBean data;
    /**
     * data : {"tags":[{"name":"排序","key":"order","sonTags":[{"value":"0","title":"默认"},{"value":"1","title":"最新"},{"value":"2","title":"最热"}]},{"name":"空间","key":"space","sonTags":[{"title":"全部","value":""},{"title":"客厅","value":"客厅"},{"title":"餐厅","value":"餐厅"},{"title":"卧室","value":"卧室"},{"title":"玄关","value":"玄关"},{"title":"儿童房","value":"儿童房"},{"title":"厨房","value":"厨房"},{"title":"卫浴","value":"卫浴"},{"title":"工作区","value":"工作区"},{"title":"阳台","value":"阳台"},{"title":"衣帽间","value":"衣帽间"},{"title":"楼梯","value":"楼梯"},{"title":"走廊","value":"走廊"},{"title":"角落","value":"角落"}]},{"name":"风格","key":"style","sonTags":[{"title":"全部","value":""},{"title":"北欧","value":"北欧"},{"title":"现代简约","value":"现代简约"},{"title":"美式","value":"美式"},{"title":"日式","value":"日式"},{"title":"田园风尚","value":"田园风尚"},{"title":"地中海","value":"地中海"},{"title":"混搭","value":"混搭"},{"title":"欧式","value":"欧式"},{"title":"中式","value":"中式"},{"title":"法式","value":"法式"},{"title":"工业风","value":"工业风"},{"title":"东南亚","value":"东南亚"},{"title":"宜家","value":"宜家"}]},{"name":"局部","key":"part","sonTags":[{"title":"全部","value":""},{"title":"电视墙","value":"电视墙"},{"title":"沙发","value":"沙发"},{"title":"卡座","value":"卡座"},{"title":"灯饰","value":"灯饰"},{"title":"榻榻米","value":"榻榻米"},{"title":"飘窗","value":"飘窗"},{"title":"隔断","value":"隔断"},{"title":"吧台","value":"吧台"},{"title":"装饰品","value":"装饰品"},{"title":"吊顶","value":"吊顶"},{"title":"窗帘","value":"窗帘"},{"title":"收纳","value":"收纳"}]}]}
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
         * name : 排序
         * key : order
         * sonTags : [{"value":"0","title":"默认"},{"value":"1","title":"最新"},{"value":"2","title":"最热"}]
         */

        private List<TagsBean> tags;

        public List<TagsBean> getTags() {
            return tags;
        }

        public void setTags(List<TagsBean> tags) {
            this.tags = tags;
        }

        public static class TagsBean {
            private String name;
            private String key;
            /**
             * value : 0
             * title : 默认
             */

            private List<SonTagsBean> sonTags;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }

            public List<SonTagsBean> getSonTags() {
                return sonTags;
            }

            public void setSonTags(List<SonTagsBean> sonTags) {
                this.sonTags = sonTags;
            }

            public static class SonTagsBean {
                private String value;
                private String title;

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }
            }
        }
    }
}
