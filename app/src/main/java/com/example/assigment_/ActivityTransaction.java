package com.example.assigment_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityTransaction extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction);

        Button regBook = findViewById(R.id.btnRegBooksAct);
        Button library = findViewById(R.id.btnLibraryAct);
        Button usersInfo = findViewById(R.id.btnEditUserAct);

        regBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityTransaction.this,RegisterBooks.class));
            }
        });
        library.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityTransaction.this,LibraryActivity.class));
            }
        });
        usersInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ActivityTransaction.this,ManagerUsers.class));
            }
        });
        }
    }
