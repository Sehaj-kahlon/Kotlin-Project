package com.example.kotlinproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.widget.DecorToolbar
import com.example.kotlinproject.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class MainActivity : AppCompatActivity() {
    //toolbar
    private lateinit var appToolbar: Toolbar
//    private lateinit var textView: TextView
    private lateinit var relativeLayout: RelativeLayout
    //bottom nav bar
    private lateinit var binding: ActivityMainBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //toolbar
        appToolbar = findViewById(R.id.Toolbar)
        appToolbar.setTitle("")
        setSupportActionBar(appToolbar)
        //explore text
       // textView = findViewById(R.id.explore)

        relativeLayout = findViewById(R.id.Relative)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //data from Retrofit API
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                val dataList = response.body()?.data
                val textView = findViewById<TextView>(R.id.helloText)
                textView.text = dataList.toString()
                Log.d("TAG: onResponse", "onResponse: "+ response.body())
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("TAG: onFailure", "onFailure: "+ t.message)
            }
        })


    }
}