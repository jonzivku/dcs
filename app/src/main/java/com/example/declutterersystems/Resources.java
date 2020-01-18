package com.example.declutterersystems;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.applozic.mobicommons.json.ArrayAdapter;
import com.example.declutterersystems.Classes.Config;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;

import java.util.ArrayList;
import java.util.List;

public class Resources extends AppCompatActivity {
    // configure HTTP communication
    HttpTransport transport = AndroidHttp.newCompatibleTransport();
    JsonFactory factory = JacksonFactory.getDefaultInstance();
    final Sheets sheetsService = new Sheets.Builder(transport, factory, null)
            .setApplicationName("My Awesome App")
            .build();
    final String spreadsheetId = Config.spreadsheet_id;

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
