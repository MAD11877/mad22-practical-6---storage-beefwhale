package com.example.madpractical;

import static java.lang.Integer.parseInt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    User user;
    Context c;

    public void MainActivity(Context c){
        this.c = c;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (User) getIntent().getSerializableExtra("User");

        //pull snd set random number for name
        TextView textView2 = (TextView) findViewById(R.id.textView2); // get the textview id
        textView2.setText(user.name);// change textview

        //pull snd set random number for desc
        TextView textView3 = (TextView) findViewById(R.id.textView3); // get the textview id
        textView3.setText(user.description);// change textview

        //pull number for Id

        //pull followed for
        Button btn_flw = findViewById(R.id.followedbutton);

        if (user.followed == true){
            btn_flw.setText("Unfollow");
        }
        else{
            btn_flw.setText("Follow");
        }
    }

    public void onClick(View view) {
        DBHandler db = new DBHandler(this);
        Button btn_flw = findViewById(R.id.followedbutton);
        //if already followed
        if (user.followed == true){
            btn_flw.setText("Follow");
            Toast.makeText(getApplicationContext(), "Unfollowed", Toast.LENGTH_SHORT ).show();
            user.followed = false;
            db.updateUser(user);
        }
        //if NOT already followed
        else{
            btn_flw.setText("Unfollow");
            Toast.makeText(getApplicationContext(), "Followed", Toast.LENGTH_SHORT ).show();
            user.followed = true;
            db.updateUser(user);

        }
    }
    public void msgClick(View view) {
        Button btn_flw = findViewById(R.id.button3);
        if(view.getId() == R.id.button3) {
            Intent newInt = new Intent(MainActivity.this, MessageGroup.class);
            startActivity(newInt);

        }
    }

}

