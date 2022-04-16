package com.example.assigment_;

import static android.content.Context.MODE_PRIVATE;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseUsers extends SQLiteOpenHelper {

    final static String DATABASE_NAME = "AppLibraryDB";
    final static int DATABASE_VERSION = 4;
    final static String TABLE1_Name = "tb_users";
    final static String T1COL1 = "Id";
    final static String T1COL2 = "FName";
    final static String T1COL3 = "LName";
    final static String T1COL4 = "email";
    final static String T1COL5 = "login";
    final static String T1COL6 = "password";
    final static String T1COL7 = "bithdate";
    final static String T1COL8 = "province";
    final static String T1COL9 = "address";
    final static String T1COL10 = "zipcode";
    final static String T1COL11 = "phonenumber";
    final static String T1COL12 = "txInterest";
    final static String T1COL13 = "shareLocation";



    public DatabaseUsers(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            String CREATE_TABLE = "CREATE TABLE " + TABLE1_Name + "("
                    + T1COL1 + " INTEGER PRIMARY KEY, " + T1COL2 + " TEXT,"
                    + T1COL3 + " TEXT, " + T1COL4 + " TEXT,"
                    + T1COL5 + " TEXT, " + T1COL6 + " TEXT,"
                    + T1COL7 + " TEXT, " + T1COL8 + " TEXT,"
                    + T1COL9 + " TEXT, " + T1COL10 + " TEXT,"
                    + T1COL11 + " TEXT, " + T1COL12 + " TEXT,"
                    + T1COL13 + " TEXT " + ")";
            db.execSQL(CREATE_TABLE);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE1_Name);

        // Create tables again
        onCreate(db);
    }

//Add users
    void add(Users user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(T1COL2, user.getFName());
        values.put(T1COL3, user.getLName());
        values.put(T1COL4, user.getEmail());
        values.put(T1COL5, user.getLogin());
        values.put(T1COL6, user.getPassword());
        values.put(T1COL7, user.getBithdate());
        values.put(T1COL8, user.getProvince());
        values.put(T1COL9, user.getAddress());
        values.put(T1COL10, user.getZipcode());
        values.put(T1COL11, user.getPhonenumber());
        values.put(T1COL12, user.getTxInterest());
        values.put(T1COL13, user.getShareLocation());

        //insert
        db.insert(TABLE1_Name,null, values);
        db.close();

    }

    //Show all user
    public Cursor viewRecord(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE1_Name;
        Cursor c =sqLiteDatabase.rawQuery(query,null);
        return c;
    }

    //Update User
    public int updateUser(Users user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();


        values.put(T1COL2, user.getFName());
        values.put(T1COL3, user.getLName());
        values.put(T1COL4, user.getEmail());
        values.put(T1COL5, user.getLogin());
        values.put(T1COL6, user.getPassword());
        values.put(T1COL7, user.getBithdate());
        values.put(T1COL8, user.getProvince());
        values.put(T1COL9, user.getAddress());
        values.put(T1COL10, user.getZipcode());
        values.put(T1COL11, user.getPhonenumber());
        values.put(T1COL12, user.getTxInterest());
        values.put(T1COL13, user.getShareLocation());


        // updating row
        return db.update(TABLE1_Name, values, T1COL1 + " = ?",
                new String[] { String.valueOf(user.getId()) });

    }


    //Get user by First Name
    public Cursor getUser(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE1_Name, new String[] {
                T1COL1, T1COL2, T1COL3, T1COL4, T1COL5, T1COL6, T1COL7, T1COL8, T1COL9, T1COL10, T1COL11, T1COL12, T1COL13  }, T1COL2 + "=?",
                new String[] { String.valueOf(name) }, null, null, null);

        if (cursor != null)
            cursor.moveToFirst();


        return cursor;

    }

    //Insert new USER
    void addNewUser(Users user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(T1COL2, user.getFName()); // First Name
        values.put(T1COL3, user.getLName());
        values.put(T1COL4, user.getEmail());
        values.put(T1COL5, user.getLogin());
        values.put(T1COL6, user.getPassword());
        values.put(T1COL7, user.getBithdate());
        values.put(T1COL8, user.getProvince());
        values.put(T1COL9, user.getAddress());
        values.put(T1COL10, user.getZipcode());
        values.put(T1COL11, user.getPhonenumber());
        values.put(T1COL12, user.getTxInterest());
        values.put(T1COL13, user.getShareLocation());

        //Insert row
        db.insert(TABLE1_Name, null, values);

        db.close(); // Closing database connection


    }


    //Check user login
    public boolean checkUser(String sUser, String sPW) {

        SQLiteDatabase db = this.getReadableDatabase();
        String[] args = { sUser, sPW };

        Cursor cursor = db.query(TABLE1_Name, new String[] {
                        T1COL1, T1COL2, T1COL3, T1COL4  }, "login=? AND password=?",
                args, null, null, null);

        /*Cursor  cursor = db.query(TABLE1_Name, null, "id = ?", new String[] { String.valueOf("5") },
                null, null, null);*/


        if (cursor != null)
            cursor.moveToFirst();


        if (cursor.getCount() > 0)
            return true;
        else
            return false;

    }

    // Deleting single user
     void deleteUser(Users contact) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE1_Name, T1COL1 + " = ?",
                    new String[]{String.valueOf(contact.getId())});
            db.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
