package com.northcoders.record_shop_frontend.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.northcoders.record_shop_frontend.R;
import com.northcoders.record_shop_frontend.model.Album;
import com.northcoders.record_shop_frontend.model.Artist;
import com.northcoders.record_shop_frontend.model.Publisher;
import com.northcoders.record_shop_frontend.ui.mainactivity.MainActivity;
import com.northcoders.record_shop_frontend.ui.mainactivity.MainActivityViewModel;

public class AddAlbumClickHandlers {

    private Album album;
    private Artist artist;
    private Publisher publisher;
    private Context context;
    private MainActivityViewModel mainActivityViewModel;
    private String genreFromSpinner;

    public AddAlbumClickHandlers(Album album, Artist artist, Publisher publisher, String genreFromSpinner, Context context, MainActivityViewModel mainActivityViewModel) {
        this.album = album;
        this.artist = artist;
        this.publisher = publisher;
        this.genreFromSpinner = genreFromSpinner;
        this.context = context;
        this.mainActivityViewModel = mainActivityViewModel;
            }

    public void setGenreFromSpinner(String genreFromSpinner) {
        this.genreFromSpinner = genreFromSpinner;
    }

    public void onBackClicked(View view) {

        Intent intent = new Intent(view.getContext(), MainActivity.class);
        context.startActivity(intent);
    }

    public void onSaveClicked(View view) {

        if (album.getName().isBlank() || artist.getName().isBlank() || publisher.getName().isBlank() || album.getReleaseDate().isBlank() || genreFromSpinner.isBlank()) {
            Toast.makeText(context, "No fields can be left empty", Toast.LENGTH_LONG).show();
        } else {

            Intent intent = new Intent(view.getContext(), MainActivity.class);

            Artist newArtist = new Artist();
            newArtist.setArtistId(null);
            newArtist.setName(artist.getName());

            Publisher newPublisher = new Publisher();
            newPublisher.setPublisherId(null);
            newPublisher.setName(publisher.getName());


            Album newAlbum = new Album(
                    album.getAlbumId(),
                    album.getName(),
                    newArtist,
                    newPublisher,
                    album.getReleaseDate(),
                    genreFromSpinner
            );

            mainActivityViewModel.postAlbum(newAlbum);

            context.startActivity(intent);

        }
    }
}
