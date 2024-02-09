package com.du4r.Bible.data.local;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.du4r.Bible.domain.Book;
import com.du4r.Bible.domain.Verse;


@Entity
public class VerseLocalModel {

    @TypeConverters()
    @ColumnInfo(name = "book") BookLocalModel book;
    @PrimaryKey
    @ColumnInfo(name = "chapter") int chapter;

    @ColumnInfo(name = "number") int number;

    @ColumnInfo(name = "text") String text;

    @NonNull
    @Override
    public String toString() {
        return  "Verse{"  + book.name  + ", chapter=" + chapter + ", number=" + number + ',' +
                " text=" + text +
                '}';
    }

    public VerseLocalModel(BookLocalModel book, int chapter, int number, String text){
        this.book = book;
        this.chapter = chapter;
        this.number = number;
        this.text = text;
    }

    public VerseLocalModel(){}

    public Verse toVerse(){
        return new Verse(new Book(this.book.name),this.chapter,this.number,this.text);
    }
    public BookLocalModel getBook() {
        return book;
    }
    public void setBook(BookLocalModel book) {
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
    public void setText(String text) {
        this.text = text;
    }
}
