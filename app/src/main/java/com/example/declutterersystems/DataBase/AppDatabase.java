package com.example.declutterersystems.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.declutterersystems.Classes.User;

@Database(entities = User.class, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String dbName = "df-User";

    public static final String USER_TABLE = "user";

    public abstract UserDAO getUserDAO();

}