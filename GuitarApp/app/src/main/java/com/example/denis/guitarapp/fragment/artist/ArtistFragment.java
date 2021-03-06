package com.example.denis.guitarapp.fragment.artist;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.denis.guitarapp.R;
import com.example.denis.guitarapp.model.Artist;

public class ArtistFragment extends Fragment implements ArtistListInteractionListener {

    public ArtistFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.artist_list, container, false);

        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));

            recyclerView.setAdapter(new ArtistRecyclerViewAdapter(this));
        }
        return view;
    }

    @Override
    public void onListFragmentClick(Artist artist) {
        Toast.makeText(this.getContext(), artist.toString(), Toast.LENGTH_SHORT).show();
    }
}

