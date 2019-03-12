package com.example.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.bean.New;
import com.example.gaoshuai218.R;
import com.example.util.HttpUtils;

/**
* listview 适配器
* @auther  ln
* created at 2019/2/18 10:30
*/



import java.util.List;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private List<New> list;

    public ListAdapter(Context context, List<New> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView = View.inflate(context, R.layout.list_item, null);
            holder=new ViewHolder();
            holder.text1=convertView.findViewById(R.id.text1);
            holder.text2=convertView.findViewById(R.id.text2);
            holder.image=convertView.findViewById(R.id.image_view);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.text1.setText(list.get(position).getPublishedAt()+list.get(position).getType());
        holder.text2.setText(list.get(position).getDesc());
        new MysAsyncTask(holder.image).execute(list.get(position).getUrl());
        return convertView;
    }
    class ViewHolder{
        ImageView image;
        TextView text1,text2;
    }

    class MysAsyncTask extends AsyncTask<String,Void,Bitmap>{
        private ImageView iv;

        public MysAsyncTask(ImageView iv) {
            this.iv = iv;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            iv.setImageBitmap(bitmap);
        }

        @Override
        protected Bitmap doInBackground(String... strings) {
            Bitmap bitmap = HttpUtils.getNewPic(strings[0]);
            return bitmap;
        }
    }
}
