package com.example.assigment_;

public class Users {

    private int Id;
    private String FName;
    private String LName;
    private String email;
    private String login;
    private String password;
    private String bithdate;
    private String province;
    private String address;
    private String zipcode;
    private String phonenumber;
    private String txInterest;
    private String shareLocation;

    //Default Construct
    public Users(){}

    //Constructor with params
    public Users(String name, String LastName,  String email,
                 String login,
                 String password,
                 String bithdate,
                 String province,
                 String address,
                 String zipcode,
                 String phonenumber,
                 String txInterest,
                 String shareLocation)
    {
        this.FName = name;
        this.LName = LastName;
        this.email = email;
        this.login = login;
        this.password = password;
        this.bithdate = bithdate;
        this.province = province;
        this.address = address;
        this.zipcode = zipcode;
        this.phonenumber = phonenumber;
        this.txInterest = txInterest;
        this.shareLocation = shareLocation;
    }

    public Users(String name, String LastName) {
        this.FName = name;
        this.LName = LastName;
    }

    public int getId() {
        return Id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBithdate() {
        return bithdate;
    }

    public void setBithdate(String bithdate) {
        this.bithdate = bithdate;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getTxInterest() {
        return txInterest;
    }

    public void setTxInterest(String txInterest) {
        this.txInterest = txInterest;
    }

    public String getShareLocation() {
        return shareLocation;
    }

    public void setShareLocation(String shareLocation) {
        this.shareLocation = shareLocation;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return userType;
    }

    private String userType;
    //Default Construct



    //Getters

    public String getFName() {
        return this.FName;
    }

    public String getLName() {
        return this.LName;
    }

    //setters

    public void setId (int id) {
        this.Id = id;
    }

    public void setFName(String name) {
        this.FName = name;
    }

    public void setLName(String LastName) {
        this.LName = LastName;
    }

}
