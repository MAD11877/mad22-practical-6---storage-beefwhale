package com.example.madpractical;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter
        extends RecyclerView.Adapter<ListViewHolder>
{
    //Constructor or get set is okay
    ArrayList<User> data; // declaring here so tha the whole class can access
    Context c;
    DBHandler db ;

    public ListAdapter(Context c, ArrayList<User> data, DBHandler db){
        this.c = c;
        //taking parameter input and putting into arraylist
        this.data = data; //"this" refers to this class
        this.db = db;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //creating the layout here
        //parent is the parameter, provided. It is where we nest recycler view.
        View item = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listdata_layout, null, false);
        return new ListViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        //onBindViewHolder populates viewholder with data
        //position is which index in arraylist is coming up now and has to be populated
        User user = data.get(position);

        //Setting text for our name
        holder.name.setText(user.name);
        holder.desc.setText(user.description);

        String temp = (user.name).substring((user.name).length() - 1);
        if (Integer.valueOf(temp) == 7) {
            holder.bigimg.setImageResource(android.R.drawable.sym_def_app_icon);
            holder.bigimg.setVisibility(View.VISIBLE);
        }
        else{
            holder.bigimg.setVisibility(View.GONE);

        }



        holder.img.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                User userLive = db.updateUserOnClick(user.id);
                AlertDialog.Builder builder = new AlertDialog.Builder(c);
                builder.setTitle("" + userLive.followed + userLive.id)
                        .setMessage((userLive.name));
                builder.setCancelable(false);
                builder.setNegativeButton("Close", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("View", new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int id){
                        Intent randAct = new Intent(ListAdapter.this.c, MainActivity.class);
                        randAct.putExtra("User", userLive);
                        c.startActivity(randAct);
                    }
                }).show();
                AlertDialog alert = builder.create();
            }
        });
    }



    @Override
    public int getItemCount() {
        return data.size(); //array list size ;
    }
}
