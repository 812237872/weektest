package com.example.a81223.weektest;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.a81223.adapter.MyBaseAdapter;
import com.example.a81223.bean.New;
import com.example.a81223.bean.NewsBean;
import com.example.a81223.util.HttpUtils;
import com.google.gson.Gson;
import com.qy.xlistview.XListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private XListView xListView;
    private List<New> list=new ArrayList<>();
    private String url="http://www.93.gov.cn/93app/data.do?channelId=0&startNum=";
    private int page=1;
    private MyBaseAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        xListView=findViewById(R.id.xlist_view);
        adapter = new MyBaseAdapter(list,MainActivity.this);
        xListView.setAdapter(adapter);
        xListView.setPullRefreshEnable(true);
        xListView.setPullLoadEnable(true);
        new MyAsyncTask().execute(url+page);
        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                list.clear();
                new MyAsyncTask().execute(url+page);
            }
            @Override
            public void onLoadMore() {
                page++;
                new MyAsyncTask().execute(url+page);
            }
        });

    }
    public class MyAsyncTask extends AsyncTask<String,Void,String>{

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson=new Gson();
            NewsBean newsBean = gson.fromJson(s, NewsBean.class);
            list.addAll(newsBean.getData());
            adapter.notifyDataSetChanged();
            stopLoad();
        }

        @Override
        protected String doInBackground(String... strings) {
            return HttpUtils.getData(strings[0]);
        }
    }
    public void stopLoad(){
        xListView.setRefreshTime("刚刚刷新");
        xListView.stopRefresh();
        xListView.stopLoadMore();
    }
}
