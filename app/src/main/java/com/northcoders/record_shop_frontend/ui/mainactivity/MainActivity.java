package com.northcoders.record_shop_frontend.ui.mainactivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.widget.SearchView;
import android.widget.Toast;

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
    private ArrayList<Album> filteredAlbumList;
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

        SearchView searchView = findViewById(R.id.searchView);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                filterList(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                return false;
            }
        });

    }

    private void filterList(String query) {

        filteredAlbumList = new ArrayList<>();

        for(Album album : albumList) {
            if (album.getName().toLowerCase().contains(query.toLowerCase()) || album.getGenre().toLowerCase().contains(query.toLowerCase()) || album.getArtist().getName().toLowerCase().contains(query.toLowerCase()) || album.getPublisher().getName().toLowerCase().contains(query.toLowerCase())) {
                filteredAlbumList.add(album);
            }
        }

        if (filteredAlbumList.isEmpty()) {
            Toast.makeText(MainActivity.this, "No matches found", Toast.LENGTH_SHORT).show();
        } else {
            albumAdapter.setFilteredList(filteredAlbumList);
        }
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

        if (filteredAlbumList == null || filteredAlbumList.isEmpty()) {
            intent.putExtra(ALBUM_KEY, albumList.get(position));
            intent.putExtra(ARTIST_KEY, albumList.get(position).getArtist());
            intent.putExtra(PUBLISHER_KEY, albumList.get(position).getPublisher());

        } else {
            intent.putExtra(ALBUM_KEY, filteredAlbumList.get(position));
            intent.putExtra(ARTIST_KEY, filteredAlbumList.get(position).getArtist());
            intent.putExtra(PUBLISHER_KEY, filteredAlbumList.get(position).getPublisher());

        }

        startActivity(intent);

    }
}