package com.szx.tidy.activity;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.szx.tidy.R;
import com.szx.tidy.adapter.RecyclerAdapter;
import com.szx.tidy.databinding.ActivityRecyclerBinding;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    ActivityRecyclerBinding binding;
    List<String> mDatas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_recycler);
        binding.toolbar.setTitle("RECYCLER");
        initData();
        RecyclerAdapter adapter = new RecyclerAdapter(this, mDatas);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);

    }


    private void initData() {
        mDatas = new ArrayList<String>();
        mDatas.add("开始来访客户");
        mDatas.add("就 卡拉就是了");
        mDatas.add("阿斯蒂芬阿斯蒂芬");
        mDatas.add("阿斯顿发深V爱车vas");
        mDatas.add("啊撒阿女");
        mDatas.add("啊啊吧杀神风");
        mDatas.add("啊vas大声道");
        mDatas.add("阿萨是大V啊是的");
        mDatas.add("阿达撒阿是大V啊是");
        mDatas.add(" 阿萨斯");
        mDatas.add("阿深V吧吧v");
        mDatas.add("啊啊啊啊啊");
    }

    private void runLayoutAnimation(final RecyclerView recyclerView) {
        final Context context = recyclerView.getContext();
        final LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(context, R.anim.layout_animation_fall_down);

        recyclerView.setLayoutAnimation(controller);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    @Override
    protected void onStart() {
        super.onStart();
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


