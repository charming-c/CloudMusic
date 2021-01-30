package com.example.cloudmusic.found;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.cloudmusic.R;
import com.example.cloudmusic.found.Adapter.ImageAdapter;
import com.youth.banner.Banner;
import com.youth.banner.indicator.CircleIndicator;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.transformer.AlphaPageTransformer;
import com.youth.banner.transformer.DepthPageTransformer;
import com.youth.banner.transformer.ZoomOutPageTransformer;

import java.util.ArrayList;
import java.util.List;

public class FoundFragment extends Fragment implements FoundContract.FoundView {
    private List<Integer> list;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("InflateParams")
        View view = inflater.inflate(R.layout.fragment_found,null);
        Banner banner = view.findViewById(R.id.banner);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(Object data, int position) {
                Log.d("banner","click");
            }
        });
        getImageData();
        // 设置圆角，不需要card view
        banner.setBannerRound(40);
        // 设置画廊间距
        banner.setBannerGalleryEffect(0,0,5);
        banner.setAdapter(new ImageAdapter(list)).addBannerLifecycleObserver(this).setIndicator(new CircleIndicator(getContext()));

        return view;
    }

    @Override
    public void getImageData() {
        int size = 3;
        list = new ArrayList<>(size);
            list.add(R.mipmap.first);
            list.add(R.mipmap.five);
            list.add(R.mipmap.six);
    }
}
