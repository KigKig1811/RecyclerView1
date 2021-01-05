package com.kig2.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ShopAdapter extends RecyclerView.Adapter<ShopAdapter.ShopViewHolder> {

    List<Shop> mShopList;

    public ShopAdapter(List<Shop> mShopList) {
        this.mShopList = mShopList;
    }

    @NonNull
    @Override
    public ShopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.item_shop, parent, false);

        return new ShopViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ShopViewHolder holder, int position) {
        Shop shop = mShopList.get(position);
        if(shop.getOnline() != null){
            holder.mImgOnLine.setImageResource(R.drawable.ic_online);
        }else{
            holder.mImgOnLine.setImageResource(R.drawable.ic_offline);
        }

        holder.mImgBackground.setImageResource(shop.getImage());
        holder.mTvName.setText(shop.getName());
        holder.mTvCountShop.setText(shop.getCountShops()+"địa điểm");
        holder.mTvSaleOf.setText(shop.getSaleOf()+"k");
        holder.mTvPrice.setText("Giá"+shop.getPrice()+"k");
        holder.mTvPromotion.setText(shop.getPromotion());

    }

    @Override
    public int getItemCount() {

        return mShopList != null ? mShopList.size() : 0;
    }

    class ShopViewHolder extends RecyclerView.ViewHolder{
        ImageView mImgOnLine,mImgBackground;
        TextView mTvName,mTvCountShop,mTvSaleOf,mTvPrice,mTvPromotion;

        public ShopViewHolder(@NonNull View itemView) {
            super(itemView);

            mImgOnLine = itemView.findViewById(R.id.imageOnline);
            mImgBackground = itemView.findViewById(R.id.imageBackground);
            mTvName = itemView.findViewById(R.id.textViewNameShop);
            mTvCountShop = itemView.findViewById(R.id.textViewCountShops);
            mTvSaleOf = itemView.findViewById(R.id.textViewSaleOff);
            mTvPrice = itemView.findViewById(R.id.textViewPrice);
            mTvPromotion = itemView.findViewById(R.id.textViewPromtion);

        }
    }
}
