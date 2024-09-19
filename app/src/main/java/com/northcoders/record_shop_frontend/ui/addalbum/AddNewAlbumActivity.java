package com.northcoders.record_shop_frontend.ui.addalbum;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.record_shop_frontend.R;
import com.northcoders.record_shop_frontend.databinding.ActivityAddNewAlbumBinding;
import com.northcoders.record_shop_frontend.model.Album;
import com.northcoders.record_shop_frontend.ui.mainactivity.MainActivityViewModel;

public class AddNewAlbumActivity extends AppCompatActivity {

    private ActivityAddNewAlbumBinding newAlbumBinding;
    private AddAlbumClickHandlers addAlbumClickHandlers;
    private Album album;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_album);

        album = new Album();

        newAlbumBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_album);

        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        newAlbumBinding.setAlbum(album);

        newAlbumBinding.setClickhandler(addAlbumClickHandlers);

    }
}