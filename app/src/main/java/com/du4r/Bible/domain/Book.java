package com.du4r.Bible.domain;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Book {
    @SerializedName("name")
    @Expose
    String name;

    public Book(String name){
        this.name = name;
    }
    public Book(){}

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
