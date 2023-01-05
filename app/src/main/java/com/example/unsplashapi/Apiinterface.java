package com.example.unsplashapi;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface Apiinterface {
    @Headers("Authorization: Client-ID "+"LTKFq44CGFZUPRqgAU0kOSQe4OBMZQXxB07Ho9J1xUE")
    @GET("/photos")
    Call<List<ImageModel>> getImages(
            @Query("page") int page,
            @Query("per_page") int perPage

    );

    @Headers("Authorization: Client-ID "+"LTKFq44CGFZUPRqgAU0kOSQe4OBMZQXxB07Ho9J1xUE")
    @GET("/search/photos")
    Call<SearchModel> searchImages(
            @Query("query") String query
    );

}
