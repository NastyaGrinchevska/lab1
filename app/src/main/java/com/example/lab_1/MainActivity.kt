package com.example.lab_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnFoxClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listOfFoxes = listOf(
            Fox(
                "Red Fox ",
                "Vulpes vulpes",
                "The red fox is the most common and widely recognized species of fox. It has a reddish-orange fur coat, a bushy tail, and a white underbelly. Red foxes are found in various habitats around the world, including forests, grasslands, and urban areas.",
                R.drawable.red_fox
            ),
            Fox(
                "Arctic Fox",
                "Vulpes lagopus",
                "The Arctic fox is well-adapted to survive in cold, snowy environments. It has a thick white coat that helps it camouflage in the Arctic tundra. During winter, its fur may change to a gray or brownish color. Arctic foxes are native to the Arctic regions of North America, Greenland, Europe, and Asia.",
                R.drawable.arctic_fox
            ),
            Fox(
                "Fennec Fox",
                "Vulpes zerda",
                "The fennec fox is known for its distinctive large ears, which help dissipate heat and locate prey underground. It is the smallest species of fox and inhabits the desert regions of North Africa. The fennec fox has a pale yellowish-brown coat that blends well with its sandy habitat.",
                R.drawable.fennec_fox
            )
        )
        val adapter = FoxAdapter(listOfFoxes, this)

        findViewById<RecyclerView>(R.id.recyclerView).apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            this.adapter = adapter
        }
    }

    override fun onClick(fox: Fox) {
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(DetailsActivity.FOX_KEY, fox)
        startActivity(intent)
    }
}

interface OnFoxClickListener {
    fun onClick(fox: Fox)
}