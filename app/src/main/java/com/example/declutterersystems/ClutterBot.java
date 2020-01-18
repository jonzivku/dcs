package com.example.declutterersystems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import io.kommunicate.KmConversationBuilder;
import io.kommunicate.Kommunicate;
import io.kommunicate.callbacks.KmCallback;

public class ClutterBot extends AppCompatActivity {
          KmConversationBuilder BotConvo = new KmConversationBuilder(ClutterBot.this)
                   .launchConversation(new KmCallback() {
        @Override
        public void onSuccess(Object message) {
            Log.d("Conversation", "Success : " + message);
        }

        @Override
        public void onFailure(Object error) {
            Log.d("Conversation", "Failure : " + error);
        }
    });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Kommunicate.init(getApplicationContext(), "33b7e2d4f7cadc4cbd0ee6e36a094cb73");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clutter_bot);
    }
}
