package com.northcoders.record_shop_frontend.ui.updatealbum;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.northcoders.record_shop_frontend.databinding.ActivityUpdateAlbumBinding;
import com.northcoders.record_shop_frontend.model.Album;

import com.northcoders.record_shop_frontend.R;
import com.northcoders.record_shop_frontend.model.Artist;
import com.northcoders.record_shop_frontend.model.Publisher;
import com.northcoders.record_shop_frontend.ui.addalbum.AddNewAlbumActivity;
import com.northcoders.record_shop_frontend.ui.mainactivity.MainActivityViewModel;

import java.util.ArrayList;
import java.util.Arrays;

public class UpdateAlbumActivity extends AppCompatActivity {

    private Album album;
    private Artist artist;
    private Publisher publisher;
    private String genreFromSpinner;
    private ActivityUpdateAlbumBinding activityUpdateAlbumBinding;
    private UpdateAlbumClickHandlers updateAlbumClickHandlers;
    public static final String ALBUM_KEY = "album";
    public static final String ARTIST_KEY = "artist";
    public static final String PUBLISHER_KEY = "publisher";

    @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_album);

        album = getIntent().getParcelableExtra(ALBUM_KEY, Album.class);
        artist = getIntent().getParcelableExtra(ARTIST_KEY, Artist.class);
        publisher = getIntent().getParcelableExtra(PUBLISHER_KEY, Publisher.class);

        activityUpdateAlbumBinding = DataBindingUtil.setContentView(this, R.layout.activity_update_album);

        String[] genres = getResources().getStringArray(R.array.genres);
        ArrayList<String> genresArrayList = new ArrayList<>(Arrays.asList(genres));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genresArrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner genre_dropdown = (Spinner) findViewById(R.id.genre);
        genre_dropdown.setAdapter(adapter);
        genre_dropdown.setSelection(adapter.getPosition(album.getGenre()));

        genre_dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                genreFromSpinner = adapterView.getItemAtPosition(i).toString();

                updateAlbumClickHandlers.setGenreFromSpinner(genreFromSpinner);

                if (genreFromSpinner != null) {
                    Toast.makeText(UpdateAlbumActivity.this, (CharSequence) genreFromSpinner,
                            Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(UpdateAlbumActivity.this, "Selected",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }


        });

        MainActivityViewModel viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        activityUpdateAlbumBinding.setAlbum(album);
        activityUpdateAlbumBinding.setArtist(artist);
        activityUpdateAlbumBinding.setPublisher(publisher);


        updateAlbumClickHandlers = new UpdateAlbumClickHandlers(album, artist, publisher, genreFromSpinner, viewModel, this);

        activityUpdateAlbumBinding.setClickhandler(updateAlbumClickHandlers);

    }
}