    package com.example.assigment_;

    import androidx.appcompat.app.AppCompatActivity;

    import android.content.Context;
    import android.content.Intent;
    import android.icu.text.RelativeDateTimeFormatter;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.EditText;
    import android.widget.Spinner;
    import android.widget.Toast;

    public class EditUser extends AppCompatActivity {

        private String[] province = new String[] {"NL", "PE", "NS", "NB", "QC",  "ON",  "MB",  "SK", "AB", "BC", "YT", "NT", "NU"};
        private ArrayAdapter<String> provinceAdapter = null; //province
        private int userID =0;
        App_DB databaseHelper;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_edit_user);

            Intent intent = getIntent();

            databaseHelper = new App_DB(this);

            EditText txFname = findViewById(R.id.txtFName);
            EditText txLname = findViewById(R.id.txLastName);
            EditText txEmail = findViewById(R.id.txEmail);
            EditText txlogin = findViewById(R.id.txLogin);
            EditText txpassword = findViewById(R.id.txPassword);
            EditText txbithdate = findViewById(R.id.txBithDate);
            Spinner listProvince = findViewById(R.id.spProvince);
            EditText txaddress = findViewById(R.id.txAddress);
            EditText txZipcode = findViewById(R.id.txZipCode);
            EditText txInterest = findViewById(R.id.txInterst);
            EditText txShareLocation = findViewById(R.id.txShareLocation);


            //btn Safe
            Button btnUpdate = findViewById(R.id.btnSave);


            //Check if the intent is null
            // Get the extras (if there are any)


            try {

                userID = intent.getIntExtra("id",0);
                txFname.setText(intent.getStringExtra("FName"));
                txLname.setText(intent.getStringExtra("LName"));
                txEmail.setText(intent.getStringExtra("email"));
                txlogin.setText(intent.getStringExtra("login"));
                txpassword.setText(intent.getStringExtra("password"));
                txbithdate.setText(intent.getStringExtra("bithdate"));
                //List of province
                provinceAdapter = new ArrayAdapter<String>(this,
                        android.R.layout.simple_spinner_item, province);
                //set Adapter
                listProvince.setAdapter(provinceAdapter);

                txaddress.setText(intent.getStringExtra("address"));
                txZipcode.setText(intent.getStringExtra("zipcode"));
                txInterest.setText(intent.getStringExtra("txInterest"));
                txShareLocation.setText(intent.getStringExtra("shareLocation"));


            } catch (Exception e) {
                e.printStackTrace();
            }

            btnUpdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                        Users objUserEdit = new Users();
                        objUserEdit.setId(userID);
                        objUserEdit.setFName(txFname.getText().toString());
                        objUserEdit.setLName(txLname.getText().toString());
                        objUserEdit.setEmail(txEmail.getText().toString());
                        objUserEdit.setLogin(txlogin.getText().toString());
                        objUserEdit.setPassword(txpassword.getText().toString());
                        objUserEdit.setBithdate(txbithdate.getText().toString());
                        objUserEdit.setProvince(listProvince.getSelectedItem().toString());
                        objUserEdit.setAddress(txaddress.getText().toString());
                        objUserEdit.setZipcode(txZipcode.getText().toString());
                        objUserEdit.setTxInterest(txInterest.getText().toString());
                        objUserEdit.setShareLocation(txShareLocation.getText().toString());


                       try {
                           // INSERT NEW USER
                           if (userID == 0) {

                               databaseHelper.add_User(objUserEdit);

                               Toast.makeText(EditUser.this,
                                       "User created sucess", Toast.LENGTH_SHORT).show();
                               //Edit user activity
                               Intent intent = new Intent(EditUser.this, MainActivity.class);
                               intent.putExtra("login", txlogin.getText().toString());
                               intent.putExtra("password", txpassword.getText().toString());
                               startActivity(intent);
                               finish();


                           } else { // UPDATE USER

                                 if (databaseHelper.updateUser(objUserEdit)  ) {
                                     Toast.makeText(EditUser.this,
                                             "User updated successfully", Toast.LENGTH_SHORT).show();
                                         startActivity(new Intent(EditUser.this, ManagerUsers.class));

                                 } else {
                                     Toast.makeText(EditUser.this,
                                             "Data Invalid", Toast.LENGTH_SHORT).show();


                                 }
                           }

                       } catch (Exception e) {
                           e.printStackTrace();
                       }

                }
            });


        }
    }