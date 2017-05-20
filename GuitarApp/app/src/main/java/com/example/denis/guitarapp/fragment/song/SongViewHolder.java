package com.example.denis.guitarapp.fragment.song;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.denis.guitarapp.R;
import com.example.denis.guitarapp.model.Artist;
import com.example.denis.guitarapp.model.Song;

public class SongViewHolder extends RecyclerView.ViewHolder {
    final View mView;
    final TextView mArtistIdView;
    final TextView mLikesCountView;
    final TextView mDateView;
    final TextView mNameView;
    Song mItem;

    public SongViewHolder(View view) {
        super(view);
        mView = view;
        mArtistIdView = (TextView)view.findViewById(R.id.song__artistId);
        mLikesCountView = (TextView)view.findViewById(R.id.song__likesCount);
        mDateView = (TextView)view.findViewById(R.id.song__date);
        mNameView = (TextView)view.findViewById(R.id.song__name);
    }
}
