package com.example.declutterersystems.DataBase;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.declutterersystems.Classes.Resource;
import com.example.declutterersystems.Classes.User;

@Database(entities = {User.class, Resource.class}, version = 3, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public static final String dbName = "df-User";

    public static final String USER_TABLE = "user";

    public abstract UserDAO getUserDAO();

    public static final String dbNameResource = "db-ResourceName";

    public static final String RESOURCE_TABLE = "resource";

    public abstract ResourceDAO getResourceDAO();

}