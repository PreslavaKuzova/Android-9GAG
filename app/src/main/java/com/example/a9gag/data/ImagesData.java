package com.example.a9gag.data;

import com.example.a9gag.ImageItem;
import com.example.a9gag.R;

import java.util.ArrayList;
import java.util.List;

public class ImagesData {

    private static ImagesData data = null;
    public List<ImageItem> images;

    private ImagesData() {
        images = new ArrayList<>();
        fillImages();
    }

    public static ImagesData getInstance() {
        if (data == null) {
            data = new ImagesData();
        }
        return data;
    }

    private void fillImages() {
        images.add(new ImageItem(R.drawable.meme5, "AHAHAHhahahhaaAh"));
        images.add(new ImageItem(R.drawable.meme1, "Relatable"));
        images.add(new ImageItem(R.drawable.meme2, "Funny"));
        images.add(new ImageItem(R.drawable.meme3, "Very very funny"));
        images.add(new ImageItem(R.drawable.meme4, "Dying of laughter"));
        images.add(new ImageItem(R.drawable.meme5, "AHAHAHhahahhaaAh"));
        images.add(new ImageItem(R.drawable.meme1, "Relatable"));
        images.add(new ImageItem(R.drawable.meme2, "Funny"));
        images.add(new ImageItem(R.drawable.meme3, "Very very funny"));
        images.add(new ImageItem(R.drawable.meme4, "Dying of laughter"));
        images.add(new ImageItem(R.drawable.meme5, "AHAHAHhahahhaaAh"));
        images.add(new ImageItem(R.drawable.meme1, "Relatable"));
        images.add(new ImageItem(R.drawable.meme2, "Funny"));
        images.add(new ImageItem(R.drawable.meme3, "Very very funny"));
        images.add(new ImageItem(R.drawable.meme4, "Dying of laughter"));
        images.add(new ImageItem(R.drawable.meme5, "AHAHAHhahahhaaAh"));
        images.add(new ImageItem(R.drawable.meme1, "Relatable"));
        images.add(new ImageItem(R.drawable.meme2, "Funny"));
        images.add(new ImageItem(R.drawable.meme3, "Very very funny"));
        images.add(new ImageItem(R.drawable.meme4, "Dying of laughter"));
    }
}
