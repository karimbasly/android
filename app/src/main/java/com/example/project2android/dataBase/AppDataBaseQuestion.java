package com.example.project2android.dataBase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


import com.example.project2android.Entity.Question;
import com.example.project2android.dao.QuestionDao;

@Database(entities = {Question.class},version = 1,exportSchema = false)
public  abstract class AppDataBaseQuestion extends RoomDatabase {
    private static AppDataBaseQuestion instance;
    public abstract QuestionDao questionDao();

    public static synchronized AppDataBaseQuestion getInstance(final Context context){
        if (instance==null){
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBaseQuestion.class, "question_DB")
                    .fallbackToDestructiveMigration().addCallback(RoomDBCallBack)
                    .build();

        }
        return instance;
    }

    private static RoomDatabase.Callback RoomDBCallBack =new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db)
        {
            super.onCreate(db);
            new populateDbAsyncTask(instance).execute();
        }
    };
    public static class populateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private QuestionDao questionDao;
        private populateDbAsyncTask(AppDataBaseQuestion db){
            questionDao=db.questionDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            questionDao.insert(new Question("","","","",""));
            return null;
        }
    }
}
