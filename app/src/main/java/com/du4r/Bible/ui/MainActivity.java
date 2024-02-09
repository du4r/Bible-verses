package com.du4r.Bible.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.du4r.Bible.R;
import com.du4r.Bible.data.local.AppDatabase;
import com.du4r.Bible.data.repository.LocalRepository;
import com.du4r.Bible.data.repository.LocalRepositoryImpl;
import com.du4r.Bible.domain.Verse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    LocalRepository localRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getDatabase(this);
        localRepository = new LocalRepositoryImpl(db);

        MainViewModelFactory vmFactory = new MainViewModelFactory(getApplication(), localRepository);
        viewModel = new ViewModelProvider(this, vmFactory).get(MainViewModel.class);

        viewModel.fetchRemoteData();

        viewModel.getVerses().observe(this, verses -> {
            setupUi(verses);
            progressBar.setVisibility(View.GONE);
        });
    }


    void setupUi(List<Verse> verses) {
        rvMain = findViewById(R.id.rv_main);
        rvMain.setLayoutManager(new LinearLayoutManager(this));
        adapter = new VerseAdapter(verses, viewModel);
        rvMain.setAdapter(adapter);

        adapter.setVerses(verses);

        progressBar = findViewById(R.id.main_progress);

        fabAdd = findViewById(R.id.add_fab);
        fabAdd.setOnClickListener(view -> {
            progressBar.setVisibility(View.VISIBLE);
            viewModel.fetchRemoteData();
        });
    }

    MainViewModel viewModel;
    private AppDatabase db;
    VerseAdapter adapter;
    RecyclerView rvMain;
    ProgressBar progressBar;
    FloatingActionButton fabAdd;
}

