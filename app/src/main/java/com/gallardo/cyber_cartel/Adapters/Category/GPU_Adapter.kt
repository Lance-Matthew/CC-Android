package com.gallardo.cyber_cartel.Adapters.Category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.gallardo.cyber_cartel.Adapters.My_Purchase_All_Adapter
import com.gallardo.cyber_cartel.Category_Gpu
import com.gallardo.cyber_cartel.DataClass.Category.GPU_DC
import com.gallardo.cyber_cartel.DataClass.My_Purchase_All_DC
import com.gallardo.cyber_cartel.My_Purchase_All
import com.gallardo.cyber_cartel.R

class GPU_Adapter (private val getActivity: Category_Gpu, private val allItemList: List<GPU_DC>):
    RecyclerView.Adapter<GPU_Adapter.MyViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GPU_Adapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_holder, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: GPU_Adapter.MyViewHolder, position: Int) {
        holder.tvProductPrice.text = allItemList[position].Product_Price.toString()
        holder.tvProductInfo.text = allItemList[position].Product_Info
        holder.ivProductImage.setImageResource(allItemList[position].Product_Image)

        holder.cardView.setOnClickListener{
            Toast.makeText(getActivity, allItemList[position].Product_Info, Toast.LENGTH_LONG).show()
        }
    }

    override fun getItemCount(): Int {
        return allItemList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val tvProductInfo : TextView = itemView.findViewById(R.id.tv_product_title)
        val tvProductPrice : TextView = itemView.findViewById(R.id.tv_product_title)
        val ivProductImage : ImageView = itemView.findViewById(R.id.iv_product_Image)
        val cardView : CardView = itemView.findViewById(R.id.product_cardView)

    }
}