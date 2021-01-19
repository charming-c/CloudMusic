package com.example.cloudmusic;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public Repo repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);

        Call<Repo> call = api.getRepo("liuyuxin-cloud");
        call.enqueue(new Callback<Repo>() {
            @Override
            public void onResponse(Call<Repo> call, Response<Repo> response) {
                repo = response.body();
                Toast.makeText(MainActivity.this,"succeed",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<Repo> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(MainActivity.this,"error",Toast.LENGTH_LONG).show();
            }
        });
    }
}