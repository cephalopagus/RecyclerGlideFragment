package com.example.geekstest

import Cars
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class CarAdapter(clickListener: ClickListener, private val context: ListFragment, private val carList: ArrayList<Cars>):RecyclerView.Adapter<CarAdapter.MyViewHolder>(){
    class MyViewHolder (itemView:View):RecyclerView.ViewHolder(itemView){
        val img : ImageView = itemView.findViewById(R.id.image_car)
        val name : TextView = itemView.findViewById(R.id.name_car)
        val year : TextView = itemView.findViewById(R.id.year_car)
    }
    private var clickListener: ClickListener = clickListener
    interface ClickListener {
        fun clickedCar(cars: Cars){

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.car_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem = carList[position]

        Glide.with(context).load(currentItem.image).into(holder.img)
        holder.name.text = currentItem.name
        holder.year.text = currentItem.year.toString()

        holder.itemView.setOnClickListener {
            clickListener.clickedCar(currentItem)
        }
    }

    override fun getItemCount(): Int {
        return carList.size
    }

}