package com.example.week2_demo;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.adapter.MyPagerAdapter;
import com.example.fragment.CangFragment;
import com.example.fragment.MyFragment;
import com.example.fragment.ShouFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawer_layout;
    private ViewPager view_pager;
    private TabLayout tab_layout;
    private Button btn_open,btn_close;
    private List<Fragment> list=new ArrayList<>();
    private String[] titles={"首页","收藏","我的"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawer_layout=findViewById(R.id.drawer_layout);
        view_pager=findViewById(R.id.view_pager);
        tab_layout=findViewById(R.id.tab_layout);
        btn_open=findViewById(R.id.btn_open);
        btn_close=findViewById(R.id.btn_close);


        drawer_layout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNDEFINED);
        btn_open.setOnClickListener(this);
        btn_close.setOnClickListener(this);
        drawer_layout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {
            }
            @Override
            public void onDrawerOpened(@NonNull View view) {
                Toast.makeText(MainActivity.this,"打开",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onDrawerClosed(@NonNull View view) {
                Toast.makeText(MainActivity.this,"关闭",Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onDrawerStateChanged(int i) {
            }
        });

        //添加页面
        list.add(new ShouFragment());
        list.add(new CangFragment());
        list.add(new MyFragment());
        MyPagerAdapter adapter=new MyPagerAdapter(getSupportFragmentManager(),list,titles);

        view_pager.setAdapter(adapter);
        tab_layout.setupWithViewPager(view_pager);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
           case R.id.btn_open:
               drawer_layout.openDrawer(Gravity.LEFT);
                break;
           case R.id.btn_close:
               drawer_layout.closeDrawer(Gravity.LEFT);
                break;
           default : break;
        }

    }
}
