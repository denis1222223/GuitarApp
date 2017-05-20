package com.example.denis.guitarapp.fragment.artist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.denis.guitarapp.R;
import com.example.denis.guitarapp.api.ArtistApiService;
import com.example.denis.guitarapp.fragment.OnAdapterNotification;
import com.example.denis.guitarapp.model.Artist;
import com.example.denis.guitarapp.utils.JSON;

import org.json.JSONArray;

import java.util.List;

public class ArtistRecyclerViewAdapter extends RecyclerView.Adapter<ArtistViewHolder> implements OnAdapterNotification {

    private List<Artist> artists;
    private final ArtistListInteractionListener listener;

    public ArtistRecyclerViewAdapter(ArtistListInteractionListener listener) {
        fetchArtists();
        this.listener = listener;
    }

    private void fetchArtists() {
        ArtistApiService.getInstance().getAllArtists(this);
    }

    @Override
    public void onDataResponse(JSONArray jsonArray) {
        artists = JSON.toList(jsonArray, Artist.class);
        notifyDataSetChanged();
    }

    @Override
    public ArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.artist_list_item, parent, false);
        return new ArtistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ArtistViewHolder holder, int position) {
        if (artists == null) {
            return;
        }

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
        if (artists != null) {
            return artists.size();
        } else {
            return 1;
        }
    }
}
