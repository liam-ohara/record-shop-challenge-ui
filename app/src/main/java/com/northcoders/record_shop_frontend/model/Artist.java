package com.northcoders.record_shop_frontend.model;

import androidx.databinding.Bindable;

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

    @Bindable
    public Long getArtistId() {
        return artistId;
    }

    @Bindable
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
