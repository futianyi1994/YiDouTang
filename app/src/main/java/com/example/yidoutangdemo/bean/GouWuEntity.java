package com.example.yidoutangdemo.bean;

import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;

/**
 * Created by 天一 on 2017/5/18.
 */
@Table(name = "gouwu")
public class GouWuEntity {
    @Id(column = "id")
    private int id;
    @Column(column = "imagurl")
    private String imagurl;
    @Column(column = "title")
    private String title;
    @Column(column = "price")
    private String price;

    public GouWuEntity() {
    }

    public GouWuEntity(String imagurl, String price, String title) {
        this.imagurl = imagurl;
        this.price = price;
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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
        return "GouWuEntity{" +
                "id=" + id +
                ", imagurl='" + imagurl + '\'' +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
