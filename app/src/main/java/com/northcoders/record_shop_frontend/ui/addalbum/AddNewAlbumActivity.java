package com.northcoders.record_shop_frontend.ui.addalbum;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.northcoders.record_shop_frontend.R;
import com.northcoders.record_shop_frontend.databinding.ActivityAddNewAlbumBinding;
import com.northcoders.record_shop_frontend.model.Album;
import com.northcoders.record_shop_frontend.model.Artist;
import com.northcoders.record_shop_frontend.model.Publisher;
import com.northcoders.record_shop_frontend.ui.mainactivity.MainActivityViewModel;

import java.util.ArrayList;
import java.util.Arrays;

public class AddNewAlbumActivity extends AppCompatActivity {

    private ActivityAddNewAlbumBinding newAlbumBinding;
    private AddAlbumClickHandlers addAlbumClickHandlers;
    private Album album;
    private Artist artist;
    private Publisher publisher;
    private String genreFromSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_new_album);

        album = new Album();
        album.setName("");
        artist = new Artist();
        artist.setArtistId(null);
        artist.setName("");
        publisher = new Publisher();
        publisher.setPublisherId(null);
        publisher.setName("");

        newAlbumBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_new_album);

        String[] genres = getResources().getStringArray(R.array.genres);
        ArrayList<String> genresArrayList = new ArrayList<>(Arrays.asList(genres));

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genresArrayList);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner genre_dropdown = (Spinner) findViewById(R.id.genre);
        genre_dropdown.setAdapter(adapter);


        genre_dropdown.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                genreFromSpinner = adapterView.getItemAtPosition(i).toString();

                addAlbumClickHandlers.setGenreFromSpinner(genreFromSpinner);

                if (genreFromSpinner != null) {
                    Toast.makeText(AddNewAlbumActivity.this, (CharSequence) genreFromSpinner,
                            Toast.LENGTH_SHORT).show();
                }
                Toast.makeText(AddNewAlbumActivity.this, "Selected",
                        Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


             MainActivityViewModel viewModel = new ViewModelProvider(this)
                    .get(MainActivityViewModel.class);

            album.setGenre(genreFromSpinner);
            newAlbumBinding.setAlbum(album);
            newAlbumBinding.setArtist(artist);
            newAlbumBinding.setPublisher(publisher);
//            genreFromSpinner = newAlbumBinding.genre.getItemAtPosition(genre_dropdown.getSelectedItemPosition()).toString();



            addAlbumClickHandlers = new AddAlbumClickHandlers(album, artist, publisher, genreFromSpinner, this, viewModel);

            newAlbumBinding.setClickhandler(addAlbumClickHandlers);


    }
}




