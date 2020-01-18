package com.example.declutterersystems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.applozic.mobicommons.json.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class Resources extends AppCompatActivity {
    ListView resView;
    List<String> resList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);
        resList = new ArrayList<>();
        resList.add("foo");
        resList.add("goo");
        resList.add("hoo");
        resList.add("joo");
        resView = findViewById(R.id.resources_id);
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, resList);
    }
}
