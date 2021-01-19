package com.example.cloudmusic;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {
    @GET("users/{user}/repos")
    Call<Repo> getRepo(@Path("user")String user);
}
