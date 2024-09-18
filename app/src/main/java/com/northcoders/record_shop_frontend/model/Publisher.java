package com.northcoders.record_shop_frontend.model;

import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;

public class Publisher {

    @SerializedName("publisherID")
    private Long publisherId;
    @SerializedName("name")
    private String name;

    public Publisher() {}

    public Publisher(Long publisherId, String name) {
        this.publisherId = publisherId;
        this.name = name;
    }

    @Bindable
    public Long getPublisherId() {
        return publisherId;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public void setName(String name) {
        this.name = name;
    }
}
