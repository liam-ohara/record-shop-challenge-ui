package com.northcoders.record_shop_frontend.model;

public class Album {

    private Long albumId;
    private String name;
    private Artist artist;
    private Publisher publisher;
    private String releaseDate;
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

    public Long getAlbumId() {
        return albumId;
    }

    public String getName() {
        return name;
    }

    public Artist getArtist() {
        return artist;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setAlbumId(Long albumId) {
        this.albumId = albumId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
