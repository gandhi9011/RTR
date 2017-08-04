package com.example.admin.rtr.SubTitle;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Admin on 27-04-2017.
 */
public class SubTitle implements Parcelable {

    private String name;
    private int img;

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SubTitle(String name, int img) {
        this.name = name;
        this.img = img;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    public SubTitle(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<SubTitle> CREATOR = new Creator<SubTitle>() {
        @Override
        public SubTitle createFromParcel(Parcel source) {
            return new SubTitle(source);
        }

        @Override
        public SubTitle[] newArray(int size) {
            return new SubTitle[size];
        }
    };
}