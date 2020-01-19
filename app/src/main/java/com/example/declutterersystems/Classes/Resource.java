package com.example.declutterersystems.Classes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.declutterersystems.DataBase.AppDatabase;

@Entity(tableName = AppDatabase.RESOURCE_TABLE)
public class Resource {
    @PrimaryKey(autoGenerate = true)
    private int ID;

    private String name;
    private String desc;
    private String accepts;
    private String url;


    public Resource(String name, String desc, String accepts, String url) {
        this.name = name;
        this.desc = desc;
        this.accepts = accepts;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAccepts() {
        return accepts;
    }

    public void setAccepts(String accepts) {
        this.accepts = accepts;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getID() {
        return ID;
    }

//    public void setID(int ID) {
//        this.ID = ID;
//    }

    @Override
    public String toString() {
        return "Resource{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                ", accepts='" + accepts + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
