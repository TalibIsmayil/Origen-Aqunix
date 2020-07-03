package com.origen.greeny.Adapter;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.origen.greeny.DetailActivity;
import com.origen.greeny.Model.MyGardenModel;
import com.origen.greeny.R;

import java.util.List;

public class MyGardenAdapter extends RecyclerView.Adapter<MyGardenAdapter.MyGardenViewHolder> {

    private Context context;
    private List<MyGardenModel> list;

    public MyGardenAdapter(Context context, List<MyGardenModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyGardenViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.icons,parent,false);
        return new MyGardenViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyGardenViewHolder holder, int position) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.pexels);

        Glide.with(context).setDefaultRequestOptions(requestOptions).load(list.get(position).getImage()).into(holder.image);
        holder.name.setText(list.get(position).getName());
        holder.desc.setText(list.get(position).getDesc());
        if(position == 0){
            holder.image4.setVisibility(View.INVISIBLE);
        }else if (position == 1){
            holder.image4.setVisibility(View.INVISIBLE);
            holder.image3.setVisibility(View.INVISIBLE);
            //holder.image2.setVisibility(View.INVISIBLE);
        }else if (position == 3){
            holder.image4.setVisibility(View.INVISIBLE);
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("check","0");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyGardenViewHolder extends RecyclerView.ViewHolder{

        private ImageView image;
        private TextView name,desc;
        private CardView image1,image2,image3,image4;

        public MyGardenViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.my_garden_image);
            name = itemView.findViewById(R.id.my_name);
            desc = itemView.findViewById(R.id.my_desc);
            image1 = itemView.findViewById(R.id.image1);
            image2 = itemView.findViewById(R.id.image2);
            image3 = itemView.findViewById(R.id.image3);
            image4 = itemView.findViewById(R.id.image4);

        }
    }
}
