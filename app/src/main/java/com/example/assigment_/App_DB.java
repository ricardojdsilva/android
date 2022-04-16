package com.example.assigment_;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class App_DB extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "book_app.db";
    final static int DATABASE_VERSION = 1;
    //////////////////////// Book_tb /////////////////////
    final static String TABLE1_Name = "Books_table";
    final static String T1COL1 = "Id";
    final static String T1COL2 = "BTitle";
    final static String T1COL3 = "BPublisher";
    final static String T1COL4 = "BAuthor";
    final static String T1COL5 = "BGenre";
    final static String T1COL6 = "BPublicationY";
    //////////////////////// user_tb /////////////////////
    final static String TABLE2_Name = "tb_users";
    final static String T2COL1 = "Id";
    final static String T2COL2 = "FName";
    final static String T2COL3 = "LName";
    final static String T2COL4 = "email";
    final static String T2COL5 = "login";
    final static String T2COL6 = "password";
    final static String T2COL7 = "bithdate";
    final static String T2COL8 = "province";
    final static String T2COL9 = "address";
    final static String T2COL10 = "zipcode";
    final static String T2COL11 = "phonenumber";
    final static String T2COL12 = "txInterest";
    final static String T2COL13 = "shareLocation";
    final static String T2COL14 = "usertype";
    //////////////////////// book_transaction_tb /////////////////////
    final static String TABLE3_Name = "Book_transaction";
    final static String T3COL1 = "transaction_id";
    final static String T3COL2 = "book_id";
    final static String T3COL3 = "user_id";
    final static String T3COL4 = "type";
    final static String T3COL5 = "price";
    //////////////////////// Give_away_tb /////////////////////
    final static String TABLE4_Name = "give_away_tb";
    final static String T4COL1 = "action_id";
    final static String T4COL2 = "transaction_id";
    final static String T4COL3 = "reciver_id";
    //////////////////////// Give_away_tb /////////////////////
    final static String TABLE5_Name = "Rent_Share_tb";
    final static String T5COL1 = "action_id";
    final static String T5COL2 = "transaction_id";
    final static String T5COL3 = "Rent_id";
    final static String T5COL4 = "Start_date";
    final static String T5COL5 = "End_date";
    final static String T5COL6 = "Set_price";
    final static String T5COL7 = "pickup_address";
    final static String T5COL8 = "note";
    //////////////////////// Give_away_tb /////////////////////
    final static String TABLE6_Name = "Tracker_tb";
    final static String T6COL1 = "track_id";
    final static String T6COL2 = "user_id";
    final static String T6COL3 = "transaction_id";
    final static String T6COL4 = "track_title";
    final static String T6COL5 = "comment";
    final static String T6COL6 = "rate";
    final static String T6COL7 = "track_date";



    public App_DB(@Nullable Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        SQLiteDatabase app_db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase app_db) {
        String book_cr = "CREATE TABLE " + TABLE1_Name + "(" + T1COL1 + " INTEGER PRIMARY KEY," +
                T1COL2 + " TEXT," + T1COL3 + " TEXT," + T1COL4 + " Text," + T1COL5 +
                " Text,"+ T1COL6 +
                " Text)";
        String user_cr = "CREATE TABLE " + TABLE2_Name + "("
                + T2COL1 + " INTEGER PRIMARY KEY, " + T2COL2 + " TEXT,"
                + T2COL3 + " TEXT, " + T2COL4 + " TEXT,"
                + T2COL5 + " TEXT, " + T2COL6 + " TEXT,"
                + T2COL7 + " TEXT, " + T2COL8 + " TEXT,"
                + T2COL9 + " TEXT, " + T2COL10 + " TEXT,"
                + T2COL11 + " TEXT, " + T2COL12 + " TEXT,"
                + T2COL13 + " TEXT, " + T2COL14 + " TEXT)";
        String book_TRANSACTION_cr = "CREATE TABLE " + TABLE3_Name + "(" + T3COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                T3COL2 + " INTEGER," + T3COL3 + " INTEGER," + T3COL4 + " TEXT," + T3COL5 + " REAL," +
                "FOREIGN KEY(" + T3COL2 + ") REFERENCES "+ TABLE1_Name + "(" +T1COL1+ "),"+
                "FOREIGN KEY(" + T3COL3 + ") REFERENCES "+ TABLE2_Name + "(" +T2COL1+ ") )";
        String Givaeaway_tb_cr = "CREATE TABLE " + TABLE4_Name + "(" +T4COL1+ " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                T4COL2 + " INTEGER," + T4COL3 + " INTEGER," +
                "FOREIGN KEY(" + T4COL2 + ") REFERENCES "+ TABLE3_Name + "(" +T3COL1+ "),"+
                "FOREIGN KEY(" + T4COL3 + ") REFERENCES "+ TABLE2_Name + "(" +T2COL1+ ") )";
        String Rent_share_tb_cr = "CREATE TABLE " + TABLE5_Name + "(" + T5COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                T5COL2 + " INTEGER," + T5COL3 + " INTEGER," + T5COL4 + " TEXT," + T5COL5 + " TEXT," + T5COL6 + " REAL,"+
                T5COL7 + " TEXT," + T5COL8 + " TEXT," +
                "FOREIGN KEY(" + T5COL2 + ") REFERENCES "+ TABLE3_Name + "(" +T3COL1+ "),"+
                "FOREIGN KEY(" + T5COL3 + ") REFERENCES "+ TABLE2_Name + "(" +T2COL1+ ") )";
        String tracker_tb_cr = "CREATE TABLE " + TABLE6_Name + "(" + T6COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                T6COL2 + " INTEGER," + T6COL3 + " INTEGER," + T6COL4 + " TEXT," + T6COL5 + " TEXT," + T6COL7 + " TEXT,"+
                "FOREIGN KEY(" + T6COL2 + ") REFERENCES "+ TABLE2_Name + "(" +T2COL1+ "),"+
                "FOREIGN KEY(" + T6COL3 + ") REFERENCES "+ TABLE3_Name + "(" +T3COL1+ ") )";
        try{
            app_db.execSQL(book_cr);
            app_db.execSQL(user_cr);
            app_db.execSQL(book_TRANSACTION_cr);
            app_db.execSQL(Givaeaway_tb_cr);
            app_db.execSQL(Rent_share_tb_cr);
            app_db.execSQL(tracker_tb_cr);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase app_db, int oldVersion, int newVersion) {
        app_db.execSQL("DROP TABLE IF EXISTS "+TABLE1_Name);
        app_db.execSQL("DROP TABLE IF EXISTS "+TABLE2_Name);
        app_db.execSQL("DROP TABLE IF EXISTS "+TABLE3_Name);
        app_db.execSQL("DROP TABLE IF EXISTS "+TABLE4_Name);
        app_db.execSQL("DROP TABLE IF EXISTS "+TABLE5_Name);
        app_db.execSQL("DROP TABLE IF EXISTS "+TABLE6_Name);
        onCreate(app_db);
    }


    // Deleting single user
    void deleteUser(Users contact) {
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            db.delete(TABLE2_Name, T2COL1 + " = ?",
                    new String[]{String.valueOf(contact.getId())});
            db.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Add users
    public boolean add_User(Users user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(T2COL2, user.getFName());
        values.put(T2COL3, user.getLName());
        values.put(T2COL4, user.getEmail());
        values.put(T2COL5, user.getLogin());
        values.put(T2COL6, user.getPassword());
        values.put(T2COL7, user.getBithdate());
        values.put(T2COL8, user.getProvince());
        values.put(T2COL9, user.getAddress());
        values.put(T2COL10, user.getZipcode());
        values.put(T2COL11, user.getPhonenumber());
        values.put(T2COL12, user.getTxInterest());
        values.put(T2COL13, user.getShareLocation());
        values.put(T2COL14, user.getUserType());

        long r = db.insert(TABLE2_Name,null,values);
        if(r>0)
            return true;
        else
            return false;
    }
    //add book
    public boolean AddBookRecord(String bt,String bp,String ba,String bg,String by){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues value = new ContentValues();
        value.put(T1COL2,bt);
        value.put(T1COL3,bp);
        value.put(T1COL4,ba);
        value.put(T1COL5,bg);
        value.put(T1COL6,by);
        long r = sqLiteDatabase.insert(TABLE1_Name,null,value);
        if(r>0)
            return true;
        else
            return false;
    }
    //add book_transaction
    public boolean Add_book_transaction( String type, Float price){
        SQLiteDatabase app_db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T3COL4, type);
        values.put(T3COL5, price);
        long r = app_db.insert(TABLE3_Name,null,values);
        if(r>0){
            return true;
        }else{
            return false;
        }
    }
    //add give_away
    public boolean Add_give_away(Integer transaction_id, Integer receiver_id){
        SQLiteDatabase app_db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T4COL2,transaction_id);
        values.put(T4COL3,receiver_id);
        long r = app_db.insert(TABLE4_Name,null,values);
        if(r>0){
            return true;
        }else{
            return false;
        }
    }
    //add rent_share
    public boolean Add_Rent_share(Integer transaction_id, Integer renter_id, String start_date, String end_date, Float setPrice, String pickup_address, String note){
        SQLiteDatabase app_db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T5COL2,transaction_id);
        values.put(T5COL3,renter_id);
        values.put(T5COL4,start_date);
        values.put(T5COL5,end_date);
        values.put(T5COL6,setPrice);
        values.put(T5COL7,pickup_address);
        values.put(T5COL8,note);
        long r = app_db.insert(TABLE5_Name,null,values);
        if(r<0){
            return true;
        }else{
            return false;
        }
    }
    //add tracker
    public boolean Add_Tracker(Integer user_id, Integer transaction_id, String track_title, String comment, String rate, String track_date){
        SQLiteDatabase app_db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T6COL2,user_id);
        values.put(T6COL3,transaction_id);
        values.put(T6COL4,track_title);
        values.put(T6COL5,comment);
        values.put(T6COL6,rate);
        values.put(T6COL7,track_date);
        long r = app_db.insert(TABLE6_Name,null,values);
        if(r<0){
            return true;
        }else{
            return false;
        }
    }


    //Show all user
    public Cursor viewRecord(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "SELECT * FROM " + TABLE2_Name;
        Cursor c =sqLiteDatabase.rawQuery(query,null);
        return c;
    }


    //Check user login
    public boolean checkUser(String sUser, String sPW) {

        SQLiteDatabase db = this.getReadableDatabase();
        String[] args = { sUser, sPW };

        Cursor cursor = db.query(TABLE2_Name, new String[] {
                        T2COL1, T2COL2, T2COL3, T2COL4  }, "login=? AND password=?",
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


    //update user
    public boolean updateUser(Users user) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T2COL2, user.getFName());
        values.put(T2COL3, user.getLName());
        values.put(T2COL4, user.getEmail());
        values.put(T2COL5, user.getLogin());
        values.put(T2COL6, user.getPassword());
        values.put(T2COL7, user.getBithdate());
        values.put(T2COL8, user.getProvince());
        values.put(T2COL9, user.getAddress());
        values.put(T2COL10, user.getZipcode());
        values.put(T2COL11, user.getPhonenumber());
        values.put(T2COL12, user.getTxInterest());
        values.put(T2COL13, user.getShareLocation());
        values.put(T2COL14, user.getUserType());
        // updating row
        int u = db.update(TABLE2_Name, values, T2COL1 + " = ?",
                new String[] { Integer.toString(user.getId()) });
        if (u > 0) {
            return true;
        }else{
            return false;
        }
    }
    //update book
    public boolean update_book(int id, String bt,String bp,String ba,String bg,String by){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T1COL2,bt);
        values.put(T1COL3,bp);
        values.put(T1COL4,ba);
        values.put(T1COL5,bg);
        values.put(T1COL6,by);
        int u = db.update(TABLE1_Name,values,T1COL1 + " = ?",
                new String[]{Integer.toString(id)});
        if(u > 0){
            return true;
        }else{
            return false;
        }
    }
    //update book transaction
    public boolean update_book_transaction(int transaction_id, Integer book_id, Integer user_id, String type, Float price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T3COL2,book_id);
        values.put(T3COL3,user_id);
        values.put(T3COL4,type);
        values.put(T3COL5,price);
        int u = db.update(TABLE3_Name,values,T3COL1 + " = ?",
                new String[]{Integer.toString(transaction_id)});
        if(u > 0){
            return true;
        }else{
            return false;
        }
    }
    //update giveaway
    public boolean update_give_away(Integer action_id, Integer transaction_id, Integer receiver_id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T4COL2,transaction_id);
        values.put(T4COL3,receiver_id);
        int u = db.update(TABLE3_Name,values,T4COL1 + " = ?",
                new String[]{Integer.toString(action_id)});
        if(u > 0){
            return true;
        }else{
            return false;
        }
    }
    //update rent/share
    public boolean update_rent_share_tb(Integer action_id,Integer transaction_id, Integer renter_id, String start_date, String end_date, Float setPrice, String pickup_address, String note){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T5COL2,transaction_id);
        values.put(T5COL3,renter_id);
        values.put(T5COL4,start_date);
        values.put(T5COL5,end_date);
        values.put(T5COL6,setPrice);
        values.put(T5COL7, pickup_address);
        values.put(T5COL8,note);
        int u = db.update(TABLE5_Name,values,T5COL1+" =? ",
                new String[]{Integer.toString(action_id)});
        if(u > 0){
            return true;
        }else{
            return false;
        }
    }
    //update tracker
    public boolean update_tracker(Integer track_id ,Integer user_id, Integer transaction_id, String track_title, String comment, String rate, String track_date){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(T6COL2,user_id);
        values.put(T6COL3,transaction_id);
        values.put(T6COL4,track_title);
        values.put(T6COL5,comment);
        values.put(T6COL6,rate);
        values.put(T6COL7,track_date);
        int u = db.update(TABLE6_Name,values,T6COL1+"=?",
                new String[]{Integer.toString(track_id)});
        if(u > 0){
            return true;
        }else{
            return false;
        }
    }
    public Cursor view_all(String TableName){
        SQLiteDatabase db = this.getReadableDatabase();
        String read_query = "";
        switch (TableName){
            case "book":
                read_query = "SELECT * FROM "+TABLE1_Name;
                break;
            case "user":
                read_query = "SELECT * FROM "+TABLE2_Name;
                break;
            case "book_transaction":
                read_query = "SELECT * FROM "+TABLE3_Name;
                break;
            case "giveaway":
                read_query = "SELECT * FROM "+TABLE4_Name;
                break;
            case "rent_share":
                read_query = "SELECT * FROM "+TABLE5_Name;
                break;
            case "tracker":
                read_query = "SELECT * FROM "+TABLE6_Name;
                break;
        }
        Cursor read = db.rawQuery(read_query,null);
        return read;
    }

    public Cursor viewBookData(){
        SQLiteDatabase sqLiteDatabase  = this.getWritableDatabase();
        String query = "Select Id, BTitle, BAuthor, BPublisher from Books_table ";
        Cursor c = sqLiteDatabase.rawQuery(query,null);
        return c;
    }
    public Cursor viewBookInfoTransaction() {
        SQLiteDatabase sqLiteDatabase  = this.getWritableDatabase();
        String query = "Select Id, BTitle, BAuthor, BPublisher from Books_table ";
        Cursor c = sqLiteDatabase.rawQuery(query,null);
        return c;
    }

    //delete rec from a table
    public boolean delete_rec(int id, String table_name){
        SQLiteDatabase db = this.getWritableDatabase();
        int d = 0;
        switch (table_name){
            case "book":
                d = db.delete(TABLE1_Name,T1COL1+"=?",new String[]{Integer.toString(id)});
                break;
            case "user":
                d = db.delete(TABLE2_Name,T2COL1+"=?",new String[]{Integer.toString(id)});
                break;
            case "book_transaction":
                d = db.delete(TABLE3_Name,T3COL1+"=?",new String[]{Integer.toString(id)});
                break;
            case "giveaway":
                d = db.delete(TABLE4_Name,T4COL1+"=?",new String[]{Integer.toString(id)});
                break;
            case "rent_share":
                d = db.delete(TABLE5_Name,T5COL1+"=?",new String[]{Integer.toString(id)});
                break;
            case "tracker":
                d = db.delete(TABLE6_Name,T6COL1+"=?",new String[]{Integer.toString(id)});
                break;
        }
        if(d > 0){
            return true;
        }else{
            return false;
        }
    }
}
