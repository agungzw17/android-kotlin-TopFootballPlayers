package com.agung.top10footballplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.agung.top10footballplayer.adapter.FootballPlayerAdapter
import com.agung.top10footballplayer.model.FootballPlayer
import com.agung.top10footballplayer.model.FootballPlayerData

class MainActivity : AppCompatActivity() {
    private lateinit var rvFootballPlayer: RecyclerView
    private var list: ArrayList<FootballPlayer> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFootballPlayer = findViewById(R.id.rv_football_player)
        rvFootballPlayer.setHasFixedSize(true)

        list.addAll(FootballPlayerData.listData)
        showRecyclerFootballPlayer()
    }

    private fun showRecyclerFootballPlayer() {
        rvFootballPlayer.layoutManager = LinearLayoutManager(this)
        val cardViewFootballPlayerAdapter = FootballPlayerAdapter(list)
        rvFootballPlayer.adapter = cardViewFootballPlayerAdapter

        cardViewFootballPlayerAdapter.setOnItemClickCallback(object : FootballPlayerAdapter.OnItemClickCallback {
            override fun onItemClicked(data: FootballPlayer) {
                val moveDetailActivity = Intent(this@MainActivity, DetailActivity::class.java)
                moveDetailActivity.putExtra(DetailActivity.EXTRA_FOOTBALL_PLAYER, data)
                startActivity(moveDetailActivity)
            }
        })
    }
}