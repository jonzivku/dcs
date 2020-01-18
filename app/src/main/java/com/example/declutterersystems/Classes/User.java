package com.example.declutterersystems.Classes;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.example.declutterersystems.DataBase.AppDatabase;

@Entity(tableName = AppDatabase.USER_TABLE)
public class User {

    @PrimaryKey(autoGenerate = true)
    private int userId;
    private String name;
    private Boolean loggedIn;


    // constructor
    public User (String name, Boolean loggedIn){
        this.name = name;
        this.loggedIn = loggedIn;
    }

    public Boolean getLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(Boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
