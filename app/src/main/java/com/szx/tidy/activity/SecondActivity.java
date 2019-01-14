package com.szx.tidy.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.szx.tidy.R;

public class SecondActivity extends AppCompatActivity {
    Toolbar toolbar;
    ImageView image;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("SecondView");
        image = findViewById(R.id.image);

//        String url = "https://pic.cnblogs.com/avatar/1142647/20170416093225.png";
        String url = "https://wx1.sinaimg.cn/large/006uGoWvgy1fz3lv4vpuuj31f12ip1l0.jpg";

        Glide.with(SecondActivity.this).load(url).into(image);
    }


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
