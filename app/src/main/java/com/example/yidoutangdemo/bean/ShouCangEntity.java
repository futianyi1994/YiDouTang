package com.example.yidoutangdemo.bean;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

/**
 * Created by 天一 on 2017/5/17.
 */
@Table(name = "shoucang")
public class ShouCangEntity {
    @Id(column = "id")
    private int id;
    @Column(column = "imagurl")
    private String imagurl;
    @Column(column = "title")
    private String title;
    @Column(column = "case_id")
    private String case_id;

    public ShouCangEntity() {
    }

    public ShouCangEntity(String imagurl, String title,String case_id) {
        this.case_id = case_id;
        this.imagurl = imagurl;
        this.title = title;
    }

    public String getCase_id() {
        return case_id;
    }

    public void setCase_id(String case_id) {
        this.case_id = case_id;
    }

    public String getImagurl() {
        return imagurl;
    }

    public void setImagurl(String imagurl) {
        this.imagurl = imagurl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ShouCangEntity{" +
                "id=" + id +
                ", imagurl='" + imagurl + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
