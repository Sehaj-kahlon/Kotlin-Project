package com.example.kotlinproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class Page2 : Fragment() {
    private lateinit var myRecyclerView: RecyclerView
    private lateinit var GridAdapter: gridAdapter
    private var dataList: List<Item> = emptyList()
    companion object {
        fun newInstance(dataList: List<Item>): Page2 {
            val fragment = Page2()
            fragment.dataList = dataList
            return fragment
        }
    }
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View ?{
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_page2, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager =  GridLayoutManager(context, 3)
        myRecyclerView = view.findViewById(R.id.recyclerView2)
        myRecyclerView.layoutManager = layoutManager
        myRecyclerView.setHasFixedSize(true)
        GridAdapter = gridAdapter(this.requireActivity(),dataList)
        myRecyclerView.adapter = GridAdapter
    }

}