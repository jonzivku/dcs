package com.example.declutterersystems;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/*
    This class creates tasks and converts between strings to views.
    Each task (which is now aa View) is attached to a Holder.
    The point of using a RecyclerView is to reuse holders that are no longer in use from
    tasks that have been completed.
*/

public class FirebaseRecyclerAdapter extends RecyclerView.Adapter{

    private ArrayList<String> messages;

    public FirebaseRecyclerAdapter(ArrayList<String> messages) {
        //boolean paramter. ask if
        this.messages = messages;
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.i("Tyler","onCreateViewHolder");
        View messageCard = LayoutInflater.from(parent.getContext()).inflate(R.layout.msglist, parent,false);
        return new MessageHolder(messageCard);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Log.i("Tyler","onBindHolder");
        ((MessageHolder)holder).name.setText(messages.get(position));
    }

    @Override
    public int getItemCount() {

        Log.i("Tyler","getItemCount");
        return messages.size();
    }


    class MessageHolder extends RecyclerView.ViewHolder {
        private TextView name;

        private MessageHolder(View layout) {
            super(layout);
            this.name = layout.findViewById(R.id.leftText);
        }
    }
}
