package com.example.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.gaoshuai218.R;
/**
* 我的 fangment  展示头像
* @auther  ln
* created at 2019/2/18 10:30
*/



public class MyFragment extends Fragment {
    private ImageView image;
    private String url="https://ws1.sinaimg.cn/large/0065oQSqly1g04lsmmadlj31221vowz7.jpg";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        image=view.findViewById(R.id.image);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Glide.with(getActivity()).load(url).into(image);
    }

}
