package com.origen.greeny.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.origen.greeny.Model.CommentModel;
import com.origen.greeny.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {

    private Context context;
    private List<CommentModel> list;

    public CommentAdapter(Context context, List<CommentModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comment_layout,parent,false);
        return new CommentViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.placeholder);

        Glide.with(context).setDefaultRequestOptions(requestOptions).load(list.get(position).getImage()).into(holder.profileImage);
        holder.name.setText(list.get(position).getName());
        holder.comment.setText(list.get(position).getComment());
        holder.days.setText(list.get(position).getDaysAgo());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder{

        private CircleImageView profileImage;
        private TextView name,comment,days;

        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);

            profileImage = itemView.findViewById(R.id.comment_image);
            name = itemView.findViewById(R.id.comment_name);
            comment = itemView.findViewById(R.id.comment_desc);
            days = itemView.findViewById(R.id.comment_days);
        }
    }
}
