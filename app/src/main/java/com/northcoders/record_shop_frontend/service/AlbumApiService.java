package com.northcoders.record_shop_frontend.service;

import com.northcoders.record_shop_frontend.model.Album;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface AlbumApiService {

    @GET("album")
    Call<List<Album>> getAllAlbum ();

    @POST("album")
    Call<Album> postAlbum(@Body Album album);

    @PATCH("album/{id}")
    Call<Album> updateAlbum(@Path("id") long id, @Body Album album);

    @DELETE("album/{id}")
    Call<Album> deleteAlbum(@Path("id") long id);
}
