package com.example.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.adapter.ListAdapter;
import com.example.bean.New;
import com.example.gaoshuai218.R;
import com.example.util.HttpUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;


/**
* 首页  listview展示 请求数据
* @auther  ln
* created at 2019/2/18 10:20 
*/



public class ShouyeFragment extends Fragment {
    private String dataUrl="http://gank.io/api/data/%E7%A6%8F%E5%88%A9/10/1";
    private ListView listView;
    private ArrayList<New> lists;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shouye, container, false);
        listView=view.findViewById(R.id.list_view);
        return  view ;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new MyAsyncTask().execute(dataUrl);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), lists.get(position).getType(),Toast.LENGTH_SHORT).show();
            }
        });
    }


    //内部类  继承AsyncTask
    public class MyAsyncTask extends AsyncTask<String,Void,String>{

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("aaa","data"+s);
            lists = new ArrayList<>();
            try{
                JSONObject Data = new JSONObject(s);
                JSONArray array = Data.getJSONArray("results");
                for (int i = 0; i <array.length() ; i++) {
                    JSONObject object = array.getJSONObject(i);
                    String desc = object.getString("desc");
                    String publishedAt = object.getString("publishedAt");
                    String type = object.getString("type");
                    String url = object.getString("url");
                    lists.add(new New(desc,url,type,publishedAt));
                }
                ListAdapter adapter=new ListAdapter(getActivity(),lists);
                listView.setAdapter(adapter);
            }catch(Exception e){
              e.printStackTrace();
            }

        }

        @Override
        protected String doInBackground(String... strings) {
            String data = HttpUtils.getData(strings[0]);
            return data;
        }
    }
}
