package com.example.project2android.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Question_table")
public class Question {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "IdQuestion")
    private int idQuestion;
    @ColumnInfo(name = "Question")
    private String question;
    @ColumnInfo(name = "Opt_A")
    private String optA;
    @ColumnInfo(name = "Opt_B")
    private String optB;
    @ColumnInfo(name = "Opt_C")
    private String optC;
    @ColumnInfo(name = "Answer")
    private String answer;

    public Question(String question, String optA, String optB, String optC, String answer) {
        this.question = question;
        this.optA = optA;
        this.optB = optB;
        this.optC = optC;
        this.answer = answer;
    }
    public Question(){

    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOptA() {
        return optA;
    }

    public void setOptA(String optA) {
        this.optA = optA;
    }

    public String getOptB() {
        return optB;
    }

    public void setOptB(String optB) {
        this.optB = optB;
    }

    public String getOptC() {
        return optC;
    }

    public void setOptC(String optC) {
        this.optC = optC;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
