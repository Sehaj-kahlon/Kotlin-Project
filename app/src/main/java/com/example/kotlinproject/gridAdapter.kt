package com.example.kotlinproject

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class gridAdapter(val context: Activity, val dataList: List<Item>):
    RecyclerView.Adapter<gridAdapter.GridViewHolder>(){
        class GridViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
            val itemImage: ImageView
            val itemName : TextView
            val itemPrice : TextView
            //initializer
            init{
                itemImage = itemView.findViewById(R.id.grid_img)
                itemName = itemView.findViewById(R.id.grid_item)
                itemPrice = itemView.findViewById(R.id.grid_mrp)
            }
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.grid,parent,false)
        return GridViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {
        //populate the data into the view
        val currentData = dataList[position]

        holder.itemName.text= currentData.name
        Picasso.get().load(currentData.image).into(holder.itemImage);
        holder.itemPrice.text = currentData.price
    }
}
