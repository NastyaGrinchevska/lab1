package com.example.lab_1

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity: AppCompatActivity() {

    companion object {
        const val FOX_KEY = "FOX_KEY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val fox = intent.getSerializableExtra(FOX_KEY) as Fox
        findViewById<ImageView>(R.id.foxImageView).setImageResource(fox.imageRes)
        findViewById<TextView>(R.id.typeTextView).text = fox.type
        findViewById<TextView>(R.id.binomialNameTextView).text = fox.binomialName
        findViewById<TextView>(R.id.descriptionTextView).text = fox.description

    }
}