package com.example.cloudmusic;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {
    @GET("users/{user}/repos")
    Call<List<Repo>> getRepo(@Path("user")String user);
}
