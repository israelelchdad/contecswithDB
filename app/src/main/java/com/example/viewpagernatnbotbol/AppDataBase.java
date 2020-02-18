package com.example.viewpagernatnbotbol;

import android.app.Activity;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
@Database(entities =Contects.class , version =3)
public abstract class AppDataBase extends RoomDatabase {
    public static final String DATABASE_NAME = "contects";
    public abstract DeoContects myDeoContects();
    private static AppDataBase INSTANCE;
    public static AppDataBase getINSTANCE(Activity activity){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(activity.getApplication(),AppDataBase.class,DATABASE_NAME)
                    .allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return INSTANCE;
    }
    public static void destroyinstance(){
        INSTANCE=null;

    }

}
