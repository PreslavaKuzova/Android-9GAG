package com.example.a9gag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.a9gag.data.ImagesData;
import com.example.a9gag.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private ImagesData data;
    private ImageGalleryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = ImagesData.getInstance();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        adapter = new ImageGalleryAdapter(data.images, getButtonListeners());
        binding.recView.setLayoutManager(new LinearLayoutManager(this));
        binding.recView.setAdapter(adapter);
    }

    private ImageItemButtonsClickListener getButtonListeners() {
        return new ImageItemButtonsClickListener() {
            @Override
            public void onUpButtonClicked(int position) {
                if (data.images.get(position).isButtonDownPressed) {
                    data.images.get(position).points+=2;
                } else {
                    data.images.get(position).points++;
                }
                data.images.get(position).isButtonUpPressed = true;
                data.images.get(position).isButtonDownPressed = false;
                adapter.notifyItemChanged(position);
            }

            @Override
            public void onDownButtonClicked(int position) {
                if (data.images.get(position).isButtonUpPressed) {
                    data.images.get(position).points-=2;
                } else {
                    data.images.get(position).points--;
                }
                data.images.get(position).isButtonDownPressed = true;
                data.images.get(position).isButtonUpPressed = false;
                adapter.notifyItemChanged(position);
            }

            @Override
            public void onCommentButtonClicked(int position) {
                Intent intent = new Intent(MainActivity.this, CommentActivity.class);
                String message = data.images.get(position).description;
                intent.putExtra("DESCRIPTION", message);
                intent.putExtra("POSITION", String.valueOf(position));
                startActivity(intent);
            }

            @Override
            public void onShareButtonClicked(int position) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
               
                Uri imageUri = Uri.parse("android.resource://" + getPackageName() + "/"
                        + data.images.get(position).imgResource);

                sendIntent.putExtra(Intent.EXTRA_STREAM, imageUri);
                sendIntent.setType("image/jpeg");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
            }

        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}