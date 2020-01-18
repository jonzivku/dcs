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
    EditText inputTime;
    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        getSupportActionBar().setTitle("Cleaning Clock");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        button = (Button) findViewById(R.id.button);
        textView = (TextView) findViewById(R.id.textView);

        inputTime = (EditText) findViewById(R.id.timerInput);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                int minutes = Integer.parseInt(inputTime.getText().toString()) * 60000;
                button.setText("Pause Timer");
                new CountDownTimer(minutes, 1000){
                    public void onTick(long millisUntilFinished){
                        textView.setText("" + millisUntilFinished / 1000);
                        counter++;
                    }
                    public  void onFinish(){
                        textView.setText("You made it!!");
                        button.setText("Start Timer");
                    }
                }.start();
            }
        });
    }
}
