package com.chantika.taritradisionaljateng;

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

import java.util.ArrayList;

public class CardTariAdapter extends RecyclerView.Adapter<CardTariAdapter.ListViewHolder> {
    private ArrayList<Tari> listTari;
    private Context context;

    public CardTariAdapter(Context context, ArrayList<Tari> listTari){
        this.listTari = listTari;
        this.context = context;
    }

    @NonNull
    @Override
    public CardTariAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_tari, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTariAdapter.ListViewHolder holder, int position) {
        final Tari tari = listTari.get(position);
        Glide.with(holder.itemView.getContext())
                .load(tari.getPhoto())
                .apply(new RequestOptions().fitCenter())
                .into(holder.imgPhoto);

        holder.tvName.setText(tari.getName());
        holder.tvDesc.setText(tari.getDescription());
        holder.cv.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent detail = new Intent(context, DetailListTari.class);
                detail.putExtra("tari_id", tari.getId());
                context.startActivity(detail);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTari.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDesc;
        CardView cv;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_tari_list);
            tvName = itemView.findViewById(R.id.name_list_tari);
            tvDesc = itemView.findViewById(R.id.desc_tari_list);
            cv = itemView.findViewById(R.id.cardview_item);
        }
    }
}
