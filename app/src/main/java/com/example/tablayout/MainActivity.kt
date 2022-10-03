package com.example.tablayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tablayout.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val fragList = listOf(
        Fragment1.newInstance(),
        Fragment2.newInstance(),
        Fragment3.newInstance()
    )
    private val fragItemTitles = listOf(
        "Item 1",
        "Item 2",
        "Item 3"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = VpAdapter(this, fragList)
        binding.vp2.adapter = adapter

        TabLayoutMediator(binding.tb, binding.vp2){
            tab, pos -> tab.text = fragItemTitles[pos]
        }.attach()
    }
}