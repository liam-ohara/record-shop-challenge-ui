package com.northcoders.record_shop_frontend.ui.mainactivity;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.record_shop_frontend.R;
import com.northcoders.record_shop_frontend.databinding.ActivityMainBinding;
import com.northcoders.record_shop_frontend.model.Album;
import com.northcoders.record_shop_frontend.ui.updatealbum.UpdateAlbumActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{

    private RecyclerView recyclerView;
    private List<Album> albumList;
    private AlbumAdapter albumAdapter;
    private MainActivityViewModel mainActivityViewModel;
    private ActivityMainBinding activityMainBinding;
    private MainActivityClickHandler mainActivityClickHandler;
    public static final String ALBUM_KEY = "album";
    public static final String ARTIST_KEY = "artist";
    public static final String PUBLISHER_KEY = "publisher";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityViewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);
        getAllAlbums();

        mainActivityClickHandler = new MainActivityClickHandler(this);

        activityMainBinding.setClickhandler(mainActivityClickHandler);
    }

    private void getAllAlbums() {
        mainActivityViewModel.getAllAlbums().observe(this, new Observer<List<Album>>() {

            @Override
            public void onChanged(List<Album> albumsFromLiveData) {
                albumList = (ArrayList<Album>) albumsFromLiveData;
                displayInRecyclerView();
            }
        });
    }

    private void displayInRecyclerView() {
        recyclerView = activityMainBinding.albumRecycler;
        albumAdapter = new AlbumAdapter(albumList, this, this);
        recyclerView.setAdapter(albumAdapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        albumAdapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(this, UpdateAlbumActivity.class);

        intent.putExtra(ALBUM_KEY, albumList.get(position));
        intent.putExtra(ARTIST_KEY, albumList.get(position));
        intent.putExtra(PUBLISHER_KEY, albumList.get(position));

        startActivity(intent);

    }
}