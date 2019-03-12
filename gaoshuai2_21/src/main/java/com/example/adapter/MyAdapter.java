package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bean.New;
import com.example.gaoshuai2_21.R;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<New> list;
    private Context context;

    public MyAdapter(List<New> list, Context context) {
        this.list = list;
        this.context = context;
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
            holder.img=convertView.findViewById(R.id.image);
            holder.title=convertView.findViewById(R.id.title);
            holder.sour=convertView.findViewById(R.id.sour);
            convertView.setTag(holder);
        }else{
            holder= (ViewHolder) convertView.getTag();
        }
        holder.sour.setText(list.get(position).getSource());
        holder.title.setText(list.get(position).getTitle());
        Glide.with(context).load(list.get(position).getSource_url()).into(holder.img);
        return convertView;
    }
    class ViewHolder{
        ImageView img;
        TextView title,sour;
    }
}
