package com.example.project2android.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.project2android.Entity.Question;

import java.util.List;

@Dao
public interface QuestionDao {


    @Insert
    void insert(Question question);

    @Query("SELECT * FROM question_table")
    LiveData<List<Question>> getAll();
}
