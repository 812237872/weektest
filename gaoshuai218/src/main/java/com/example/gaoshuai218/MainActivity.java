package com.example.gaoshuai218;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.adapter.MyAdapter;
import com.example.fragment.MyFragment;
import com.example.fragment.ShouyeFragment;

import java.util.ArrayList;
/**
* viewpager结合 group 展示
* @auther  ln
* created at 2019/2/18 10:30
*/



public class MainActivity extends AppCompatActivity {

    private ViewPager pager;
    private RadioGroup group;
    private ArrayList<Fragment> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //资源id
        pager=findViewById(R.id.view_pager);
        group=findViewById(R.id.radio_group);
        //数据源
        list = new ArrayList<>();
        list.add(new ShouyeFragment());
        list.add(new MyFragment());
        //创建适配器
        MyAdapter adapter=new MyAdapter(getSupportFragmentManager(),list);
        //设置适配器
        pager.setAdapter(adapter);

        //pager监听
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }
            @Override
            public void onPageSelected(int i) {
                group.check(group.getChildAt(i).getId());
            }
            @Override
            public void onPageScrollStateChanged(int i) {
            }
        });
        //设置group监听
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                   case R.id.rb1:pager.setCurrentItem(0,false);
                        break;
                   case R.id.rb2:pager.setCurrentItem(1,false);
                        break;
                   default : break;
                }
            }
        });
    }
}
