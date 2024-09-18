package com.northcoders.record_shop_frontend.ui.mainactivity;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.northcoders.record_shop_frontend.model.Album;
import com.northcoders.record_shop_frontend.model.AlbumRepository;
import com.northcoders.record_shop_frontend.service.AlbumApiService;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private AlbumRepository albumRepository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.albumRepository = new AlbumRepository(application);
    }

    public LiveData<List<Album>> getAllAlbums() {
        return albumRepository.getMutableLiveData();
    }
}
