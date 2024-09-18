package com.northcoders.record_shop_frontend.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.northcoders.record_shop_frontend.BR;

public class Album extends BaseObservable {

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
}
