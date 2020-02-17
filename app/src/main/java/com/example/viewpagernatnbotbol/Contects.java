package com.example.viewpagernatnbotbol;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

public class Contects implements Parcelable {
    String name;
    String lastname;
    int imeg;
    String job;
    boolean isfavorite;

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

    public Contects(String name, String lastname, int imeg, String job, boolean isfavorite) {
        this.name = name;
        this.lastname = lastname;
        this.imeg = imeg;
        this.job = job;
        this.isfavorite = isfavorite;
    }

    protected Contects(Parcel in) {
        name = in.readString();
        lastname = in.readString();
        imeg = in.readInt();
        job = in.readString();
        isfavorite = in.readByte() != 0;
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
    }
}
