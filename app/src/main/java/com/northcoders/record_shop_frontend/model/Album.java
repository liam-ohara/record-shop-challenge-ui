package com.northcoders.record_shop_frontend.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.northcoders.record_shop_frontend.BR;

public class Album extends BaseObservable implements Parcelable {

    @SerializedName("albumId")
    private Long albumId;
    @SerializedName("name")
    private String name;
    @SerializedName("artist")
    private Artist artist;
    @SerializedName("publisher")
    private Publisher publisher;
    @SerializedName("releaseDate")
    private String releaseDate;
    @SerializedName("genre")
    private String genre;

    public Album() {}

    public Album(Long albumId, String name, Artist artist, Publisher publisher, String releaseDate, String genre) {
        this.albumId = albumId;
        this.name = name;
        this.artist = artist;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.genre = genre;
    }

    protected Album(Parcel in) {
        if (in.readByte() == 0) {
            albumId = null;
        } else {
            albumId = in.readLong();
        }
        name = in.readString();
        releaseDate = in.readString();
        genre = in.readString();
    }

    public static final Creator<Album> CREATOR = new Creator<Album>() {
        @Override
        public Album createFromParcel(Parcel in) {
            return new Album(in);
        }

        @Override
        public Album[] newArray(int size) {
            return new Album[size];
        }
    };

    @Bindable
    public Long getAlbumId() {
        return albumId;
    }

    @Bindable
    public String getName() {
        return name;
    }

    @Bindable
    public Artist getArtist() {
        return artist;
    }

    @Bindable
    public Publisher getPublisher() {
        return publisher;
    }

    @Bindable
    public String getReleaseDate() {
        return releaseDate;
    }

    @Bindable
    public String getGenre() {
        return genre;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
        notifyPropertyChanged(BR.albumId);
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.albumId);
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
        notifyPropertyChanged(BR.artist);
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
        notifyPropertyChanged(BR.publisher);
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
        notifyPropertyChanged(BR.releaseDate);
    }

    public void setGenre(String genre) {
        this.genre = genre;
        notifyPropertyChanged(BR.genre);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        if (albumId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(albumId);
        }
        parcel.writeString(name);
        parcel.writeString(releaseDate);
        parcel.writeString(genre);
    }
}
