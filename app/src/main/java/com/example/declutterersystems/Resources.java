package com.example.declutterersystems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.declutterersystems.Classes.Resource;
import com.example.declutterersystems.DataBase.AppDatabase;
import com.example.declutterersystems.DataBase.ResourceDAO;

import java.util.ArrayList;
import java.util.List;

public class Resources extends AppCompatActivity {
    //arrays for testing and basic functionality
    String[] nameArray = {"Octopus","Pig","Sheep","Rabbit","Snake","Spider" };

    String[] infoArray = {
        "8 tentacled monster",
        "Delicious in rolls",
        "Great for jumpers",
        "Nice in a stew",
        "Great for shoes",
        "Scary."
    };

    Integer[] imageArray = {R.drawable.ic_confused,
            R.drawable.ic_confused_grey,
            R.drawable.ic_happy,
            R.drawable.ic_sad_1,
            R.drawable.ic_sad_1_grey,
            R.drawable.ic_confused};


    ListView listView;
    //   List<Resource> viewList;
   // ResourceDAO resourceDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        ResourceListAdapter whatever = new ResourceListAdapter(this, nameArray, infoArray, imageArray);
        listView = (ListView) findViewById(R.id.listviewID);
        listView.setAdapter(whatever);

    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_resources);
//
//        getSupportActionBar().setTitle("Resources");
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        resourceDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbNameResource)
//                .allowMainThreadQueries()
//                .fallbackToDestructiveMigration()
//                .build()
//                .getResourceDAO();
//
//
//        resList = resourceDAO.getResources();
//        resList.add(new Resource("The Warming Center Program",
//                "Distributes warm clothing, blankets, and camping materials to the housingless",
//                "Clothing, Shoes, Blankets, Bags",
//                "https://www.warmingcenterprogram.com/"
//                ));
//        resView = findViewById(R.id.listviewID);
//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, resList);
//        resView.setAdapter(arrayAdapter);
//
//        resView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(Resources.this, "Clicked menu item: " + resList.get(position),Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
}
