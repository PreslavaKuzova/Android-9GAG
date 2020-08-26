package com.example.a9gag;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CommentItemViewHolder extends RecyclerView.ViewHolder {
    TextView txtContent;
    TextView txtDate;
    TextView txtUsername;

    public CommentItemViewHolder(@NonNull View itemView) {
        super(itemView);
        initFields(itemView);
    }

    private void initFields(@NonNull View itemView) {
        this.txtContent = itemView.findViewById(R.id.txt_content);
        this.txtDate = itemView.findViewById(R.id.txt_date);
        this.txtUsername = itemView.findViewById(R.id.txt_username);
    }
}
