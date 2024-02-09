package com.du4r.Bible.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.du4r.Bible.data.repository.LocalRepository;


public class MainViewModelFactory implements ViewModelProvider.Factory {

    private final Application application;
    private final LocalRepository localRepository;

    public MainViewModelFactory(Application application, LocalRepository localRepository) {
        this.application = application;
        this.localRepository = localRepository;
    }

    @Override
    @NonNull
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(application, localRepository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}