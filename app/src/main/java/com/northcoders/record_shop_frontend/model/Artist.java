package com.northcoders.record_shop_frontend.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.google.gson.annotations.SerializedName;
import com.northcoders.record_shop_frontend.BR;

public class Artist extends BaseObservable implements Parcelable {

    @SerializedName("artistId")
    private Long artistId;
    @SerializedName("name")
    private String name;

    public Artist() {}

    public Artist(Long artistId, String name) {
        this.artistId = artistId;
        this.name = name;
    }

    protected Artist(Parcel in) {
        if (in.readByte() == 0) {
            artistId = null;
        } else {
            artistId = in.readLong();
        }
        name = in.readString();
    }

    public static final Creator<Artist> CREATOR = new Creator<Artist>() {
        @Override
        public Artist createFromParcel(Parcel in) {
            return new Artist(in);
        }

        @Override
        public Artist[] newArray(int size) {
            return new Artist[size];
        }
    };

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
        notifyPropertyChanged(BR.artistId);
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
        if (artistId == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeLong(artistId);
        }
        parcel.writeString(name);
    }
}
