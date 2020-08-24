package com.example.a9gag;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageItemViewHolder extends RecyclerView.ViewHolder {

    TextView txtDescription;
    ImageView img;
    TextView txtPoints;
    TextView txtComments;
    int position;
    Button btnUp;
    Button btnDown;
    Button btnComment;
    Button btnShare;


    public ImageItemViewHolder(@NonNull View itemView, final ImageItemButtonsClickListener listener) {
        super(itemView);
        initFields(itemView);
        setListeners(listener);
    }

    private void setListeners(final ImageItemButtonsClickListener listener) {
        this.btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onUpButtonClicked(position);
            }
        });

        this.btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onDownButtonClicked(position);
            }
        });

        this.btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCommentButtonClicked(position);
            }
        });

        this.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onShareButtonClicked(position);
            }
        });
    }

    private void initFields(@NonNull View itemView) {
        this.txtDescription = itemView.findViewById(R.id.txt_description);
        this.img = itemView.findViewById(R.id.img);
        this.txtPoints = itemView.findViewById(R.id.txt_points_count);
        this.txtComments = itemView.findViewById(R.id.txt_comments_count);
        this.btnUp = itemView.findViewById(R.id.btn_up);
        this.btnDown = itemView.findViewById(R.id.btn_down);
        this.btnComment = itemView.findViewById(R.id.btn_comment);
        this.btnShare = itemView.findViewById(R.id.btn_share);
    }
}
