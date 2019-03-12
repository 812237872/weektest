package com.example.gaoshuai02_25;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.MyBaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView,drawer_list;
    private DrawerLayout layout;
    private ArrayList<String> list;
    private ArrayList<String> list1;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list_view);
        layout=findViewById(R.id.layout);
        drawer_list=findViewById(R.id.drawer_list);

        layout.setDrawerLockMode(Gravity.LEFT);
        layout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {
            }
            @Override
            public void onDrawerOpened(@NonNull View view) {
                Log.i("aaa","打开");
            }
            @Override
            public void onDrawerClosed(@NonNull View view) {
                Log.i("aaa","关闭");
            }
            @Override
            public void onDrawerStateChanged(int i) {
            }
        });

        list = new ArrayList<>();
        for (int i = 0; i <20 ; i++) {
            list.add("数据"+i);
        }
        MyBaseAdapter base=new MyBaseAdapter(MainActivity.this,list);
        listView.setAdapter(base);

        list1 = new ArrayList<>();
        list1.add("消息中心");
        list1.add("个人笔记");
        list1.add("我的分享");
        list1.add("团队动态");
        list1.add("快捷方式");
        MyBaseAdapter adapter=new MyBaseAdapter(MainActivity.this,list1);
        drawer_list.setAdapter(adapter);

        drawer_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this,"1",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
