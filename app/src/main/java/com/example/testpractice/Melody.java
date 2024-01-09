package com.example.testpractice;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Melody implements Parcelable {
    private String Title;
    private String Artist;
    private String CoverImageUrl;

    public Melody(String title, String artist, String coverImageUrl) {
        Title = title;
        Artist = artist;
        CoverImageUrl = coverImageUrl;
    }

    public Melody(Parcel in) {
        Title = in.readString();
        Artist = in.readString();
        CoverImageUrl = in.readString();
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
        dest.writeString(CoverImageUrl);
    }

    public String getTitle() {
        return Title;
    }

    public String getCoverImageUrl() {
        return CoverImageUrl;
    }

    public String getArtist() {
        return Artist;
    }
}
