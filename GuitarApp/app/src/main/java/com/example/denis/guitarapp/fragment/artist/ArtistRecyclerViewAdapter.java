package com.example.denis.guitarapp.fragment.artist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.denis.guitarapp.R;
import com.example.denis.guitarapp.model.Artist;

import java.util.List;

public class ArtistRecyclerViewAdapter extends RecyclerView.Adapter<ArtistViewHolder> {

    private final List<Artist> artists;
    private final ArtistListInteractionListener listener;

    public ArtistRecyclerViewAdapter(List<Artist> artists, ArtistListInteractionListener listener) {
        this.artists = artists;
        this.listener = listener;
    }

    @Override
    public ArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_artist, parent, false);
        return new ArtistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ArtistViewHolder holder, int position) {
        holder.mItem = artists.get(position);
        holder.mIdView.setText(String.valueOf(artists.get(position).id));
        holder.mContentView.setText(artists.get(position).name);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onListFragmentClick(holder.mItem);
            }
        });
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }
}
