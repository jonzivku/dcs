package com.example.declutterersystems.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.declutterersystems.Classes.User;

import java.util.List;

@Dao
public interface UserDAO {


    @Insert
    public void insert(User... users);

    @Update
    public void update(User... users);

    @Delete
    public void delete(User... users);

    @Query("SELECT * FROM " + AppDatabase.USER_TABLE)
    public List<User> getUsers();
}
