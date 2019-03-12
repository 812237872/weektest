package com.example.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

public class HttpUtil {
    public static boolean isNetConnected(Context context){
        if(context!=null){
            ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manager.getActiveNetworkInfo();
            if(info!=null){
                return info.isConnected();
            }
        }
        return false;
    }

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
}
