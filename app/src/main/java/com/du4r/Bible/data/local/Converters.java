package com.du4r.Bible.data.local;

import androidx.room.TypeConverter;


public class Converters {

    @TypeConverter
    public String fromBook(BookLocalModel book){
        return book.toString();
    }

    @TypeConverter
    public BookLocalModel toBook(String name){
        return new BookLocalModel(name);
    }
}
