package com.agung.top10footballplayer

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.agung.top10footballplayer.model.FootballPlayer
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_FOOTBALL_PLAYER = "EXTRA_FOOTBALL_PLAYER"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val actionbar = supportActionBar
        actionbar!!.title = "Detail Footbal Player"
        actionbar.setDisplayHomeAsUpEnabled(true)

        val imgPhoto: ImageView = findViewById(R.id.img_item_photo)
        val tvName: TextView = findViewById(R.id.item_name)
        val tvCountry:TextView = findViewById(R.id.item_country)
        val tvClub:TextView = findViewById(R.id.item_club)
        val tvRating:TextView = findViewById(R.id.item_rating)
        val tvDescription:TextView = findViewById(R.id.item_description)

        val footballPlayer = intent.getParcelableExtra(EXTRA_FOOTBALL_PLAYER) as FootballPlayer
        tvName.text = footballPlayer.name
        tvCountry.text = footballPlayer.country
        tvClub.text = footballPlayer.club
        tvRating.text = footballPlayer.rating.toString()
        tvDescription.text = footballPlayer.description
        Glide.with(this).load(footballPlayer.photo).into(imgPhoto)

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}