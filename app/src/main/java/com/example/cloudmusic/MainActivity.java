package com.example.cloudmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public List<Repo> repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(){
            @Override
            public void run() {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("https://api.github.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                API api = retrofit.create(API.class);
                Call<List<Repo>> call = api.getRepo("liuyuxin-cloud");
                call.enqueue(new Callback<List<Repo>>() {
                    @Override
                    public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                        Log.d("tag","lalaal");
                        repo = response.body();
                        Toast.makeText(MainActivity.this,"succeed",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<List<Repo>> call, Throwable t) {
                        t.printStackTrace();
                        Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();
                    }
                });
            }
        }.start();
    }
}