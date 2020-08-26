package com.example.a9gag;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentItemViewHolder> {

    List<CommentItem> items;

    public CommentAdapter(List<CommentItem> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public CommentItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        CommentItemViewHolder holder = new CommentItemViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CommentItemViewHolder holder, int position) {
        CommentItem item = items.get(position);
        holder.txtContent.setText(item.content);
        holder.txtDate.setText(item.date);
        holder.txtUsername.setText(item.username);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addComment(CommentItem item) {
        this.items.add(item);
        this.notifyItemInserted(items.size());
    }
}
