package com.example.declutterersystems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.declutterersystems.Classes.User;
import com.example.declutterersystems.DataBase.AppDatabase;
import com.example.declutterersystems.DataBase.UserDAO;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText userInput;
    UserDAO userDAO;
    List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Login");

        userInput = findViewById(R.id.nameInput);

        userDAO = Room.databaseBuilder(this, AppDatabase.class, AppDatabase.dbName)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build()
                .getUserDAO();

        users = userDAO.getUsers();
        for(User user: users){
            if(user.getLoggedIn()) {
                launchActivity();
            }
        }

    }


    public void login(View v){
        String userName = userInput.getText().toString();
        if (userName.matches("")){
            Toast.makeText(this,"Please input a valid user name.",Toast.LENGTH_SHORT).show();
            return;
        }
        users = userDAO.getUsers();
        for(User user:users){
            if(user.getName().matches(userName)){
                Toast.makeText(this, user.getName() + " is logged in", Toast.LENGTH_SHORT).show();
                user.setLoggedIn(true);
                userDAO.update(user);
                launchActivity();
                return;
            }
        }
        userDAO.insert(new User(userName, true));
        Toast.makeText(this, userName + " got registered and is now logged in", Toast.LENGTH_SHORT).show();
        launchActivity();
    }

    private void launchActivity(){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);

    }

}
