package com.example.assigment_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class BooksInfo extends AppCompatActivity {

    private int bookID =0;
    App_DB databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_info);


        Intent intent = getIntent();

        databaseHelper = new App_DB(this);

        Button buttonli = findViewById(R.id.btnLibrary);
        EditText BTitle = findViewById(R.id.txtRegBookName);
        EditText BPublisher = findViewById(R.id.txtRegPublisherBook);
        EditText BAuthor = findViewById(R.id.txtRegAuthorBook);
        EditText BPlubYear = findViewById(R.id.txtRegPublishingYear);
        EditText BGenre = findViewById(R.id.txtRegGenre);
        RadioGroup BSelectTransaction = findViewById(R.id.rdbgTransactionGroup);
        RadioGroup BRentVaLUE = findViewById(R.id.rdbgRentValue);

        Button btnAdd = findViewById(R.id.btnRegisterBook);

        try {


            bookID = intent.getIntExtra("id",0);
            BTitle.setText(intent.getStringExtra("Title"));
            BPublisher.setText(intent.getStringExtra("Publisher"));
            BAuthor.setText(intent.getStringExtra("Author"));
            BPlubYear.setText(intent.getStringExtra("Title"));



        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}