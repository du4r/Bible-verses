package com.du4r.Bible.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.du4r.Bible.R;
import com.du4r.Bible.domain.Verse;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class VerseAdapter extends RecyclerView.Adapter<VerseAdapter.ViewHolder> {

    private List<Verse> verses;
    private MainViewModel viewModel;

    public void setVerses(List<Verse> v) {
        this.verses = v;
        notifyDataSetChanged();
    }


    public VerseAdapter(List<Verse> verses, MainViewModel viewModel) {
        this.verses = verses;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.verse_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvVerse.setText(verses.get(position).getText());
        holder.tvBook.setText(verses.get(position).getBook().getName());
        holder.tvNumber.setText(verses.get(position).getNumber().toString());
        holder.tvChapter.setText(verses.get(position).getChapter().toString());

        holder.btnSave.setOnClickListener(view -> {
            viewModel.saveInDatabase(verses.get(position));
        });

    }

    @Override
    public int getItemCount() {
        return verses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvBook;
        TextView tvChapter;
        TextView tvNumber;
        TextView tvVerse;
        FloatingActionButton btnSave;

        public ViewHolder(View view) {
            super(view);
            tvBook = view.findViewById(R.id.tv_book);
            tvChapter = view.findViewById(R.id.tv_chapter);
            tvNumber = view.findViewById(R.id.tv_number);
            tvVerse = view.findViewById(R.id.tv_verse);
            btnSave = view.findViewById(R.id.save_btn);
        }
    }
}
