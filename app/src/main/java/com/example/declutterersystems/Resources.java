package com.example.declutterersystems;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
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
    String[] nameArray = {
            "The Warming Center Program",
            "Grey Bears",
            "Resource Recovery Facility",
            "Walnut Avenue Family & Women's Center",
            "Habitat for Humanity ReStore",
            "Junk King"};
    String[] infoArray = {
            "Clothing, Shoes, Blankets, Bags",
            "E-waste and Household Goods",
            "E-waste and hazardous items",
            "Women and Childrens Clothing, Toiletries",
            "Building Supplies, Furniture, Appliances",
            "Residential Removal Service"};

    Integer[] imageArray = {R.drawable.ic_confused,
            R.drawable.ic_confused_grey,
            R.drawable.ic_happy,
            R.drawable.ic_sad_1,
            R.drawable.ic_sad_1_grey,
            R.drawable.ic_confused};

    String[] urlArray = {
            "https://www.warmingcenterprogram.com/",
            "https://www.greybears.org/about/contact-us/",
            "http://www.cityofsantacruz.com/government/city-departments/public-works/resource-recovery-garbage-recycling-sweeping/recycling-and-waste-reduction/electronic-waste-e-waste",
            "http://www.wafwc.org/wish-lists",
            "https://www.habitatmontereybay.com/donationcriteria",
            "https://www.junk-king.com/locations/santacruz/"};

    // unused description array
    String[] descArray = {
            "Distributes warm clothing, blankets, and camping materials to the housingless",
            "Community program dedicated to helping seniors, recycling E-waste. and also reusing and resaling goods",
            "Municipal hazardous waste disposal",
            "Walnut Avenue Family & Women’s Center provides support and services so that women, children, and families have the opportunities and skills to thrive",
            "Resales building materials, furniture, and appliances",
            "Service offering removal of general waste"};

    ListView listView;
    //   List<Resource> viewList;
   // ResourceDAO resourceDAO;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources);

        ResourceListAdapter arrayAdapter = new ResourceListAdapter(this, nameArray, infoArray, imageArray, urlArray);
        listView = findViewById(R.id.listviewID);
        listView.setAdapter(arrayAdapter);

        getSupportActionBar().setTitle("Resources");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(Resources.this, WebDisplay.class);

                intent.putExtra("NAME", nameArray[position] );
                intent.putExtra("URL", urlArray[position] );
                startActivity(intent);
            }
        });
    }


//    @Override
//    protected void onCreate(Bundle savedInstanceState) {

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
