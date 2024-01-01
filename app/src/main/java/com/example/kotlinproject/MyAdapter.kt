package com.example.kotlinproject

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import org.w3c.dom.Text

class MyAdapter(val context: Activity, val dataList: List<Item>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>(){

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    //create the view in case the layout manager fails to create view for the data
        val itemImage: ImageView
        val itemName : TextView
        val itemPrice : TextView
        val shipInfo : TextView
        init{
            itemImage = itemView.findViewById(R.id.content_blo)
            itemName = itemView.findViewById(R.id.item_no)
            itemPrice = itemView.findViewById(R.id.mrp)
            shipInfo = itemView.findViewById(R.id.shipping_info)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.cards,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
      //populate the data into the view
        val currentData = dataList[position]

        holder.itemName.text= currentData.name
        Picasso.get().load(currentData.image).into(holder.itemImage);
        holder.shipInfo.text = currentData.extra
        holder.itemPrice.text = currentData.price
    }
}