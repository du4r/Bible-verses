package com.du4r.Bible.data.remote;

import com.du4r.Bible.domain.Verse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface VerseApi {
    @GET("acf/random")
    Observable<Verse>getRandomVerses();
}
