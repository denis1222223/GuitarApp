package com.example.denis.guitarapp.fragment.song;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.denis.guitarapp.R;
import com.example.denis.guitarapp.api.SongApiService;
import com.example.denis.guitarapp.fragment.OnAdapterNotification;
import com.example.denis.guitarapp.fragment.song.filter.Filter;
import com.example.denis.guitarapp.model.Song;
import com.example.denis.guitarapp.utils.JSON;

import org.json.JSONArray;

import java.util.List;

public class SongRecyclerViewAdapter extends RecyclerView.Adapter<SongViewHolder> implements OnAdapterNotification {

    private List<Song> songs;

    public SongRecyclerViewAdapter(Filter filter) {
        fetchSongs();
    }

    private void fetchSongs() {
        SongApiService.getInstance().getAllSongs(this);
    }

    @Override
    public void onDataResponse(JSONArray jsonArray) {
        songs = JSON.toList(jsonArray, Song.class);
        notifyDataSetChanged();
    }

    @Override
    public SongViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_list_item, parent, false);
        return new SongViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SongViewHolder holder, int position) {
        if (songs == null) {
            return;
        }

        Song song = songs.get(position);
        System.out.println(song);
        holder.mItem = song;
        holder.mArtistIdView.setText(String.valueOf(song.artistId));
        holder.mDateView.setText(song.date.toString());
        holder.mNameView.setText(song.name);
        holder.mLikesCountView.setText(String.valueOf(song.likesCount));
    }

    @Override
    public int getItemCount() {
        if (songs != null) {
            return songs.size();
        } else {
            return 1;
        }
    }
}
