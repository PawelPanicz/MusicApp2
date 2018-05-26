package com.example.stud.musicapp.topsongs;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.stud.musicapp.R;
import com.example.stud.musicapp.api.TrendingSingle;

import java.util.List;

/**
 * Created by W59737 on 2018-05-26.
 */

public class TopSongsAdapter extends RecyclerView.Adapter<TopSongsAdapter.TopSongsViewHolder> {

    List<TrendingSingle> singles;

    public TopSongsAdapter (List<TrendingSingle> singles){
        this.singles = singles;
    }

    @Override
    public TopSongsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater. from (parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_top_songs , parent, false );
        return new TopSongsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopSongsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return singles == null ? 0 : singles.size();
    }

    public class TopSongsViewHolder extends RecyclerView.ViewHolder {

        LinearLayout llContainer;
        TextView tvPlace;
        TextView tvTrack;
        TextView tvArtist;
        TextView tvAlbum;


        public TopSongsViewHolder(View itemView) {
            super(itemView);
            llContainer = itemView.findViewById(R.id.llContainer);
            tvPlace = itemView.findViewById(R.id.tvPlace);
            tvTrack = itemView.findViewById(R.id.tvTrack);
            tvArtist = itemView.findViewById(R.id.tvTrack);
            tvAlbum = itemView.findViewById(R.id.tvAlbum);
        }
    }
}
