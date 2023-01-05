package com.example.unsplashapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.unsplashapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)

        mainBinding.button.setOnClickListener {
            ApiUtilities.getApiInterface().getImages(30, 10)
                .enqueue(object : Callback<List<ImageModel>> {
                    override fun onResponse(
                        call: Call<List<ImageModel>>,
                        response: Response<List<ImageModel>>
                    ) {

                        if (response.body() != null) {
                            Log.d("myRetro", "${response.body()}")
                        }

                    }

                    override fun onFailure(call: Call<List<ImageModel>>, t: Throwable) {
                        Log.d("myRetro", "onFailure")
                    }

                })
        }

    }
}