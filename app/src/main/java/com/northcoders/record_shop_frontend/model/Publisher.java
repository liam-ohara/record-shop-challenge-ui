package com.northcoders.record_shop_frontend.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.northcoders.record_shop_frontend.BR;

public class Publisher extends BaseObservable implements Parcelable {

    @SerializedName("publisherID")
    private Long publisherId;
    @SerializedName("name")
    private String name;

    public Publisher() {}

    public Publisher(Long publisherId, String name) {
        this.publisherId = publisherId;
        this.name = name;
    }

    protected Publisher(Parcel in) {
        if (in.readByte() == 0) {
            publisherId = null;
        } else {
            publisherId = in.readLong();
        }
        name = in.readString();
    }

    public static final Creator<Publisher> CREATOR = new Creator<Publisher>() {
        @Override
        public Publisher createFromParcel(Parcel in) {
            return new Publisher(in);
        }

        @Override
        public Publisher[] newArray(int size) {
            return new Publisher[size];
        }
    };

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
        notifyPropertyChanged(BR.publisherId);
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        if (publisherId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(publisherId);
        }
        parcel.writeString(name);
    }
}
