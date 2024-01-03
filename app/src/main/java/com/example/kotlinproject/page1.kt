package com.example.kotlinproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.animation.core.animateDpAsState
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinproject.databinding.ActivityMainBinding


class Page1 : Fragment() {
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var myAdapter: MyAdapter
    private var dataList: List<Item> = emptyList()

    companion object {
        fun newInstance(dataList: List<Item>): Page1 {
            val fragment = Page1()
            fragment.dataList = dataList
            return fragment
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_page1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        myRecyclerView = view.findViewById(R.id.recyclerView1)
        myRecyclerView.layoutManager = layoutManager
        myRecyclerView.setHasFixedSize(true)
        myAdapter = MyAdapter(this.requireActivity(),dataList)
        myRecyclerView.adapter = myAdapter
    }

}