package com.du4r.Bible.data.local;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;


import java.util.List;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;

@Dao
public interface VerseDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(VerseLocalModel verse);

    @Query("SELECT * FROM verselocalmodel")
    Flowable<List<VerseLocalModel>>getAll();
}
