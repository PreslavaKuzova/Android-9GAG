package com.example.a9gag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a9gag.data.ImagesData;
import com.example.a9gag.databinding.ActivityCommentBinding;

public class CommentActivity extends AppCompatActivity {

    private ImagesData data;
    private CommentAdapter adapter;
    private ActivityCommentBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_comment);
        data = ImagesData.getInstance();

        TextView txtName = binding.txtName;

        Intent intent = getIntent();
        String name = intent.getStringExtra("DESCRIPTION");
        final int position = Integer.parseInt(intent.getStringExtra("POSITION"));

        txtName.setText(txtName.getText().toString() + " " + name);

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.images.get(position).comments++;
            }
        });
    }

    private void setupRecyclerView() {
        adapter = new CommentAdapter();
    }
}