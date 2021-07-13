package com.example.android.tourguide

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ListView
import android.widget.Toast

class SitesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.places_list)

        // Set data of the places list.
        val places = arrayListOf<Place>(
                Place("Fernsehturm",
                        this.getString(R.string.description_fernsehturm),
                        "Alexanderplatz",
                        "S-Bhf Alexanderplatz",
                        this.getString(R.string.no_opening_hours),
                        R.drawable.fernsehturm),
                Place("Brandenburger Tor",
                        this.getString(R.string.description_brandenburger_tor),
                        "Platz des 18. März",
                        "U-Bhf Brandenburger Tor",
                        this.getString(R.string.no_opening_hours),
                        R.drawable.brandenburger_tor),
                Place("Siegessäule",
                        this.getString(R.string.description_goldelse),
                        "Straße des 17. Juni",
                        "Bus",
                        this.getString(R.string.no_opening_hours),
                        R.drawable.siegessaeule)
        )

        // Get adapter for the list view.
        val placeAdapter = PlaceAdapter(this, places)

        // Find list view.
        val listView = findViewById<ListView>(R.id.places_list_view)

        // Set place adapter on list view.
        listView.adapter = placeAdapter

        // Set click listener on list view to load place detail fragment.
        listView.setOnItemClickListener { parent, view, position, id ->
            // Get current place object.
            val place = places[position]

            Toast.makeText(this@SitesActivity, "clicked", Toast.LENGTH_SHORT).show()

            // Create Fragment to be placed in detail container.
            val placeDetail = PlaceFragment()
            placeDetail.place = place

            // Replace content of the detail fragment with the current place object.
            supportFragmentManager.beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.detail_container, placeDetail)
                    .commit()
        }
    }
}