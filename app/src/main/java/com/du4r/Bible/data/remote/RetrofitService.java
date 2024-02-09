package com.du4r.Bible.data.remote;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
   public static VerseApi getInstance(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.abibliadigital.com.br/api/verses/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .build();

        return retrofit.create(VerseApi.class);
    }
}
