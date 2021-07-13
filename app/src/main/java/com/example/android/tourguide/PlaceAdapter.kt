package com.example.android.tourguide

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

/**
 * Fills a [ListView] item with the values of a [Place] object.
 *
 * @param context is the Context of the app.
 * @param list is the list of [Place] objects.
 */
class PlaceAdapter(context: Context, list: ArrayList<Place>) : ArrayAdapter<Place>(context, 0, list) {

    /**
     * Recycles an existing place list item view or inflates a new one and fills it
     * with the values of the current [Place] object.
     */
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        // inflate place_list_item view if no view is available for recycling
        val listItemView = convertView ?: LayoutInflater.from(context).inflate(R.layout.place_list_item, parent, false)

        // Get the current place.
        val place = getItem(position) as Place

        // Find name TextView and fill it with value.
        val nameTextView = listItemView.findViewById<TextView>(R.id.place_list_item_name)
        nameTextView.text = place.name

        // Find address TextView and fill it with value.
        val addressTextView = listItemView.findViewById<TextView>(R.id.place_list_item_address)
        addressTextView.text = place.address

        // If place contains an image set it else hide image view.
        val imageView = listItemView.findViewById<ImageView>(R.id.place_list_item_img)
        if (place.hasImage()) {
            imageView.setImageResource(place.imageResId)
            imageView.visibility = ImageView.VISIBLE
        } else {
            imageView.visibility = ImageView.GONE
        }

        return listItemView
    }
}