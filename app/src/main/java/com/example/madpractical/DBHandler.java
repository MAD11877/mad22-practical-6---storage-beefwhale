package com.example.madpractical;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.service.autofill.UserData;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class DBHandler extends SQLiteOpenHelper {

    public DBHandler(Context c){
        super(c,"MADPractical6.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE User (Username TEXT, Description TEXT, Id INTEGER, Followed INTEGER)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS User");
        onCreate(db);
    }

    public void insertData(User u){
        SQLiteDatabase db = this.getWritableDatabase();
        Integer tempf = 9;
        if (u.followed == true){
            tempf = 1;
        }
        else if(u.followed == false){
            tempf = 0;
        }
        db.execSQL("INSERT INTO User VALUES(\"" + u.name + "\", \"" + u.description + "\", \"" + u.id + "\", \"" + tempf +"\")");
        db.close();
        /*
        *INSERT INTO User VALUES("Username", "Description", "Id", "Followed")
        * */
    }

    public ArrayList<User> getUsers(){
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<User> list = new ArrayList<>();

        Cursor cursor = db.rawQuery("SELECT * FROM User", null);
        while (cursor.moveToNext()) {
            User d = new User();
            Log.d("fllw neither", "test");
            if (cursor.getInt(3) == 1){
                Log.d("fllw true", ""+cursor.getInt(3));
                d.followed = true;

            }
            else if (cursor.getInt(3) == 0){
                Log.d("fllw false", ""+ cursor.getInt(3));
                d.followed = false;
            }
            d.name = cursor.getString(0);
            d.description = cursor.getString(1);
            d.id = cursor.getInt(2);

            list.add(d);
        }
        cursor.close();
        return list;
    }

    public void updateUser(User u){
        SQLiteDatabase db = this.getWritableDatabase();
        //db.execSQL("INSERT INTO User VALUES(\"" + u.name + "\", \"" + u.description + "\", \"" + u.id + "\", \"" + u.followed +"\")");
        //Cursor cursor = db.rawQuery("SELECT * FROM User WHERE Id" + "= \"" + data + "\"", null);

        Integer fstatus;

        if (u.followed == true){
            fstatus = 1;
            //String query = " UPDATE User SET Followed = false WHERE Id = " + u.id;
            db.execSQL("UPDATE User SET Followed" + "= \"" + fstatus + "\"" + "WHERE Id"+ "= \"" + u.id + "\"");
            //db.execSQL(query);

            db.close();
        }
        else{
            fstatus = 0;
            db.execSQL("UPDATE User SET Followed" + "= \"" + fstatus + "\"" + "WHERE Id"+ "= \"" + u.id + "\"");
            db.close();
        }
        /*
        * Update User SET Followed = true Where Id = data;
        * */
    }
    public User updateUserOnClick(Integer id){
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM User WHERE Id" + "= \"" + id + "\"", null);
        cursor.moveToFirst();
        User d = new User();
        if (cursor.getInt(3) == 1){
            d.followed = true;

        }
        else if (cursor.getInt(3) == 0){
            d.followed = false;
        }
        d.name = cursor.getString(0);
        d.description = cursor.getString(1);
        d.id = cursor.getInt(2);
        Log.d("Live update", "Successful");
        return d;
    }
}
