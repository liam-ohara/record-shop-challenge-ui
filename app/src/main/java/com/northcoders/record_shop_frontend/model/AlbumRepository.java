package com.northcoders.record_shop_frontend.model;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.northcoders.record_shop_frontend.service.AlbumApiService;
import com.northcoders.record_shop_frontend.service.RetrofitInstance;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumRepository {

    private MutableLiveData<List<Album>> mutableLiveData = new MutableLiveData<>();
    private Application recordShop;

    public AlbumRepository(Application recordShop) {
        this.recordShop = recordShop;
    }

    public MutableLiveData<List<Album>> getMutableLiveData() {

        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<List<Album>> call = albumApiService.getAllAlbum();

        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                List<Album> albumList = response.body();
                mutableLiveData.setValue(albumList);

            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Log.i("HTTP Failure", Objects.requireNonNull(t.getMessage()));

            }
        });
        return mutableLiveData;
    }

    public void postAlbum(Album album) {

        AlbumApiService albumApiService = RetrofitInstance.getService();
        Call<Album> call = albumApiService.postAlbum(album);

        call.enqueue(new Callback<Album>() {
            @Override
            public void onResponse(Call<Album> call, Response<Album> response) {

                Toast toastSuccess = Toast.makeText(recordShop.getApplicationContext(), "Posting album...", Toast.LENGTH_SHORT);
                toastSuccess.show();

            }

            @Override
            public void onFailure(Call<Album> call, Throwable t) {

                Toast toastFail = Toast.makeText(recordShop.getApplicationContext(), "Posting failed!", Toast.LENGTH_SHORT);
                toastFail.show();

            }
        });

    }
}
