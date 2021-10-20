package com.android.userroomdatabase.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.android.userroomdatabase.dao.UserDao;
import com.android.userroomdatabase.entities.UserEntity;

@Database(entities = {UserEntity.class},version = 1)
public abstract class UserDatabase extends RoomDatabase {
    //declare an abstract method for the dao call
    public abstract UserDao userDao();
}
