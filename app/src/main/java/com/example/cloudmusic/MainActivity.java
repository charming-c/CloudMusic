package com.example.cloudmusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.cloudmusic.found.FoundFragment;
import com.example.cloudmusic.myPage.MineFragment;
import com.example.cloudmusic.social.SocialFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements MainView.view {

    private ArrayList<Fragment> fragments;
    private FragmentManager fragmentManager;
    private BottomNavigationView bottomNavigationView;
    private Fragment mCurrentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.navigation);
        //bottomNavigationView.setItemIconTintList(null);
        initFragment();
        initListener();
        bottomNavigationView.setSelectedItemId(bottomNavigationView.getMenu().getItem(0).getItemId());
    }

    @Override
    public void initFragment() {
        fragments = new ArrayList<Fragment>();

        MineFragment mineFragment = new MineFragment();
        FoundFragment foundFragment = new FoundFragment();
        SocialFragment socialFragment = new SocialFragment();
        fragments.add(mineFragment);
        fragments.add(foundFragment);
        fragments.add(socialFragment);

        fragmentManager = getSupportFragmentManager();
    }

    @Override
    public void initListener() {
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.my_music:
                        showFragment(0);
                        break;
                    case R.id.found:
                        showFragment(1);
                        break;
                    case R.id.social:
                        showFragment(2);
                        break;
                    default:
                        break;
                }
                return true;
            }
        });

    }

    @Override
    public void showFragment(int position) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if(fragments != null && fragments.size() > 0){
            Fragment fragment = fragments.get(position);
            if(fragment != null && mCurrentFragment != fragment){
                if(mCurrentFragment != null){
                    transaction.hide(mCurrentFragment);
                }
                mCurrentFragment = fragment;
                if(!fragment.isAdded()){
                    transaction.add(R.id.fragment_container, fragment);
                }else{
                    transaction.show(fragment);
                }
                transaction.commit();
            }
        }
    }
}