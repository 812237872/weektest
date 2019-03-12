package com.example.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bean.New;
import com.example.d8_moreload.R;

import org.w3c.dom.Text;

import java.util.List;

public class MyBaseAdapter extends BaseAdapter {
    private Context context;
    private List<New> list;

    public MyBaseAdapter(Context context, List<New> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getItemViewType(int position) {
        return position%3;
    }

    @Override
    public int getViewTypeCount() {
        return 3;
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
        switch (getItemViewType(position)) {
           case 0 :
               ViewHolder1 holder1;
               if(convertView==null){
                   convertView=View.inflate(context,R.layout.list_item1,null);
                   holder1=new ViewHolder1();
                   holder1.image1=convertView.findViewById(R.id.item_image1);
                   convertView.setTag(holder1);
               }else{
                   holder1= (ViewHolder1) convertView.getTag();
               }
               Glide.with(context).load(list.get(position).getThumbnail_pic_s()).into(holder1.image1);
            break;
           case 1:
               ViewHolder2 holder2;
            if(convertView==null){
                convertView=View.inflate(context,R.layout.list_item2,null);
                holder2=new ViewHolder2();
                holder2.title2=convertView.findViewById(R.id.item_title2);
                holder2.date2=convertView.findViewById(R.id.item_data2);
                convertView.setTag(holder2);
            }else{
                holder2= (ViewHolder2) convertView.getTag();
            }
            holder2.title2.setText(list.get(position).getTitle());
            holder2.date2.setText(list.get(position).getDate());
            break;
           case 2:
           ViewHolder3 holder3;
           if(convertView==null){
                convertView=View.inflate(context,R.layout.list_item3,null);
               holder3=new ViewHolder3();
               holder3.title3=convertView.findViewById(R.id.item_title3);
               holder3.date3=convertView.findViewById(R.id.item_data3);
               holder3.image3_01=convertView.findViewById(R.id.image3_01);
               holder3.image3_02=convertView.findViewById(R.id.image3_02);
               convertView.setTag(holder3);
           }else{
               holder3= (ViewHolder3) convertView.getTag();
           }
           holder3.title3.setText(list.get(position).getTitle());
           holder3.date3.setText(list.get(position).getDate());
           Glide.with(context).load(list.get(position).getThumbnail_pic_s()).into(holder3.image3_01);
           Glide.with(context).load(list.get(position).getThumbnail_pic_s02()).into(holder3.image3_02);
           break;
            default:
                break;
        }
        return convertView;
    }
    class ViewHolder1{
        ImageView image1;
    }
    class ViewHolder2{
        TextView title2,date2;
    }
    class ViewHolder3{
        TextView title3,date3;
        ImageView image3_01,image3_02;
    }
}
