package com.example.jimmy_pc.ingdemo.Model.RecyclerViewPojo;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Jimmy-PC on 11/8/2017.
 */

public class RecyclerViewItem implements Parcelable{
    String name;
    String phoneNo;
    String email;
    String balance;
    String img;

    public RecyclerViewItem(String name,String phoneNo,String email,String balance,String img){
        this.email = email;
        this.balance = balance;
        this.img = img;
        this.name = name;
        this.phoneNo = phoneNo;
    }

    public RecyclerViewItem(Parcel in) {
        name = in.readString();
        email = in.readString();
        balance = in.readString();
        phoneNo = in.readString();
        img = in.readString();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(email);
        parcel.writeString(balance);
        parcel.writeString(phoneNo);
        parcel.writeString(img);
    }

    public static final Parcelable.Creator<RecyclerViewItem> CREATOR = new Parcelable.Creator<RecyclerViewItem>() {
        public RecyclerViewItem createFromParcel(Parcel in) {
            return new RecyclerViewItem(in);
        }

        public RecyclerViewItem[] newArray(int size) {
            return new RecyclerViewItem[size];
        }
    };
}
