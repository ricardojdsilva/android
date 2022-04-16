package com.example.assigment_;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {

    App_DB databaseHelper;

    private Context context;
    private ArrayList<Users> userModelArrayList;

    //Declare constructor
    public UserAdapter(Context context, ArrayList<Users> userModelArrayList) {
        this.context = context;
        this.userModelArrayList = userModelArrayList;
        //db connect
        databaseHelper = new App_DB(context);
    }

    @Override
    public int getViewTypeCount() {
        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return userModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return userModelArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;



        if (convertView == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.list_item_users, null, true);

            holder.IDUser = (TextView) convertView.findViewById(R.id.txIdUser);
            holder.FUser = (TextView) convertView.findViewById(R.id.txlbUser);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.IDUser.setText(String.valueOf(userModelArrayList.get(position).getId()));
        holder.FUser.setText(String.valueOf(userModelArrayList.get(position).getFName()));
        ImageButton smsButton = (ImageButton) convertView.findViewById(R.id.smsButton);
        ImageButton editButton = (ImageButton) convertView.findViewById(R.id.editButton);
        ImageButton deleteButton = (ImageButton) convertView.findViewById(R.id.deleteButton);

        //Send Message to User
        smsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(context,MenssageToUser.class);
                context.startActivity(myIntent);

            }
        });

        //Delete User
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get user data from classe
                Object obj1 = getItem(position);
                Users uses = Users.class.cast(obj1);

                databaseHelper.deleteUser(uses);
                //refresh the lisview
                Intent myIntent = new Intent(context,ManagerUsers.class);
                context.startActivity(myIntent);


            }
        });

        //Edit user
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    //Get user data from classe
                    Object obj1 = getItem(position);
                    Users uses = Users.class.cast(obj1);

                        //Edit user activity
                        Intent intent = new Intent(context, EditUser.class);
                        Bundle user = new Bundle();

                            intent.putExtra("id", uses.getId());

                            intent.putExtra("FName", uses.getFName());
                            intent.putExtra("LName", uses.getLName());
                            intent.putExtra("email", uses.getEmail());
                            intent.putExtra("login", uses.getLogin());
                            intent.putExtra("password", uses.getPassword());
                            intent.putExtra("bithdate", uses.getBithdate());
                            intent.putExtra("province", uses.getProvince());
                            intent.putExtra("address", uses.getAddress());
                            intent.putExtra("zipcode", uses.getZipcode());
                            intent.putExtra("phonenumber", uses.getPhonenumber());
                            intent.putExtra("txInterest", uses.getTxInterest());
                            intent.putExtra("shareLocation", uses.getShareLocation());


                        intent.putExtras(user);
                        context.startActivity(intent);



                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        return convertView;


    }


    private class ViewHolder {

        protected TextView IDUser, FUser;
       // protected ImageView label_delete;

    }


}
