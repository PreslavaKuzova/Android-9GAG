package com.example.a9gag;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CommentItem {
    String content;
    String date;
    String username;

    public CommentItem(String content, String username) {
        this.content = content;
        this.date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        this.username = username;
    }
}
