package com.sitthipon.kingpowertest.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sitthipon.kingpowertest.R
import com.sitthipon.kingpowertest.model.Photos
import com.sitthipon.kingpowertest.view.Detail
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_rv_detail.view.*

class MainAdapter(private val context: Context , private val photosList: MutableList<Photos>)
    : RecyclerView.Adapter<MainAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_rv_detail, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return photosList.size
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        Picasso.get().load(photosList[position].thumbnailUrl).into(holder.getImg)
        holder.getNameTxt.text = photosList[position].title
        holder.itemView.setOnClickListener {
            val intent = Intent(context, Detail::class.java)
            intent.putExtra("IMAGE",photosList[position].thumbnailUrl)
            context.startActivity(intent)
        }




    }

    class ViewHolder(itemListView : View): RecyclerView.ViewHolder(itemListView){
        val getNameTxt = itemListView.nameTxt
        val getImg = itemListView.Img
    }
}