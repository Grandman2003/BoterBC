package com.example.boterprojectjunior.domains;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class User implements Parcelable,Serializable {
    public String first_name,last_name,email;
    public User(){

    }
    public User(String first_name,String last_name,String email){
        this.first_name=first_name;
        this.last_name=last_name;
        this.email=email;
    }

    protected User(Parcel in) {
        first_name = in.readString();
        last_name = in.readString();
        email = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        Bundle bundle=new Bundle();
        bundle.putString("first_name",first_name);
        bundle.putString("last_name",last_name);
        bundle.putString("email_name",email);
        dest.writeBundle(bundle);
    }

}
