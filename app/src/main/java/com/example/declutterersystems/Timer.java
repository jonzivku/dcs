package com.example.declutterersystems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Timer extends AppCompatActivity {
    public int counter;
    public Boolean clicked = false;
    EditText inputMin;
    EditText inputSec;
    Button button;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        getSupportActionBar().setTitle("Cleaning Clock");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button = (Button) findViewById(R.id.button);

        inputMin = (EditText) findViewById(R.id.minInput);
        inputSec = (EditText) findViewById(R.id.secInput);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                if (!clicked) {
                    String min = inputMin.getText().toString();
                    String sec = inputSec.getText().toString();
                    if(min.matches("") || Integer.parseInt(min) < 0){
                        min = "0";
                    }

                    if(sec.matches("") || Integer.parseInt(sec) < 0){
                        sec = "0";
                    }

                    int minutes = Integer.parseInt(min) * 60000;
                    minutes += Integer.parseInt(sec) * 1000;
                    button.setText("Cancel Timer");
                    timer = new CountDownTimer(minutes, 1000){
                        public void onTick(long millisUntilFinished){
                            String seconds = "" + (millisUntilFinished / 1000) % 60;
                            String minute = (millisUntilFinished / 1000) / 60 + "";
                            if (Integer.parseInt(seconds) < 10){
                                seconds = "0" + seconds;
                            }
                            if( Integer.parseInt(minute) < 10) {
                                minute = "0" + minute;
                            }
                            inputMin.setText(minute);
                            inputSec.setText(seconds);
                            counter++;
                        }
                        public void onFinish(){
                            inputMin.setText("");
                            inputSec.setText("");
                            button.setText("Start Timer");
                        }
                    };
                    timer.start();
                    clicked = !clicked;
                } else {
                    timer.cancel();
                    clicked = !clicked;
                    inputMin.setText("");
                    inputSec.setText("");

                    button.setText("Start Timer");
                }
            }
        });
    }
}
