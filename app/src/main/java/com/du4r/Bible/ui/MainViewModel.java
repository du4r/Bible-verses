package com.du4r.Bible.ui;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.du4r.Bible.data.remote.RetrofitService;
import com.du4r.Bible.data.remote.VerseApi;
import com.du4r.Bible.data.repository.LocalRepository;
import com.du4r.Bible.domain.Verse;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainViewModel extends AndroidViewModel {

    private final LocalRepository localRepository;

    public MainViewModel(Application application, LocalRepository localRepository) {
        super(application);
        this.localRepository = localRepository;
    }

    String TAG = "edbug";

    private ArrayList<Verse> verses = new ArrayList<>();
    private final MutableLiveData<ArrayList<Verse>> verseList = new MutableLiveData<>(verses);

    public LiveData<ArrayList<Verse>> getVerses() {
        return verseList;
    }

    void fetchRemoteData() {

        VerseApi service = RetrofitService.getInstance();

        service.getRandomVerses()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnNext(
                        verse -> {
                            verses.add(verse);
                            verseList.setValue(verses);
                            Log.d(TAG, verse.toString());
                        }
                ).subscribe();
    }

    void saveInDatabase(Verse v) {

        localRepository.insertVerse(v)
                .subscribeOn(Schedulers.io())
                .subscribe();

        Log.d(TAG, "VERSO SALVO!");
    }

}

