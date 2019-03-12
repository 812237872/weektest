package com.example.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.Bean.New;
import com.example.Bean.NewsBean;
import com.example.adapter.MyAdapter;
import com.example.dao.SqlDao;
import com.example.util.HttpUtil;
import com.example.week2_demo.R;
import com.google.gson.Gson;
import com.qy.xlistview.XListView;
import java.util.ArrayList;
import java.util.List;

public class ShouFragment extends Fragment {
    private XListView xListView;
    private List<New> list=new ArrayList<>();
    private MyAdapter adapter;
    private String dataUrl="http://api.expoon.com/AppNews/getNewsList/type/1/p/";
    private int page=1;
    private SqlDao dao;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_shou, container, false);
        xListView=view.findViewById(R.id.xlist_view);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        dao = new SqlDao(getActivity());

        adapter=new MyAdapter(list, getActivity());
        xListView.setAdapter(adapter);
        initData(page);
        xListView.setPullLoadEnable(true);
        xListView.setPullRefreshEnable(true);
        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
                list.clear();
                initData(page);
            }
            @Override
            public void onLoadMore() {
                page++;
                initData(page);
            }
        });
    }
    public void initData(int p){
        if(HttpUtil.isNetConnected(getActivity())){
            new MyAsyncTask().execute(dataUrl+p);
        }else{
            Toast.makeText(getActivity(),"请检查网络连接",Toast.LENGTH_SHORT).show();
            String query = dao.query(dataUrl + page);
            jsonData(query);
        }
    }
    class MyAsyncTask extends AsyncTask<String,Void,String>{
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            dao.insert(dataUrl+page,s);
            jsonData(s);

            stopLoad();
        }
        @Override
        protected String doInBackground(String... strings) {
            return HttpUtil.getData(strings[0]);
        }
    }
    private void jsonData(String s) {
        Gson gson=new Gson();
        NewsBean newsBean = gson.fromJson(s, NewsBean.class);
        list.addAll(newsBean.getData());
        adapter.notifyDataSetChanged();
    }
    public void stopLoad(){
        xListView.setRefreshTime("刚刚刷新");
        xListView.stopLoadMore();
        xListView.stopRefresh();
    }
}
