package com.example.cloudmusic.social;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.proto.ProtoOutputStream;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.cloudmusic.R;

public class SocialFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        @SuppressLint("InflateParams")
        View view = inflater.inflate(R.layout.fragment_social, null);
        return view;
    }
}
