package com.example.project2android.Entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "pilot_table")
public class Pilot implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int idPilot;
    @ColumnInfo(name = "pilot_name")
    private String namePilot;
    @ColumnInfo(name = "pilot_dec")
    private String decPilot;
    @ColumnInfo(name = "pilot_img")
    private Integer imgPilot;
    public Pilot(String namePilot, String decPilot, Integer imgPilot) {
        this.namePilot = namePilot;
        this.decPilot = decPilot;
        this.imgPilot = imgPilot;
    }

    public Pilot() {

    }

    public int getIdPilot() {
        return idPilot;
    }

    public void setIdPilot(int idPilot) {
        this.idPilot = idPilot;
    }

    public String getNamePilot() {
        return namePilot;
    }

    public void setNamePilot(String namePilot) {
        this.namePilot = namePilot;
    }

    public Integer getImgPilot() {
        return imgPilot;
    }

    public void setImgPilot(Integer imgPilot) {
        this.imgPilot = imgPilot;
    }

    public String getDecPilot() {
        return decPilot;
    }

    public void setDecPilot(String decPilot) {
        this.decPilot = decPilot;
    }
}

