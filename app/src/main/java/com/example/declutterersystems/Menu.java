package com.example.declutterersystems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    ListView menuView;
    List<String> menuItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menuView = findViewById(R.id.menuId);
        menuItems = new ArrayList<>();
        menuItems.add("ChatBot");
        menuItems.add("Timer");
        menuItems.add("Resources");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,menuItems);
        menuView.setAdapter(arrayAdapter);

        menuView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(Menu.this, "Clicked menu item: " + menuItems.get(i),Toast.LENGTH_SHORT).show();

                if(menuItems.get(i).matches("Timer")){
                    launchTimer();
                } else if(menuItems.get(i).matches("ChatBot")){
                    launchChatBot();
                } else {
                    launchResources();
                }

            }
        });
    }

    public void launchTimer(){
        Intent intentTimer = new Intent(this, Timer.class);
        startActivity(intentTimer);
    }

    public void launchChatBot(){
        Intent intentBot = new Intent(this, ClutterBot.class);
        startActivity(intentBot);
    }

    public void launchResources(){
        Intent intentResources = new Intent(this, Resources.class);
        startActivity(intentResources);
    }



}
