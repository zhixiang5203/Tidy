package com.szx.tidy.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.szx.tidy.R;
import com.szx.tidy.base.ARouterPath;
import com.szx.tidy.base.BaseFragment;
import com.szx.tidy.widget.YALikeAnimationView;


/**
 * @Desc FragmentNews
 */
@Route(path = ARouterPath.DisplayListFgt)
public class FragmentDisplay extends BaseFragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private View mRootView;
    private ImageView like;
    private boolean isChecked = false;

    public FragmentDisplay() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentNews.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDisplay newInstance(String param1, String param2) {
        FragmentDisplay fragment = new FragmentDisplay();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void init() {
        like = (ImageView) mRootView.findViewById(R.id.like);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isChecked) {
                    Toast.makeText(getContext(), "取消关注", Toast.LENGTH_SHORT).show();
                    like.setImageResource(R.mipmap.ic_collect);
                    isChecked = false;
                } else {
                    Toast.makeText(getContext(), "关注成功", Toast.LENGTH_SHORT).show();
                    like.setImageResource(R.mipmap.icon_like_png);
                    isChecked = true;
                }

            }
        });
        YALikeAnimationView ya = (YALikeAnimationView) mRootView.findViewById(R.id.yalike);
        ya.startAnimation();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mRootView = inflater.inflate(R.layout.fragment_display, container, false);

        init();
        return mRootView;
    }
}
