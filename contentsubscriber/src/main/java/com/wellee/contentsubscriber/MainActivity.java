package com.wellee.contentsubscriber;

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

        Uri userUri = Uri.parse("content://com.wellee.myprovider/user");

        ContentValues values = new ContentValues();

        values.put("_id", 4);
        values.put("name", "LeBronJames");

        ContentResolver resolver = getContentResolver();

        resolver.insert(userUri, values);

        Cursor cursor = resolver.query(userUri, new String[]{"_id", "name"}, null, null, null);
        if (cursor == null) return;
        while (cursor.moveToNext()) {
            Log.d("MainActivity", "query user: " + cursor.getInt(0) + " " + cursor.getString(1));
        }
        cursor.close();

        Uri jobUri = Uri.parse("content://com.wellee.myprovider/job");

        ContentValues values2 = new ContentValues();

        values2.put("_id", 4);
        values2.put("job", "NBA MVP");

        ContentResolver resolver2 = getContentResolver();

        resolver2.insert(jobUri, values2);

        Cursor cursor2 = resolver2.query(jobUri, new String[]{"_id", "job"}, null, null, null);
        if (cursor2 == null) return;
        while (cursor2.moveToNext()) {
            Log.d("MainActivity", "query job: " + cursor2.getInt(0) + " " + cursor2.getString(1));
        }
        cursor2.close();
    }
}
