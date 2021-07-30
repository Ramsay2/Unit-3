package com.example.githubprofilefragment;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    @GET("/users/{user}/repos")
    Call<List<ResponseDTO>> getPost(@Path("user") String user);
}
