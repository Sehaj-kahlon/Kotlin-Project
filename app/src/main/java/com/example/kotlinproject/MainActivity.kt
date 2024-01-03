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
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.databinding.ActivityMainBinding
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    //toolbar
    private lateinit var appToolbar: Toolbar
   private lateinit var bottomAppBar: BottomAppBar
   private lateinit var  dataList: Data

    private lateinit var bottomNavigationView: BottomNavigationView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //toolbar
        appToolbar = findViewById(R.id.Toolbar)
        appToolbar.setTitle("")
        setSupportActionBar(appToolbar)
        bottomAppBar = findViewById(R.id.bottom_nav)
        bottomNavigationView = findViewById(R.id.bottom_menu)
        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.btn1 ->{
                    replaceFragment(Page1.newInstance(dataList.items))
                    true
                }
                R.id.btn2 ->{
                    replaceFragment(Page2.newInstance(dataList.items))
                    true
                }
                else ->{
                    false
                }
            }
           }
        replaceFragment(Page1 ())
        //data from Retrofit API
        val retrofitBuilder = Retrofit.Builder()
            .baseUrl("https://run.mocky.io/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiInterface::class.java)
        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                dataList = response.body()?.data!!
               Log.d("TAG: onResponse", "onResponse: "+ response.body())
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                Log.d("TAG: onFailure", "onFailure: "+ t.message)
            }
        })
    }
    //replace fragmanets
    private fun replaceFragment(fragment : Fragment){
        val fragmnentManager = supportFragmentManager
        val fragmentTransaction = fragmnentManager.beginTransaction()
        fragmentTransaction.replace(R.id.Frame,fragment)
        fragmentTransaction.commit()
    }
}