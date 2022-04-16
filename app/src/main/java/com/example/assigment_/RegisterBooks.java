package com.example.assigment_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterBooks extends AppCompatActivity {
    App_DB databaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_books);
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


        btnAdd.setOnClickListener(new View.OnClickListener() {
            String bT,bA,bP,bPY,bG,transaction;
            Float rentValue;
            RadioButton transactionB,rentB;
          //  Cursor c = new
            boolean isInsertedBook,isInsertedTransaction;
            @Override
            public void onClick(View view) {

                bT = BTitle.getText().toString();
                bA = BAuthor.getText().toString();
                bP = BPublisher.getText().toString();
                bPY= BPlubYear.getText().toString();
                bG = BGenre.getText().toString();
                isInsertedBook = databaseHelper.AddBookRecord(bT,bP,bA,bPY,bG);
              //  int selectedButtonTransaction  = BSelectTransaction.getCheckedRadioButtonId();
              //  transactionB = (RadioButton) findViewById(selectedButtonTransaction);
              //  transaction = transactionB.getText().toString();
              //   int selectedButtonRentValue  = BRentVaLUE.getCheckedRadioButtonId();
              //  rentB = (RadioButton) findViewById(selectedButtonRentValue);
              //  rentValue = Float.parseFloat((String) rentB.getText());
              //  isInsertedTransaction = databaseHelper.Add_book_transaction(transaction,rentValue);
                if(isInsertedBook){
                    Toast.makeText(RegisterBooks.this,
                            Html.fromHtml("Book added"),
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(RegisterBooks.this,
                            "Missing fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
        buttonli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            startActivity(new Intent(RegisterBooks.this,LibraryActivity.class));
            }
        });
    }
}