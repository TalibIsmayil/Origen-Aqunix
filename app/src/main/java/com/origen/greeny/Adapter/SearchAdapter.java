package com.origen.greeny.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.origen.greeny.DetailActivity;
import com.origen.greeny.Model.SearchModel;
import com.origen.greeny.R;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private Context context;
    private List<SearchModel> list;

    public SearchAdapter(Context context, List<SearchModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_layout,parent,false);
        return new SearchViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, final int position) {
        holder.name.setText(list.get(position).getPlantName());
        holder.desc.setText(list.get(position).getPlantDescription());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.pexels);

        Glide.with(context).setDefaultRequestOptions(requestOptions).load(list.get(position).getPlantPhoto()).into(holder.image);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("check",list.get(position).getId());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SearchViewHolder extends RecyclerView.ViewHolder {

        private TextView name,desc;
        private ImageView image;

        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.search_name);
            desc = itemView.findViewById(R.id.search_desc);
            image = itemView.findViewById(R.id.search_image);
        }
    }
}
