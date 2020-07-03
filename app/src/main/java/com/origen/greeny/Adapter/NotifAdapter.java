package com.origen.greeny.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.origen.greeny.Model.NotifModel;
import com.origen.greeny.R;

import java.util.List;

public class NotifAdapter extends RecyclerView.Adapter<NotifAdapter.NotifViewHolder> {

    private Context context;
    private List<NotifModel> list;

    public NotifAdapter(Context context, List<NotifModel> list) {
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public NotifViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notif_layout,parent,false);
        return new NotifViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NotifViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.desc.setText(list.get(position).getDesc());
        if(list.get(position).isAlarmed()){
            holder.check.setChecked(false);
        }else {
            holder.check.setChecked(true);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class NotifViewHolder extends RecyclerView.ViewHolder{

        private TextView name,desc;
        private Switch check;

        public NotifViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.notif_name);
            desc = itemView.findViewById(R.id.notif_desc);
            check = itemView.findViewById(R.id.notif_check);
        }
    }
}
