package com.example.d8_moreload;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.MyBaseAdapter;
import com.example.bean.New;
import com.example.bean.NewsData;
import com.example.util.HttpUtils;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String url ="http://www.xieast.com/api/news/news.php?page=1";
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.list_view);

        new MyAsyncTask().execute(url);

    }
    public class MyAsyncTask extends AsyncTask<String,Void,String>{


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Gson gson=new Gson();
            NewsData newDate = gson.fromJson(s, NewsData.class);
            List<New> list = newDate.getData();
            MyBaseAdapter base=new MyBaseAdapter(MainActivity.this,list);
            listView.setAdapter(base);
        }


        @Override
        protected String doInBackground(String... strings) {
            String data = HttpUtils.getData(strings[0]);
            return data;
        }
    }
}
