package com.example.testpractice;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MelodiesAdapter extends RecyclerView.Adapter<MelodiesAdapter.ViewHolder> {

    // 2. List Field & Constructor:
    List<Melody> listItems;
    public MelodiesAdapter(List<Melody> listItems) {
        this.listItems = listItems;
    }

    // 3. I have no idea, just memorize it:
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        return new ViewHolder(v);
    }

    // 4. Here we set the values in the item layout:
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Melody melody = listItems.get(position);
        holder.tvTitle.setText(melody.getTitle());
        holder.tvArtist.setText(melody.getArtist());

        try {
            Bitmap coverImgBitmap = getCoverBitmap(melody.getCoverImageUrl());
            holder.ivCover.setImageBitmap(coverImgBitmap);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Bitmap getCoverBitmap (String url) throws ExecutionException, InterruptedException {
        return Executors.newFixedThreadPool(3).submit(new DownloadCallableTask(url)).get();
    }

    // * don't forget the size matters:
    @Override
    public int getItemCount() {
        return listItems.size();
    }

    // 1. The representation of the item layout in Java code:
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle;
        public TextView tvArtist;
        public ImageView ivCover;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvArtist = itemView.findViewById(R.id.tvArtist);
            ivCover = itemView.findViewById(R.id.ivCover);
        }
    }
}
