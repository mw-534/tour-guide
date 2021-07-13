package com.example.android.tourguide

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


/**
 * A simple [Fragment] subclass.
 * Use the [PlaceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PlaceFragment : Fragment() {

    /**
     * [Place] object that contains the data of the fragemnt.
     */
    var place: Place? = null

    /**
     * Called to have the fragment instantiate its user interface view.
     * This is optional, and non-graphical fragments can return null. This will be called between
     * [.onCreate] and [.onActivityCreated].
     *
     * A default View can be returned by calling [.Fragment] in your
     * constructor. Otherwise, this method returns null.
     *
     *
     * It is recommended to **only** inflate the layout in this method and move
     * logic that operates on the returned View to [.onViewCreated].
     *
     *
     * If you return a View from here, you will later be called in
     * [.onDestroyView] when the view is being released.
     *
     * @param inflater The LayoutInflater object that can be used to inflate
     * any views in the fragment,
     * @param container If non-null, this is the parent view that the fragment's
     * UI should be attached to.  The fragment should not add the view itself,
     * but this can be used to generate the LayoutParams of the view.
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     *
     * @return Return the View for the fragment's UI, or null.
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_place, container, false)
    }

    /**
     * Called immediately after [.onCreateView]
     * has returned, but before any saved state has been restored in to the view.
     * This gives subclasses a chance to initialize themselves once
     * they know their view hierarchy has been completely created.  The fragment's
     * view hierarchy is not however attached to its parent at this point.
     * @param view The View returned by [.onCreateView].
     * @param savedInstanceState If non-null, this fragment is being re-constructed
     * from a previous saved state as given here.
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Load data of place of object if it exists in bundle.
        if (place != null) {
            loadPlace(view, place!!)
        }
    }

    companion object {
        /**
         * Loads the given place into the view of the fragment.
         *
         * @param view is the view of the fragment.
         * @param place is the [Place] object to be loaded.
         */
        fun loadPlace(view: View, place: Place) {
            // Set image.
            if (place.hasImage()) {
                val imageView = view.findViewById<ImageView>(R.id.place_detail_image)
                imageView.setImageResource(place.imageResId)
            }

            // Set name.
            val tvName = view.findViewById<TextView>(R.id.place_detail_name)
            tvName.text = place.name

            // Set address.
            val tvAddress = view.findViewById<TextView>(R.id.place_detail_address)
            tvAddress.text = place.address

            // Set opening hours.
            val tvOpeningHours = view.findViewById<TextView>(R.id.place_detail_opening_hours)
            tvOpeningHours.text = place.openingHours

            // Set transportation.
            val tvTransport = view.findViewById<TextView>(R.id.place_detail_transport)
            tvTransport.text = place.transportation

            // Set description.
            val tvDescription = view.findViewById<TextView>(R.id.parent_detail_description)
            tvDescription.text = place.description
        }
    }
}