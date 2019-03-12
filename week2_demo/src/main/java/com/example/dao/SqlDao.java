package com.example.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.helper.MyHelper;

public class SqlDao {
    private MyHelper helper;
    private String table="news";
    private String json;

    public SqlDao(Context context){
        helper=new MyHelper(context);
    }

    public void insert(String url,String json){
        SQLiteDatabase database = helper.getWritableDatabase();
        database.delete(table,"url=?",new String[]{url});
        ContentValues values=new ContentValues();
        values.put("url",url);
        values.put("json",json);
        database.insert(table,null,values);
    }
    public String query(String url){
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query(table, null, "url=?", new String[]{url}, null, null, null);
        while (cursor.moveToNext()){
            json = cursor.getString(cursor.getColumnIndex("json"));

        }
        return json;
    }

}
