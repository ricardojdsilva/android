package com.example.assigment_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class LibraryActivity extends AppCompatActivity {
    App_DB databaseBooks ;
    //Intent intent = new Intent(LibraryActivity.this,BooksInfo.class);
    private ArrayList<BooksList> booksModelArrayList;

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set context
        setContentView(R.layout.activity_library);

        //DB conection
        databaseBooks = new App_DB(this);

        listView = findViewById(R.id.listView);

        //Get data from DB
        Cursor c = databaseBooks.viewBookData();

        //put data as array list
        booksModelArrayList = populateList(c);


        // Call adapter
        BookAdapter bookAdapter = new BookAdapter(this,booksModelArrayList);
        listView.setAdapter(bookAdapter);
    }

    private ArrayList<BooksList> populateList(Cursor c){

        ArrayList<BooksList> list = new ArrayList<>();

        for (c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            BooksList bookModel = new BooksList();
            bookModel.setBookID(c.getInt(0));
            bookModel.setBookTitle(c.getString(1));
            bookModel.setBookAuthor(c.getString(2));
            bookModel.setBookPublisher(c.getString(3));
            list.add(bookModel);

        }



        return list;
    }



}