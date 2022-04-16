package com.example.assigment_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MenssageToUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menssage_to_user);

        Button btnSms = findViewById(R.id.btnSendMessage);

        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MenssageToUser.this,
                        "Message sent", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MenssageToUser.this, ManagerUsers.class));
            }
        });


    }
}