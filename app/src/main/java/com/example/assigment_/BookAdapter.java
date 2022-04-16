package com.example.assigment_;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<BooksList> bookModelArrayList;



    //Declare constructor
    public BookAdapter(Context context, ArrayList<BooksList> bookModelArrayList) {
        this.context = context;
        this.bookModelArrayList = bookModelArrayList;
    }

    @Override
    public int getViewTypeCount() {
        if (getCount()>0){
            return getCount();
        }else {
            return super.getViewTypeCount();
        }
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    @Override
    public int getCount() {
        return bookModelArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return bookModelArrayList.get(position);
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
            convertView = inflater.inflate(R.layout.list_item, null, true);

            holder.titulo = (TextView) convertView.findViewById(R.id.txTitle);
            holder.autor = (TextView) convertView.findViewById(R.id.txBookAutor);

            convertView.setTag(holder);
        }else {
            // the getTag returns the viewHolder object set as a tag to the view
            holder = (ViewHolder)convertView.getTag();
        }

        holder.titulo.setText(bookModelArrayList.get(position).getBookTitle());
        holder.autor.setText(String.valueOf(bookModelArrayList.get(position).getBookAuthor()));
        ImageButton btnSeeBook = (ImageButton) convertView.findViewById(R.id.btnSeeBook);

        btnSeeBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    //Get user data from classe
                    Object obj1 = getItem(position);
                    BooksList books = BooksList.class.cast(obj1);

                    //Edit user activity
                    Intent intent = new Intent(context, BooksInfo.class);
                    Bundle book = new Bundle();

                    intent.putExtra("id", books.getBookID());
                    intent.putExtra("Title", books.getBookTitle());
                    intent.putExtra("Author", books.getBookAuthor());
                    intent.putExtra("Publisher", books.getBookPublisher());
                    //intent.putExtra("Genre", books.get());
                    intent.putExtras(book);
                    context.startActivity(intent);



                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return convertView;


    }


    private class ViewHolder {

        protected TextView titulo, autor;

    }
}
