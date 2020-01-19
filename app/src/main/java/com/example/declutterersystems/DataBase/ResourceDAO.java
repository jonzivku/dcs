package com.example.declutterersystems.DataBase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.declutterersystems.Classes.Resource;

import java.util.List;

@Dao
public interface ResourceDAO {

    @Insert
    public void insert(Resource... Resources);

    @Update
    public void update(Resource... Resources);

    @Delete
    public void delete(Resource... Resources);

    @Query("SELECT * FROM " + AppDatabase.RESOURCE_TABLE)
    public List<Resource> getResources();
}
