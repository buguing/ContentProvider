package com.wellee.contentprovider;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 设置URI
        Uri userUri = Uri.parse("content://com.wellee.myprovider/user");
        // 插入表中数据
        ContentValues values = new ContentValues();
        values.put("_id", 3);
        values.put("name", "Wade");
        // 获取ContentResolver
        ContentResolver resolver = getContentResolver();
        // 通过ContentResolver 根据URI 向ContentProvider中插入数据
        resolver.insert(userUri, values);
        // 通过ContentResolver 向ContentProvider中查询数据
        Cursor cursor = resolver.query(userUri, new String[]{"_id", "name"}, null, null, null);
        if (cursor == null) return;
        while (cursor.moveToNext()) {
            Log.d("MainActivity", "query user:" + cursor.getInt(0) + " " + cursor.getString(1));
        }
        cursor.close();

        // 和上述类似,只是URI需要更改,从而匹配不同的URI CODE,从而找到不同的数据资源
        Uri jobUri = Uri.parse("content://com.wellee.myprovider/job");
        // 插入表中数据
        ContentValues values2 = new ContentValues();
        values2.put("_id", 3);
        values2.put("job", "NBA Player");
        // 获取ContentResolver
        ContentResolver resolver2 = getContentResolver();
        resolver2.insert(jobUri, values2);
        Cursor cursor2 = resolver2.query(jobUri, new String[]{"_id", "job"}, null, null, null);
        if (cursor2 == null) return;
        while (cursor2.moveToNext()) {
            Log.d("MainActivity", "query job:" + cursor2.getInt(0) + " " + cursor2.getString(1));
        }
        cursor2.close();
    }
}
