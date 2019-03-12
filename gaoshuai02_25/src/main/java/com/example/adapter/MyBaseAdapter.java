package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.gaoshuai02_25.R;

import java.util.List;

public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private List<String> list;

    public MyBaseAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            convertView=View.inflate(context,R.layout.list_item,null);
            holder=new ViewHolder();
            holder.text=convertView.findViewById(R.id.text);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.text.setText(list.get(position));
        return convertView;
    }
    class ViewHolder{
        TextView text;
    }
}
