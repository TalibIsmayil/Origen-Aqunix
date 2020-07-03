package com.origen.greeny.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.origen.greeny.Model.IotModel;
import com.origen.greeny.R;

import java.util.List;

public class IotAdapter extends RecyclerView.Adapter<IotAdapter.IotViewHolder> {

    private Context context;
    private List<IotModel> list;

    public IotAdapter(Context context, List<IotModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public IotViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.iot_layout,parent,false);
        return new IotViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull IotViewHolder holder, int position) {
        holder.name.setText(list.get(position).getName());
        holder.desc.setText(list.get(position).getMac());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class IotViewHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView desc;

        public IotViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.iot_name);
            desc = itemView.findViewById(R.id.iot_mac);
        }
    }
}
