package com.example.testpractice;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Melody implements Parcelable {
    private String Title;
    private String Artist;

    public Melody(String title, String artist) {
        Title = title;
        Artist = artist;
    }

    public Melody(Parcel in) {
        Title = in.readString();
        Artist = in.readString();
    }

    public static final Creator<Melody> CREATOR = new Creator<Melody>() {
        @Override
        public Melody createFromParcel(Parcel in) {
            return new Melody(in);
        }

        @Override
        public Melody[] newArray(int size) {
            return new Melody[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(Title);
        dest.writeString(Artist);
    }

    public String getTitle() {
        return Title;
    }

    public String getArtist() {
        return Artist;
    }
}
