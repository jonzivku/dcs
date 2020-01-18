package com.example.declutterersystems;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button timerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

    timerBtn = findViewById(R.id.timerBtn);

    timerBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            launchTimer();
        }
    });

    }

    public void launchTimer(){
        Intent intentTimer = new Intent(this, Timer.class);
        startActivity(intentTimer);
    }

}
