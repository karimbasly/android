package com.example.project2android.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.project2android.Entity.Pilot;
import java.util.List;
@Dao
public interface PilotDao {
    @Insert
    void insertOne(Pilot pilot);
    @Delete

    void delete(Pilot pilot);
    @Query("SELECT * FROM pilot_table")
    List<Pilot> getAll();
}
