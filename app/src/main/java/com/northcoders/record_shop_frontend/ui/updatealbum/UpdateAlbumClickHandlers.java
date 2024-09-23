package com.northcoders.record_shop_frontend.ui.updatealbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import com.northcoders.record_shop_frontend.model.Album;
import com.northcoders.record_shop_frontend.model.Artist;
import com.northcoders.record_shop_frontend.model.Publisher;
import com.northcoders.record_shop_frontend.ui.mainactivity.MainActivity;
import com.northcoders.record_shop_frontend.ui.mainactivity.MainActivityViewModel;

public class UpdateAlbumClickHandlers {

    Album album;
    private Artist artist;
    private Publisher publisher;
    MainActivityViewModel mainActivityViewModel;
    Long albumId;
    Context context;
    private String genreFromSpinner;

    public UpdateAlbumClickHandlers(Album album, Artist artist, Publisher publisher, String genreFromSpinner, MainActivityViewModel mainActivityViewModel, Context context) {
        this.album = album;
        this.artist = artist;
        this.publisher = publisher;
        this.genreFromSpinner = genreFromSpinner;
        this.mainActivityViewModel = mainActivityViewModel;
        this.context = context;
    }

    public void onBackClicked(View view) {

        Intent intent = new Intent(view.getContext(), MainActivity.class);
        context.startActivity(intent);
    }

    public void onSaveClicked(View view) {

        if (album.getName().isBlank() || album.getArtist().getName().isBlank() || album.getPublisher().getName().isBlank() || album.getReleaseDate().isBlank() || album.getGenre() == null) {
            Toast.makeText(context, "No fields can be left empty", Toast.LENGTH_LONG).show();
        } else {

            Intent intent = new Intent(view.getContext(), MainActivity.class);

            Artist newArtist = new Artist();
            newArtist.setArtistId(null);
            newArtist.setName(album.getArtist().getName());

            Publisher newPublisher = new Publisher();
            newPublisher.setPublisherId(null);
            newPublisher.setName(album.getPublisher().getName());


            Album newAlbum = new Album(
                    album.getAlbumId(),
                    album.getName(),
                    newArtist,
                    newPublisher,
                    album.getReleaseDate(),
                    genreFromSpinner
            );

            mainActivityViewModel.updateAlbum(newAlbum.getAlbumId(), newAlbum);

            context.startActivity(intent);

        }
    }

    public void onDeleteClicked(View view) {

        Intent intent = new Intent(view.getContext(), MainActivity.class);
        mainActivityViewModel.deleteAlbum(album.getAlbumId());
        context.startActivity(intent);
    }




}
