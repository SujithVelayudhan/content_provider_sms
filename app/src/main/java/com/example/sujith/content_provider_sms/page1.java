package com.example.sujith.content_provider_sms;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class page1 extends AppCompatActivity {

    ListView list_view_p;
    ArrayList<String> arr;
    ArrayAdapter<String> adapt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        list_view_p=findViewById(R.id.list_view);

        arr=new ArrayList<>();

        Uri u=Uri.parse("content://sms/inbox");
        Cursor c=getContentResolver().query(u,new String[]{"_id","address","body"},
                null,null,null);
        c.moveToFirst();

        do {

            String id=c.getString(0);
            String addr=c.getString(1);
            String bo=c.getString(2);

            arr.add("ID :"+id+"  ADD :"+addr+" Body :"+bo);
        }
        while (c.moveToNext());

        adapt=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,arr);

        list_view_p.setAdapter(adapt);



    }
}
