package com.example.declutterersystems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, resList);
        resView.setAdapter(arrayAdapter);

        resView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Resources.this, "Clicked menu item: " + resList.get(position),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
