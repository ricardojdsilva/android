package com.example.assigment_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    App_DB databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Intent when came back after include a new user
        Intent intent = getIntent();

        Button btnTest = findViewById(R.id.btnLogIn);

        //button to Sign new users
        Button btnNewUser = findViewById(R.id.btnSignIn);

        //user
        EditText txUse = findViewById(R.id.txtUserName);

        //password
        TextView txPW = findViewById(R.id.txtPassword);

        //get database
        databaseHelper = new App_DB(this);

        //IF JUST LOGIN
        if (intent.getExtras() == null) {
            txUse.getText().clear();
            txPW.setText("");
        } else { // IF NEW LOGIN
           // txPW.setText(intent.getStringExtra("password"));
            txUse.setText(intent.getStringExtra("login"));
            txPW.setText(intent.getStringExtra("password"));
        }


        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Get user
                String user = txUse.getText().toString();
                // Get PW
                //String sPW = txPW.getText().toString();

                // if admin
                if (user.equals("admin") ) {
                    startActivity(new Intent(MainActivity.this, ManagerUsers.class));
                //Check login
                } else {
                    String lUser = txUse.getText().toString();
                    String lPw = txPW.getText().toString();
                      if (databaseHelper.checkUser(lUser, lPw)) {
                          Toast.makeText(MainActivity.this,
                                  "User granted", Toast.LENGTH_SHORT).show();
                          startActivity(new Intent(MainActivity.this, ActivityTransaction.class));
                      }

                    }
                }


        });

        btnNewUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //New User
                startActivity(new Intent(MainActivity.this, EditUser.class));

            }
        });
    }
}