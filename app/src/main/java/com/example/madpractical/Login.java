package com.example.madpractical;

import static java.security.AccessController.getContext;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class Login extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;


    Context c;
    Button loginBtn;

    String username;
    String password;
    String username_db;
    String password_db;



    public void Login(Context c ){
        this.c = c;
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        firebaseDatabase = FirebaseDatabase.getInstance("https://mad-practical-6-a1d78-default-rtdb.asia-southeast1.firebasedatabase.app");
        databaseReference = firebaseDatabase.getReference().child("Users").child("mad");

        loginBtn = findViewById(R.id.login_btn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_SHORT).show();
                EditText username_input = findViewById(R.id.username_input);
                EditText password_input = findViewById(R.id.password_input);

                username = username_input.getText().toString();
                password = password_input.getText().toString();
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        ArrayList<String> loginUser = new ArrayList<>();
                        for (DataSnapshot dataSnapshot :snapshot.getChildren()){
                            loginUser.add(dataSnapshot.getValue().toString());
                        }
                        if (loginUser.contains(username) && loginUser.contains(password)){
                            Intent ListRV = new Intent(getApplicationContext(), ListActivity.class);
                            startActivity(ListRV);
                            Toast.makeText(Login.this, "", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            username_input.setText("");
                            password_input.setText("");
                            Toast.makeText(Login.this, "Wrong credentials, please try again", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

            }
        });

    }
}
