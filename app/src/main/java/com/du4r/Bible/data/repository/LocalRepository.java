package com.du4r.Bible.data.repository;

import com.du4r.Bible.domain.Verse;

import io.reactivex.rxjava3.core.Completable;

public interface LocalRepository {
    public Completable insertVerse(Verse verse);
}
