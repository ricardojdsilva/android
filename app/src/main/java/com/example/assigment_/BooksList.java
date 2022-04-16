package com.example.assigment_;

public class BooksList {
    int bookID;
    String bookTitle;
    String bookAuthor;
    String bookPublisher;
    String transaction;
    Float rentValue;

    //Create default constructor
    public BooksList() {}

    public BooksList(int bookID, String bookTitle, String bookAuthor, String bookPublisher,
                     String transaction, Float rentValue) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.transaction = transaction;
        this.rentValue = rentValue;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public Float getRentValue() {
        return rentValue;
    }

    public void setRentValue(Float rentValue) {
        this.rentValue = rentValue;
    }


    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }
}
