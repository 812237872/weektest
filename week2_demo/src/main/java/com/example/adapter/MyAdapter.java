package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.Bean.New;
import com.example.week2_demo.R;

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
    public int getItemViewType(int position) {
        return position % 3;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        switch(getItemViewType(position)){
           case 0:
               ViewHolder1 holder1;
               if(convertView==null){
                   convertView=View.inflate(context,R.layout.layout_item1,null);
                   holder1=new ViewHolder1();
                   holder1.text1_1=convertView.findViewById(R.id.text1);
                   holder1.text1_2=convertView.findViewById(R.id.text2);
                   holder1.img1=convertView.findViewById(R.id.image1);
                   convertView.setTag(holder1);
               }else{
                   holder1= (ViewHolder1) convertView.getTag();
               }
               holder1.text1_1.setText(list.get(position).getNews_title());
               holder1.text1_2.setText(list.get(position).getNews_summary());
               Glide.with(context).load(list.get(position).getPic_url()).into(holder1.img1);
                break;
           case 1:
               ViewHolder2 holder2;
               if(convertView==null){
                   convertView=View.inflate(context,R.layout.layout_item2,null);
                   holder2=new ViewHolder2();
                   holder2.text2_1=convertView.findViewById(R.id.text2_1);
                   holder2.text2_2=convertView.findViewById(R.id.text2_2);
                   holder2.img2=convertView.findViewById(R.id.image2);
                   convertView.setTag(holder2);
               }else{
                   holder2= (ViewHolder2) convertView.getTag();
               }
               holder2.text2_1.setText(list.get(position).getNews_title());
               holder2.text2_2.setText(list.get(position).getNews_summary());
               Glide.with(context).load(list.get(position).getPic_url()).into(holder2.img2);
                break;
           case 2:
               ViewHolder3 holder3;
               if(convertView==null){
                   convertView=View.inflate(context,R.layout.layout_item3,null);
                   holder3=new ViewHolder3();
                   holder3.img3=convertView.findViewById(R.id.image3);
                   convertView.setTag(holder3);
               }else{
                   holder3= (ViewHolder3) convertView.getTag();
               }
               Glide.with(context).load(list.get(position).getPic_url()).into(holder3.img3);
                break;
           default : break;
        }
        return convertView;
    }
    class ViewHolder1{
        TextView text1_1,text1_2;
        ImageView img1;
    }
    class ViewHolder2{
        TextView text2_1,text2_2;
        ImageView img2;
    }
    class ViewHolder3{
        ImageView img3;
    }
}
