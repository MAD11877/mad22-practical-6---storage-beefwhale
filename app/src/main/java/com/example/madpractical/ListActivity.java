package com.example.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;


public class ListActivity extends AppCompatActivity {

    Integer randname;
    Integer randdesc;
    Context c;

    public void ListActivity(Context c){
        this.c = c;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Random rand = new Random(); //instance of random class

        DBHandler db = new DBHandler(this);
        /*SharedPreferences pref = getSharedPreferences("MADPractical6", MODE_PRIVATE);
        String name = pref.getString("Name","Not Found:(");
        String desc = pref.getString("Desc","Not Found:(");
        Integer id = pref.getInt("Id",0);
        Boolean followed = pref.getBoolean("Followed", false);*/

        ArrayList<User> list = db.getUsers();
        //ArrayList<User> data= new ArrayList<>();
        for (int i=0; i<20; i++){
            randname = rand.nextInt();// random number for name
            randdesc = rand.nextInt(); // random number for desc*/

            /*User d = new User();
            d.name = "Name" + randname;
            d.description = "Description" + randdesc;
            d.id = i+1;
            d.followed = rand.nextBoolean();*/

            /*SharedPreferences.Editor editor = pref.edit();
            editor.putString("Name", d.name);
            editor.putString("Desc", d.description);
            editor.putInt("Id", d.id);
            editor.putBoolean("Followed", d.followed);*/

            //passing into database as object
            //db.insertData(d);
            //data.add(d);
        }
        RecyclerView rv  = findViewById(R.id.recyclerView);
        ListAdapter adapter = new ListAdapter(ListActivity.this, list, db);
        LinearLayoutManager layout = new LinearLayoutManager(this); //placing things horizontally

        //Toast.makeText(getApplicationContext(), "" + (list.get(2)).followed + (list.get(2)).id, Toast.LENGTH_SHORT ).show();
        // Giving RV adapter and layout finally
        rv.setAdapter(adapter);
        rv.setLayoutManager(layout);
    }

}