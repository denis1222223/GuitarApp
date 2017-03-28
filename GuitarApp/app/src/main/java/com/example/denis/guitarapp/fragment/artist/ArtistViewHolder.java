package com.example.denis.guitarapp.fragment.artist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.denis.guitarapp.R;
import com.example.denis.guitarapp.model.Artist;

public class ArtistViewHolder extends RecyclerView.ViewHolder {
    final View mView;
    final TextView mIdView;
    final TextView mContentView;
    Artist mItem;

    ArtistViewHolder(View view) {
        super(view);
        mView = view;
        mIdView = (TextView) view.findViewById(R.id.id);
        mContentView = (TextView) view.findViewById(R.id.content);
    }
}

