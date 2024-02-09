package com.du4r.Bible.data.local;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;

public class BookLocalModel {

    @ColumnInfo(name = "name")
    String name;

    public BookLocalModel(String name){
        this.name = name;
    }


    @NonNull
    @Override
    public String toString() {
        return  "Book={" + "name = " + name  + "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
