package com.example.proiect;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class InfoAdapter extends RecyclerView.Adapter<InfoAdapter.InfoViewHolder>{

    private Context mCtx;
    private List<Info> infoList;

    public InfoAdapter(Context mCtx, List<Info> infoList) {
        this.mCtx = mCtx;
        this.infoList = infoList;
    }

    @Override
        public InfoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.layout_info, null);
        return new InfoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InfoViewHolder holder, int position) {
        Info info = infoList.get(position);

        //loading the image
        //Glide.with(mCtx)
          //      .load(product.getImage())
            //    .into(holder.imageView);

        holder.textViewAddress.setText(info.getAddress());
        holder.textViewCity.setText(info.getCity());
        holder.textViewCounty.setText(info.getCounty());
        holder.textViewCode.setText(String.valueOf(info.getZipCode()));
        holder.textViewDate.setText(info.getDate());
        holder.textViewUsername.setText(info.getUsername());
        holder.textViewPhone.setText(info.getPhoneNumber());
        holder.textViewFood.setText(info.getFoodLeft());
    }

    @Override
    public int getItemCount() {
        return infoList.size();
    }

    class InfoViewHolder extends RecyclerView.ViewHolder {

        TextView textViewUsername, textViewAddress, textViewCity, textViewCode, textViewCounty, textViewDate, textViewPhone, textViewFood;
        //ImageView imageView;

        public InfoViewHolder(View itemView) {
            super(itemView);

            textViewAddress = itemView.findViewById(R.id.textViewAddress);
            textViewCity = itemView.findViewById(R.id.textViewCity);
            textViewCounty = itemView.findViewById(R.id.textViewCounty);
            textViewCode = itemView.findViewById(R.id.textViewCode);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            textViewUsername = itemView.findViewById(R.id.textViewUsername);
            textViewPhone = itemView.findViewById(R.id.textViewPhone);
            textViewFood = itemView.findViewById(R.id.textViewFood);
            //imageView = itemView.findViewById(R.id.imageView);
        }
    }
}

