package com.example.unsplashapi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.unsplashapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private lateinit var mainBinding: ActivityMainBinding
    var imagelist: List<ImageModel>? = null
    var searchList: ArrayList<SearchModel>? = null

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

                            imagelist = response.body()

                            if (imagelist != null) {

                                Log.d("myRetro", imagelist!![0].urls.regular)

                                Glide.with(this@MainActivity)
                                    .load(imagelist!![0].urls.regular)
                                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                                    .into(mainBinding.imageView)
                            }
                        }

                    }

                    override fun onFailure(call: Call<List<ImageModel>>, t: Throwable) {
                        Log.d("myRetro", "onFailure")
                    }

                })

            ApiUtilities.getApiInterface().searchImages("").enqueue(object : Callback<SearchModel> {
                override fun onResponse(call: Call<SearchModel>, response: Response<SearchModel>) {
                    if (response.body() != null) {
                        imagelist = response.body()!!.results
                    }
                }

                override fun onFailure(call: Call<SearchModel>, t: Throwable) {

                }

            })

        }

    }
}