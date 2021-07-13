package com.example.android.tourguide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

/*
categories: sites, clubs, restaurants
each category includes 3 entries with a picture of each place
information provided for each list item:
opening hours
public transportation
address
short description

 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find TextView of the sites category and set listener to open the sites activity
        val textViewSites = findViewById<TextView>(R.id.text_view_sites)
        textViewSites.setOnClickListener {
            val i = Intent(this, SitesActivity::class.java)
            startActivity(i)
        }
    }
}