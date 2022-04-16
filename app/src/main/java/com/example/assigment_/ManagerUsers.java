package com.example.assigment_;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


public class ManagerUsers extends AppCompatActivity {

    App_DB databaseHelper;

    private ArrayList<Users> usersModelArrayList;

    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_users);
        //db connect
        databaseHelper = new App_DB(this);


        listView = findViewById(R.id.listView);

       /* databaseHelper.add(new Users("RICARDO", "SILVA", null, null, null, null, null, null, null,null, null, null));
        databaseHelper.add(new Users("GABRIEL", "BASTO", null, null, null, null, null, null, null,null, null, null));
        databaseHelper.add(new Users("DAVID", "JONES",null, null, null, null, null, null, null,null, null, null));
        databaseHelper.add(new Users("MILAD", "MOHAMED", null, null, null, null, null, null, null,null, null, null));
        */

        //Get users from DB
        Cursor c = databaseHelper.viewRecord();

        //put data as array list
        usersModelArrayList = populateList(c);

        // Call adapter
        UserAdapter userAdapter = new UserAdapter(this,usersModelArrayList);

        listView.setAdapter(userAdapter);

        //Test Update list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                userAdapter.notifyDataSetChanged();
            }
        });


    }

    private ArrayList<Users> populateList(Cursor c){

        ArrayList<Users> list = new ArrayList<>();


        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            Users userModel = new Users();
            userModel.setId(c.getInt(0));
            userModel.setFName(c.getString(1));
            userModel.setLName(c.getString(2));
            userModel.setEmail(c.getString(3));
            userModel.setLogin(c.getString(4));
            userModel.setPassword(c.getString(5));
            userModel.setBithdate(c.getString(6));
            userModel.setProvince(c.getString(7));
            userModel.setAddress(c.getString(8));
            userModel.setZipcode(c.getString(9));
            userModel.setPhonenumber(c.getString(10));
            userModel.setTxInterest(c.getString(11));
            userModel.setShareLocation(c.getString(12));

            list.add(userModel);

        }



        return list;
    }




}