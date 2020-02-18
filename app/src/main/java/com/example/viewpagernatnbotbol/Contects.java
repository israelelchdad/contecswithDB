package com.example.viewpagernatnbotbol;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contects implements Parcelable{
    @PrimaryKey
     @NonNull
    String name;
    String lastname;
    int imeg;
    String job;
    boolean isfavorite;
    int rating;


    protected Contects(Parcel in) {
        name = in.readString();
        lastname = in.readString();
        imeg = in.readInt();
        job = in.readString();
        isfavorite = in.readByte() != 0;
        rating = in.readInt();
    }

    public static final Creator<Contects> CREATOR = new Creator<Contects>() {
        @Override
        public Contects createFromParcel(Parcel in) {
            return new Contects(in);
        }

        @Override
        public Contects[] newArray(int size) {
            return new Contects[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getImeg() {
        return imeg;
    }

    public void setImeg(int imeg) {
        this.imeg = imeg;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public boolean isIsfavorite() {
        return isfavorite;
    }

    public void setIsfavorite(boolean isfavorite) {
        this.isfavorite = isfavorite;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Contects(String name, String lastname, int imeg, String job, boolean isfavorite, int rating) {
        this.name = name;
        this.lastname = lastname;
        this.imeg = imeg;
        this.job = job;
        this.isfavorite = isfavorite;
        this.rating = rating;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(lastname);
        dest.writeInt(imeg);
        dest.writeString(job);
        dest.writeByte((byte) (isfavorite ? 1 : 0));
        dest.writeInt(rating);
    }
}
