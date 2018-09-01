package com.example.yidoutangdemo.bean;

import java.util.List;

/**
 * Created by 天一 on 2016/11/2.
 */
public class PingLunEntity {


    /**
     * comments : [{"group_id":"349392","content":"亲亲，你家的这个沙发巾是哪里买的？有没有链接啊？","created":"1478067150","answer":"0","quote_id":"0","ask":"0","ask_point":null,"user_id":"88694","user_name":"一道微光带给我的","user_pic":"http://img.yidoutang.com/upload/user//pic/140.jpg","quote_author":null,"is_owner":false},{"group_id":"349300","content":"☺没呢","created":"1478060406","answer":"0","quote_id":"349280","ask":"0","ask_point":null,"user_id":"159483","user_name":"Mengying_L","user_pic":"http://img.yidoutang.com/upload/user//201610/f2/20161003124063f2.jpg","quote_author":"Emmamy","quote_content":"感觉好久木有见到你了呀，你家又丰富了呀","quote_authorid":"137914","is_owner":false},{"group_id":"349280","content":"感觉好久木有见到你了呀，你家又丰富了呀","created":"1478058432","answer":"0","quote_id":"0","ask":"0","ask_point":null,"user_id":"137914","user_name":"Emmamy","user_pic":"http://img.yidoutang.com/upload/user//pic/1302.jpg","quote_author":null,"is_owner":false}]
     * pagination : {"record_count":3,"page_count":1,"first":1,"last":1,"next":1,"prev":1,"current":1,"page_size":20,"page_base":1}
     */

    private DataBean data;
    /**
     * data : {"comments":[{"group_id":"349392","content":"亲亲，你家的这个沙发巾是哪里买的？有没有链接啊？","created":"1478067150","answer":"0","quote_id":"0","ask":"0","ask_point":null,"user_id":"88694","user_name":"一道微光带给我的","user_pic":"http://img.yidoutang.com/upload/user//pic/140.jpg","quote_author":null,"is_owner":false},{"group_id":"349300","content":"☺没呢","created":"1478060406","answer":"0","quote_id":"349280","ask":"0","ask_point":null,"user_id":"159483","user_name":"Mengying_L","user_pic":"http://img.yidoutang.com/upload/user//201610/f2/20161003124063f2.jpg","quote_author":"Emmamy","quote_content":"感觉好久木有见到你了呀，你家又丰富了呀","quote_authorid":"137914","is_owner":false},{"group_id":"349280","content":"感觉好久木有见到你了呀，你家又丰富了呀","created":"1478058432","answer":"0","quote_id":"0","ask":"0","ask_point":null,"user_id":"137914","user_name":"Emmamy","user_pic":"http://img.yidoutang.com/upload/user//pic/1302.jpg","quote_author":null,"is_owner":false}],"pagination":{"record_count":3,"page_count":1,"first":1,"last":1,"next":1,"prev":1,"current":1,"page_size":20,"page_base":1}}
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
         * record_count : 3
         * page_count : 1
         * first : 1
         * last : 1
         * next : 1
         * prev : 1
         * current : 1
         * page_size : 20
         * page_base : 1
         */

        private PaginationBean pagination;
        /**
         * group_id : 349392
         * content : 亲亲，你家的这个沙发巾是哪里买的？有没有链接啊？
         * created : 1478067150
         * answer : 0
         * quote_id : 0
         * ask : 0
         * ask_point : null
         * user_id : 88694
         * user_name : 一道微光带给我的
         * user_pic : http://img.yidoutang.com/upload/user//pic/140.jpg
         * quote_author : null
         * is_owner : false
         */

        private List<CommentsBean> comments;

        public PaginationBean getPagination() {
            return pagination;
        }

        public void setPagination(PaginationBean pagination) {
            this.pagination = pagination;
        }

        public List<CommentsBean> getComments() {
            return comments;
        }

        public void setComments(List<CommentsBean> comments) {
            this.comments = comments;
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

        public static class CommentsBean {
            private String group_id;
            private String content;
            private String created;
            private String answer;
            private String quote_id;
            private String ask;
            private Object ask_point;
            private String user_id;
            private String user_name;
            private String user_pic;
            private String quote_author;
            private String quote_content;
            private boolean is_owner;

            public String getQuote_content() {
                return quote_content;
            }

            public void setQuote_content(String quote_content) {
                this.quote_content = quote_content;
            }

            public String getGroup_id() {
                return group_id;
            }

            public void setGroup_id(String group_id) {
                this.group_id = group_id;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreated() {
                return created;
            }

            public void setCreated(String created) {
                this.created = created;
            }

            public String getAnswer() {
                return answer;
            }

            public void setAnswer(String answer) {
                this.answer = answer;
            }

            public String getQuote_id() {
                return quote_id;
            }

            public void setQuote_id(String quote_id) {
                this.quote_id = quote_id;
            }

            public String getAsk() {
                return ask;
            }

            public void setAsk(String ask) {
                this.ask = ask;
            }

            public Object getAsk_point() {
                return ask_point;
            }

            public void setAsk_point(Object ask_point) {
                this.ask_point = ask_point;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

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

            public String getQuote_author() {
                return quote_author;
            }

            public void setQuote_author(String quote_author) {
                this.quote_author = quote_author;
            }

            public boolean isIs_owner() {
                return is_owner;
            }

            public void setIs_owner(boolean is_owner) {
                this.is_owner = is_owner;
            }
        }
    }
}
