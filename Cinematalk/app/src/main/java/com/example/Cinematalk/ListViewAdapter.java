package com.example.Cinematalk;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;


public class ListViewAdapter extends ArrayAdapter<MoviesItem> {

    private List<MoviesItem> moviesItemList;

    private Context context;

    public ListViewAdapter(List<MoviesItem> moviesItemList, Context context) {
        super(context, R.layout.list_item, moviesItemList);
        this.moviesItemList = moviesItemList;
        this.context = context;
    }



    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View listViewItem = inflater.inflate(R.layout.list_item, null, true);

        TextView tvJudul = listViewItem.findViewById(R.id.tvJudul);
        TextView tvSynopsis = listViewItem.findViewById(R.id.tvSynopsis);
        TextView tvDirectors = listViewItem.findViewById(R.id.tvDirectors);
        TextView tvWriters = listViewItem.findViewById(R.id.tvWriters);
        ImageView imgVIew = listViewItem.findViewById(R.id.Poster);

        MoviesItem moviesItem = moviesItemList.get(position);

        tvJudul.setText(moviesItem.getJudul());
        tvSynopsis.setText(moviesItem.getSynopsis());
        tvDirectors.setText(moviesItem.getDirector());
        tvWriters.setText(moviesItem.getWriters());
        Glide.with(context).load(moviesItem.getPoster()).into(imgVIew);
        return listViewItem;
    }
}