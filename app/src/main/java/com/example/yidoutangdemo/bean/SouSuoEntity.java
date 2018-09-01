package com.example.yidoutangdemo.bean;


import com.lidroid.xutils.db.annotation.Column;
import com.lidroid.xutils.db.annotation.Id;
import com.lidroid.xutils.db.annotation.Table;
/**
 * Created by 天一 on 2016/11/3.
 */
@Table(name = "sousuo")
public class SouSuoEntity{
    @Id(column = "id")
    private int id;
    @Column(column = "search")
    private String search;

    public SouSuoEntity() {
    }

    public SouSuoEntity(int id, String search) {
        this.id = id;
        this.search = search;
    }

    public SouSuoEntity(String search) {
        this.search = search;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    @Override
    public String toString() {
        return "SouSuoEntity{" +
                "search='" + search + '\'' +
                '}';
    }
}
