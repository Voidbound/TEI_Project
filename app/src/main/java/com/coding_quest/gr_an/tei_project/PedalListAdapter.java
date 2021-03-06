package com.coding_quest.gr_an.tei_project;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PedalListAdapter extends RecyclerView.Adapter<PedalListAdapter.aPedalViewHolder> {

    private Context mContext;
    private List<Pedal> pedalList;


    public PedalListAdapter(Context mContext, List<Pedal> pedalList) {
        this.mContext = mContext;
        this.pedalList = pedalList;
    }

    @NonNull
    @Override

    public aPedalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pedal_recycler_layout, parent, false);
        return new aPedalViewHolder(view);
    }

    @Override

    public void onBindViewHolder(@NonNull aPedalViewHolder holder, int position) {
        Pedal pedal = pedalList.get(position);


        Glide.with(mContext)
                .asBitmap()
                .load(pedal.getImgurl())
                .into(holder.pedalImage);

        holder.pedalName.setText(pedal.getName());
        holder.pedalEffect.setText(pedal.getEffect());

    }

    public int getItemCount() {
        return pedalList.size();
    }

    class aPedalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView pedalImage;
        TextView pedalName, pedalEffect;
        RelativeLayout pedalLayout;
        TableLayout pedalTable;


        public aPedalViewHolder(@NonNull View itemView) {
            super(itemView);

            pedalImage = itemView.findViewById(R.id.pedal_image);
            pedalName = itemView.findViewById(R.id.pedal_name);
            pedalEffect = itemView.findViewById(R.id.pedal_effect);
            pedalLayout = itemView.findViewById(R.id.pedal_list_layout);
            pedalTable = itemView.findViewById(R.id.pedal_table);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Pedal pedal = pedalList.get(getAdapterPosition());
            Intent intent = new Intent(mContext, PedalInfo.class);
            intent.putExtra("pedal", pedal);
            mContext.startActivity(intent);
        }
    }
}
