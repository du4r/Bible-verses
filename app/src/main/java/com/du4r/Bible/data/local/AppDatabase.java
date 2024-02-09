package com.du4r.Bible.data.local;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;


import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;


@Database(
        entities = {VerseLocalModel.class},
        version = 2)
@TypeConverters(Converters.class)
public abstract class AppDatabase extends RoomDatabase {
    public abstract VerseDao verseDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, "my_db")
                    //.fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }

    public Flowable<List<VerseLocalModel>> getAllVerses(){
        return INSTANCE.verseDao().getAll();
    }

    public Completable insertVerse(VerseLocalModel verse) {
        return INSTANCE.verseDao().insert(verse);
    }
}
