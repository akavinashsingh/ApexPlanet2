package com.apexplanet.internshipapp.network;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {
    @GET("users/{id}")
    Call<User> getUser(@Path("id") int userId);

    @GET("posts")
    Call<List<Post>> getPosts();

    @POST("users")
    Call<User> createUser(@Body User user);

    @POST("posts")
    Call<Post> createPost(@Body Post post);
}