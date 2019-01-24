package com.szx.tidy.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.szx.tidy.bean.UserData;
import com.szx.tidy.databinding.ActivityMvvmBinding;
import com.bumptech.glide.Glide;
import com.szx.tidy.R;
import com.szx.tidy.model.MVVMViewModel;

public class MvvmActivity extends AppCompatActivity {
    ActivityMvvmBinding activityMvvmBinding;
    MVVMViewModel mvvmViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMvvmBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
        activityMvvmBinding.getRoot().setFitsSystemWindows(true);
        activityMvvmBinding.toolbar.setTitle("MVVM");
        activityMvvmBinding.mvvmText.setText("你好");
        activityMvvmBinding.click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mvvmViewModel != null) {
                    mvvmViewModel.setData();
                }
            }
        });
//        activityMvvmBinding.image.setImageResource(R.drawable.bbs_add_emoji);
        String url = "https://wx1.sinaimg.cn/large/006uGoWvgy1fz3lv4vpuuj31f12ip1l0.jpg";

        Glide.with(this).load(url).into(activityMvvmBinding.image);

        mvvmViewModel = ViewModelProviders.of(this).get(MVVMViewModel.class);
        mvvmViewModel.getLiveObservableData().observe(this, new Observer<UserData>() {
            @Override
            public void onChanged(@Nullable UserData userData) {
                if (userData != null) {
                    activityMvvmBinding.mvvmText.setText(userData.getResults());
                    return;
                }
                activityMvvmBinding.mvvmText.setText("nothing");
            }
        });
        ViewModelProviders.of(MvvmActivity.this).get(MVVMViewModel.class);

//        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm);
//        binding.setViewModel(new MainViewModel(binding));
    }
}
