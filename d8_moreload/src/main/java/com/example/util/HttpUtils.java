package com.example.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpUtils {
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
