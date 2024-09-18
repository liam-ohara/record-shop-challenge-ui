package com.northcoders.record_shop_frontend.model;

import com.google.gson.annotations.SerializedName;

public class Artist {

    @SerializedName("artistId")
    private Long artistId;
    @SerializedName("name")
    private String name;

    public Artist() {}

    public Artist(Long artistId, String name) {
        this.artistId = artistId;
        this.name = name;
    }

    public Long getArtistId() {
        return artistId;
    }

    public String getName() {
        return name;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
