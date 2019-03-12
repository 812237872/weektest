package com.example.util;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
* 工具类  请求数据 ，请求图片
* @auther  ln
* created at 2019/2/18 10:26
*/



public class HttpUtils {
    //网络请求数据
    public static String getData(String dataUrl){
        try{
            URL url=new URL(dataUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int code = connection.getResponseCode();
            if(code==200){
                InputStream inputStream = connection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder builder = new StringBuilder();
                String str="";
                while((str=reader.readLine())!=null){
                    builder.append(str);
                }
                return builder.toString();
            }
        }catch(Exception e){
          e.printStackTrace();
        }
        return "";
    }
    //网络请求图片
    public static Bitmap getNewPic(String picUrl){
        try{
            URL url=new URL(picUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            int code = connection.getResponseCode();
            if(code==200){
                InputStream inputStream = connection.getInputStream();
                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
                return bitmap;
            }
        }catch(Exception e){
          e.printStackTrace();
        }

        return null;
    }
}
