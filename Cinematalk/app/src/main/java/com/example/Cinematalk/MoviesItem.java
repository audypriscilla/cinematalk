package com.example.Cinematalk;

import android.os.Parcel;
import android.os.Parcelable;


public class MoviesItem implements Parcelable {
    private String judul, synopsis, directors, writers, poster;
    public MoviesItem(String judul, String synopsis, String director, String writers, String poster ) {
        this.judul = judul;
        this.synopsis = synopsis;
        this.directors = directors;
        this.writers = writers;
        this.poster = poster;
    }

    public String getJudul() {
        return judul;
    }
    public String getSynopsis() {
        return synopsis;
    }
    public String getDirector() {
        return directors;
    }
    public String getWriters(){
        return writers;
    }
    public String getPoster() {
        return poster;
    }
    public void setJudul(String judul) {
        this.judul = judul;
    }
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }
    public void setDirectors(String directors) {this.directors= directors;
    }

    public void setWriters(String writers) {
        this.writers = writers;
    }
    public void setPoster(String poster) {this.poster= poster;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.judul);
        parcel.writeString(this.synopsis);
        parcel.writeString(this.directors);
        parcel.writeString(this.writers);
        parcel.writeString(this.poster);
    }

    public MoviesItem(){
    }

    protected MoviesItem(Parcel in ){
        this.judul = in.readString();
        this.synopsis = in.readString();
        this.directors = in.readString();
        this.writers = in.readString();
        this.poster = in.readString();
    }

    public static final Parcelable.Creator<MoviesItem> CREATOR = new Parcelable.Creator<MoviesItem>(){
        @Override
        public MoviesItem createFromParcel(Parcel source) {
            return new MoviesItem(source);
        }
        @Override
        public MoviesItem[] newArray(int size) {
            return new MoviesItem[size];
        }
    };
}