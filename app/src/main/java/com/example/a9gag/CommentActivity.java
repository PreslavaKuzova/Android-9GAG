package com.example.a9gag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.example.a9gag.data.ImagesData;
import com.example.a9gag.databinding.ActivityCommentBinding;

import java.util.ArrayList;
import java.util.List;

public class CommentActivity extends AppCompatActivity {

    private ImagesData data;
    private CommentAdapter adapter;
    private ActivityCommentBinding binding;

    private List<CommentItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        items = new ArrayList<>();
        setLCommentItemListData();

        binding = DataBindingUtil.setContentView(this, R.layout.activity_comment);
        data = ImagesData.getInstance();

        TextView txtName = binding.txtName;

        Intent intent = getIntent();
        String name = intent.getStringExtra("DESCRIPTION");
        final int position = Integer.parseInt(intent.getStringExtra("POSITION"));

        txtName.setText(txtName.getText().toString() + " " + name);

        binding.btnSend.setEnabled(false);

        binding.edtComment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                binding.btnSend.setEnabled(true);
            }
        });

        binding.btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.images.get(position).comments++;
                String comment = binding.edtComment.getText().toString();
                adapter.addComment(new CommentItem(comment, "me"));
                binding.edtComment.getText().clear();
                binding.btnSend.setEnabled(false);
            }
        });

        setupRecyclerView();
    }

    private void setupRecyclerView() {
        adapter = new CommentAdapter(items);
        binding.recView.setLayoutManager(new LinearLayoutManager(this));
        binding.recView.setAdapter(adapter);
    }

    private void setLCommentItemListData() {
        this.items.add(new CommentItem("short comment", "presi"));
        this.items.add(new CommentItem("longer comment to test how this is going to look", "presi"));
        this.items.add(new CommentItem("longer longer longer comment to test how this is going to look", "presi"));
        this.items.add(new CommentItem("longer comment to test how this is going to look", "presi"));
    }
}