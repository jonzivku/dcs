package com.example.declutterersystems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.declutterersystems.Classes.User;
import com.example.declutterersystems.DataBase.AppDatabase;
import com.example.declutterersystems.DataBase.UserDAO;

import java.util.ArrayList;
import java.util.List;

public class Menu extends AppCompatActivity {

    ListView menuView;
    List<String> menuItems;
    UserDAO userDAO;
    List<User> users;
    public User loggedInUser;
    TextView userLoggedInText;

    protected void onResume(){
        super.onResume();
        refreshDisplay();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        getSupportActionBar().setTitle("Menu");

        userLoggedInText = findViewById(R.id.userLoggedInId);

        userDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbName)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .getUserDAO();


        menuView = findViewById(R.id.menuId);
        menuItems = new ArrayList<>();
        menuItems.add("ChatBot");
        menuItems.add("Timer");
        menuItems.add("Resources");
        menuItems.add("");
        menuItems.add("Log out");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, R.layout.listview_item,menuItems);
        menuView.setAdapter(arrayAdapter);

        menuView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Toast.makeText(Menu.this, "Clicked menu item: " + menuItems.get(i),Toast.LENGTH_SHORT).show();

                if(menuItems.get(i).matches("Timer")){
                    launchTimer();
                } else if(menuItems.get(i).matches("ChatBot")){
                    launchChatBot();
                } else if(menuItems.get(i).matches("Resources")) {
                    launchResources();
                } else if(menuItems.get(i).matches("Log out")){
                    logOutUser();
                }

            }
        });

        refreshDisplay();

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

    private void logOutUser(){
        for(User user:users){
            user.setLoggedIn(false);
            userDAO.update(user);
        }
        finish();
        return;
    }

    private void refreshDisplay(){
        users = userDAO.getUsers();
        for(User user: users){
            if(user.getLoggedIn()) {
                loggedInUser = user;
            }
        }
        if(loggedInUser != null) {
            userLoggedInText.setText("Hello " + loggedInUser.getName());
        }
    }

}
