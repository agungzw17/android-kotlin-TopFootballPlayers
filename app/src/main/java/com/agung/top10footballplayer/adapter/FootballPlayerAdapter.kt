package com.agung.top10footballplayer.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.agung.top10footballplayer.DetailActivity
import com.agung.top10footballplayer.R
import com.agung.top10footballplayer.model.FootballPlayer
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class FootballPlayerAdapter(private val listFootballPlayer: ArrayList<FootballPlayer>) : RecyclerView.Adapter<FootballPlayerAdapter.CardViewViewHolder>() {
    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(
            R.layout.item_cardview_football_player,
            parent,
            false
        )
        return CardViewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        val hero = listFootballPlayer[position]
        Glide.with(holder.itemView.context)
            .load(hero.photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)
        holder.tvName.text = hero.name
        holder.tvNumber.text = hero.numberTopPlayer.toString()

        val mContext = holder.itemView.context
        holder.btnDetail.setOnClickListener {
            val moveDetailActivity = Intent(mContext, DetailActivity::class.java)
            moveDetailActivity.putExtra(DetailActivity.EXTRA_FOOTBALL_PLAYER, listFootballPlayer[position])
            mContext.startActivity(moveDetailActivity)
        }

        holder.itemView.setOnClickListener {
            onItemClickCallback.onItemClicked(listFootballPlayer[holder.adapterPosition])
        }
    }

    override fun getItemCount(): Int {
        return listFootballPlayer.size
    }

    inner class CardViewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvNumber: TextView = itemView.findViewById(R.id.tv_item_number)
        var btnDetail: Button = itemView.findViewById(R.id.btn_detail)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: FootballPlayer)
    }
}