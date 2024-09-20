package com.northcoders.record_shop_frontend.ui.updatealbum;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.record_shop_frontend.databinding.ActivityUpdateAlbumBinding;
import com.northcoders.record_shop_frontend.model.Album;

import com.northcoders.record_shop_frontend.R;
import com.northcoders.record_shop_frontend.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumActivity extends AppCompatActivity {

    private Album album;
    private ActivityUpdateAlbumBinding activityUpdateAlbumBinding;
    private UpdateAlbumClickHandlers updateAlbumClickHandlers;
    public static final String ALBUM_KEY = "album";

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_album);

        album = getIntent().getParcelableExtra(ALBUM_KEY, Album.class);
        activityUpdateAlbumBinding.setAlbum(album);

        activityUpdateAlbumBinding = DataBindingUtil.setContentView(this, R.layout.activity_update_album);

        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        updateAlbumClickHandlers = new UpdateAlbumClickHandlers(album, viewModel, this);

        activityUpdateAlbumBinding.setClickhandler(updateAlbumClickHandlers);

    }
}