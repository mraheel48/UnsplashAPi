package com.example.unsplashapi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiUtilities {

    public static final String BASE_URL = "https://api.unsplash.com";
    public static final String API_KEY = "LTKFq44CGFZUPRqgAU0kOSQe4OBMZQXxB07Ho9J1xUE";

    public static Retrofit retrofit = null;

    public static Apiinterface getApiInterface() {
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(Apiinterface.class);
    }

}
