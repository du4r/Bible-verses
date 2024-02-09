package com.du4r.Bible.domain;


import androidx.annotation.NonNull;

import com.du4r.Bible.data.local.BookLocalModel;
import com.du4r.Bible.data.local.VerseLocalModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Verse {

    @SerializedName("book")
    @Expose
    Book book;


    @SerializedName("chapter")
    @Expose
    int chapter;

    @SerializedName("number")
    @Expose
    int number;

    @SerializedName("text")
    @Expose
    String text;

    public Verse(Book book, int chapter, int number, String text){
        this.book = book;
        this.chapter = chapter;
        this.number = number;
        this.text = text;
    }

    public Verse(){}

    @NonNull
    @Override
    public String toString() {
        return  "Verse{"  + book.name  + ", chapter=" + chapter + ", number=" + number + ',' +
                " text=" + text +
                '}';
    }

    public Book getBook() {
        return book;
    }
    public void setBook(Book book) {
        this.book = book;
    }
    public Integer getChapter() {
        return chapter;
    }
    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }
    public Integer getNumber() {
        return number;
    }
    public void setNumber(Integer number) {
        this.number = number;
    }
    public String getText() {
        return text;
    }

    public VerseLocalModel toVerseLocalModel(){
        return new VerseLocalModel(new BookLocalModel(this.book.name),this.chapter,this.number,this.text);
    }
    public void setText(String text) {
        this.text = text;
    }
}
