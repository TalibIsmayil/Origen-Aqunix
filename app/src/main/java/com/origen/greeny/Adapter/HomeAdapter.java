package com.origen.greeny.Adapter;

import android.content.Context;
import android.content.Intent;
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
import com.origen.greeny.CommentActivity;
import com.origen.greeny.Model.HomeModel;
import com.origen.greeny.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private Context context;
    private List<HomeModel> list;

    public HomeAdapter(Context context, List<HomeModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_layout,parent,false);
        return new HomeViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final HomeViewHolder holder, final int position) {
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.placeholder);

        Glide.with(context).setDefaultRequestOptions(requestOptions).load(list.get(position).getPhoto()).into(holder.profilImage);
        Glide.with(context).setDefaultRequestOptions(requestOptions).load(list.get(position).getPostPhoto()).into(holder.postImage);
        holder.name.setText(list.get(position).getUsername());
        holder.daysAgo.setText(list.get(position).getPostTime());
        holder.text.setText(list.get(position).getPostComment());

        holder.like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(position).isLiked()){
                    holder.likeButton.setImageResource(R.drawable.ic_thumb_up_blacks_24dp);
                    list.get(position).setLiked(false);
                }else {
                    holder.likeButton.setImageResource(R.drawable.ic_thumb_up_black_24dp);
                    list.get(position).setLiked(true);
                }
            }
        });

        holder.bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (list.get(position).isSaved()){
                    holder.bookmarkButton.setImageResource(R.drawable.ic_bookmark_border_black_24dp);
                    list.get(position).setSaved(false);
                }else {
                    holder.bookmarkButton.setImageResource(R.drawable.ic_bookmark_black_24dp);
                    list.get(position).setSaved(true);
                }
            }
        });

        holder.comment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, CommentActivity.class);
                context.startActivity(intent);
            }
        });

        holder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                String shareBody = list.get(position).getPostPhoto();
                String shareSub = list.get(position).getPostPhoto();
                intent.putExtra(Intent.EXTRA_SUBJECT,shareBody);
                intent.putExtra(Intent.EXTRA_TEXT,shareSub);
                context.startActivity(Intent.createChooser(intent,"Paylaş"));
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {

        private ImageView profilImage,postImage;
        private TextView name,daysAgo;
        private CardView like,comment,share,bookmark;
        private ImageView likeButton,commentButton,shareButton,bookmarkButton;
        private TextView text;

        public HomeViewHolder(@NonNull View itemView) {
            super(itemView);

            profilImage = itemView.findViewById(R.id.profile_image);
            postImage = itemView.findViewById(R.id.post_image);
            name = itemView.findViewById(R.id.name);
            daysAgo = itemView.findViewById(R.id.days_ago);
            like = itemView.findViewById(R.id.like);
            comment = itemView.findViewById(R.id.comment);
            share = itemView.findViewById(R.id.share);
            bookmark = itemView.findViewById(R.id.bookmark);
            likeButton = itemView.findViewById(R.id.like_button);
            commentButton = itemView.findViewById(R.id.comment_button);
            shareButton = itemView.findViewById(R.id.share_button);
            bookmarkButton = itemView.findViewById(R.id.bookmark_button);
            text = itemView.findViewById(R.id.text);
        }
    }
}
