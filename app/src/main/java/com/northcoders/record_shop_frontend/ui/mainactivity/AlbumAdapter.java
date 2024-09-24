package com.northcoders.record_shop_frontend.ui.mainactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.northcoders.record_shop_frontend.R;
import com.northcoders.record_shop_frontend.databinding.AlbumItemBinding;
import com.northcoders.record_shop_frontend.model.Album;

import java.util.ArrayList;
import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    List<Album> albumList;
    Context context;
    RecyclerViewInterface recyclerViewInterface;

    public AlbumAdapter(List<Album> albumList, Context context, RecyclerViewInterface recyclerViewInterface) {
        this.albumList = albumList;
        this.context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        AlbumItemBinding albumItemBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.album_item, parent, false);

        return new AlbumViewHolder(albumItemBinding, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {

        Album album = albumList.get(position);
        holder.albumItemBinding.setAlbum(album);

    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public static class AlbumViewHolder extends RecyclerView.ViewHolder {

        private AlbumItemBinding albumItemBinding;
        private RecyclerViewInterface recyclerViewInterface;

        public AlbumViewHolder (AlbumItemBinding albumItemBinding, RecyclerViewInterface recyclerViewInterface) {
            super(albumItemBinding.getRoot());
            this.albumItemBinding = albumItemBinding;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (recyclerViewInterface != null) {
                        int position = getAdapterPosition();

                        if (position != RecyclerView.NO_POSITION) {
                            recyclerViewInterface.onItemClick(position);
                        }
                    }
                }
            });
        }

    }

    public void setFilteredList (ArrayList<Album> filteredAlbumList) {

        this.albumList = filteredAlbumList;
        notifyDataSetChanged();

    }
}
