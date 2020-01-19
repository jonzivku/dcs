package com.example.declutterersystems;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ResourceListAdapter extends ArrayAdapter {
    //to reference the Activity
    private final Activity context;

    //to store the animal images
    private final Integer[] imageIDarray;

    //to store the list of countries
    private final String[] nameArray;

    //to store the list of countries
    private final String[] takesArray;

    public ResourceListAdapter(Activity context,
                               String[] nameArrayParam,
                               String[] takesArrayParam,
                               Integer[] imageIDArrayParam){
        super(context, R.layout.listview_resource, nameArrayParam);
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_resource, null,true);

        //this code gets references to objects in the listview_row.xml file

        TextView nameTextField = (TextView) rowView.findViewById(R.id.nameTextViewID);
        TextView takesTextField = (TextView) rowView.findViewById(R.id.takesTextViewID);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView1ID);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(nameArray[position]);
        takesTextField.setText(takesArray[position]);
        imageView.setImageResource(imageIDarray[position]);

        return rowView;
    }
}
