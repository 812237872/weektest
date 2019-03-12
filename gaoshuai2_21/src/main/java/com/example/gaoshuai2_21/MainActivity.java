package com.example.gaoshuai2_21;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.MyAdapter;
import com.example.bean.DataBean;
import com.example.bean.New;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {
private ListView listView;
private String dataUrl="http://api.dagoogle.cn/news/nlist";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);

        new MyAsyncTask().execute(dataUrl);
    }
    public class MyAsyncTask extends AsyncTask<String,Void,String>{
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson=new Gson();
            DataBean data = gson.fromJson(s, DataBean.class);
            List<New> list = data.getData().getList();
            MyAdapter base=new MyAdapter(list,MainActivity.this);
            listView.setAdapter(base);
        }

        @Override
        protected String doInBackground(String... strings) {
            String data = HttpUtils.getData(strings[0]);
            return data;
        }
    }

}
