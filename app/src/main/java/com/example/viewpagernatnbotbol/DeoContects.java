package com.example.viewpagernatnbotbol;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface DeoContects {
    @Query("SELECT * FROM Contects")
    List<Contects> getallcontects();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void inserallcontects(List<Contects> mylistcontects);

    @Query("DELETE FROM Contects")
    void deletallcntects();
}
