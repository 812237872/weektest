package com.example.a81223.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.a81223.bean.New;
import com.example.a81223.weektest.R;

import java.util.List;

public class MyBaseAdapter extends BaseAdapter {
    private List<New> list;
    private Context context;

    public MyBaseAdapter(List<New> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        return position%2;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
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
        switch(getItemViewType(position)){
           case 0:
               ViewHolder1 holder1;
               if(convertView==null){
                   convertView=View.inflate(context,R.layout.layout_item1,null);
                   holder1=new ViewHolder1();
                   holder1.text1=convertView.findViewById(R.id.text1);
                   holder1.text2=convertView.findViewById(R.id.text2);
                   holder1.img=convertView.findViewById(R.id.image);
                   convertView.setTag(holder1);
               }else{
                   holder1= (ViewHolder1) convertView.getTag();
               }
               holder1.text1.setText(list.get(position).getSUBTITLE());
               holder1.text2.setText(list.get(position).getSHOWTIME());
               Glide.with(context).load(list.get(position).getIMAGEURL()).into(holder1.img);
                break;
           case 1:
               ViewHolder2 holder2;
               if(convertView==null){
                   convertView=View.inflate(context,R.layout.layout_item2,null);
                   holder2=new ViewHolder2();
                   holder2.text3=convertView.findViewById(R.id.text3);
                   holder2.text4=convertView.findViewById(R.id.text4);
                   convertView.setTag(holder2);
               }else{
                   holder2= (ViewHolder2) convertView.getTag();
               }
               holder2.text3.setText(list.get(position).getFROMNAME());
               holder2.text4.setText(list.get(position).getSUBTITLE());

                break;
           default : break;
        }

        return convertView;
    }
    class ViewHolder1{
        TextView text1,text2;
        ImageView img;
    }
    class ViewHolder2{
        TextView text3,text4;
    }
}
