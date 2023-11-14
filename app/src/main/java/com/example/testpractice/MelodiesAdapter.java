package com.example.testpractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

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
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvArtist = itemView.findViewById(R.id.tvArtist);
        }
    }
}
