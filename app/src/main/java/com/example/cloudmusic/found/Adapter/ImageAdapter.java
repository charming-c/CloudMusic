package com.example.cloudmusic.found.Adapter;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public class ImageAdapter extends BannerAdapter<Integer,ImageAdapter.InnerHolder> {
    public ImageAdapter(List<Integer> datas) {
        super(datas);
        Log.d("banner","BannerAdapter" + datas.get(1));
    }

    @Override
    public ImageAdapter.InnerHolder onCreateHolder(ViewGroup parent, int viewType) {

        ImageView imageView = new ImageView(parent.getContext());
        imageView.setLayoutParams
                (new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return  new InnerHolder(imageView);

    }

    @Override
    public void onBindView(InnerHolder holder, Integer data, int position, int size) {
        holder.imageView.setImageResource(data);
    }
    public class InnerHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public InnerHolder(@NonNull ImageView itemView) {
            super(itemView);
            this.imageView = itemView;
        }
    }
}
