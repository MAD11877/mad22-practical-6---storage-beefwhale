package com.example.madpractical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MessageGroup extends AppCompatActivity{
    private FrameLayout fragmentContainer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_group);
    }

    FragmentManager fragmentManager = getSupportFragmentManager();
    public void grp1Click(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MessageFragment messageFragment = new MessageFragment();
        fragmentTransaction.replace(R.id.fragment_container, messageFragment);
        fragmentTransaction.commit();
    }
    public void grp2Click(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        MessageFragment2 messageFragment2 = new MessageFragment2();
        fragmentTransaction.replace(R.id.fragment_container, messageFragment2);
        fragmentTransaction.commit();
    }
}