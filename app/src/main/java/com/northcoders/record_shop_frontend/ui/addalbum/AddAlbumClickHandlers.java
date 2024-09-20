package com.northcoders.record_shop_frontend.ui.addalbum;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

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

    public AddAlbumClickHandlers(Album album, Artist artist, Publisher publisher, Context context, MainActivityViewModel mainActivityViewModel) {
        this.album = album;
        this.artist = artist;
        this.publisher = publisher;
        this.context = context;
        this.mainActivityViewModel = mainActivityViewModel;
    }

    public void onBackClicked(View view) {

        Intent intent = new Intent(view.getContext(), MainActivity.class);
        context.startActivity(intent);
    }

    public void onSaveClicked(View view) {

        if (album.getName() == null || album.getArtist().getName() == null || album.getPublisher().getName() == null || album.getReleaseDate() == null || album.getGenre() == null) {
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
                    album.getGenre()
            );

            mainActivityViewModel.postAlbum(newAlbum);

            context.startActivity(intent);

        }
    }
}
