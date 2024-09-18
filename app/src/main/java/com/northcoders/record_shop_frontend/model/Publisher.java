package com.northcoders.record_shop_frontend.model;

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

    public Long getPublisherId() {
        return publisherId;
    }

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
