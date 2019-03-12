package com.example.gaoshuai2_19;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.util.HttpUtils;

public class MainActivity extends AppCompatActivity {
    private EditText edit;
    private ListView listView;
    private Button but;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit=findViewById(R.id.edit_text);
        listView=findViewById(R.id.list_view);
        but=findViewById(R.id.but_cha);

        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyAsyncTask().execute();
            }
        });
    }

    public class MyAsyncTask extends AsyncTask<String,Void,String>{
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.i("aaa","请求的数据"+s);
        }

        @Override
        protected String doInBackground(String... strings) {
            String data = HttpUtils.getData(strings[0]);
            return data;
        }
    }
}
