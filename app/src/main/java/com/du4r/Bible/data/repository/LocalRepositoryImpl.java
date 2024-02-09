package com.du4r.Bible.data.repository;

import com.du4r.Bible.data.local.AppDatabase;
import com.du4r.Bible.data.local.VerseLocalModel;
import com.du4r.Bible.domain.Verse;

import io.reactivex.rxjava3.core.Completable;

public class LocalRepositoryImpl implements LocalRepository{

    private final AppDatabase db;

    public LocalRepositoryImpl(AppDatabase db){
        this.db = db;
    }

    @Override
    public Completable insertVerse(Verse verse) {
       return db.insertVerse(verse.toVerseLocalModel());
    }
}
