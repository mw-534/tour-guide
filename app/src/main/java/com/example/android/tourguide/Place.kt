package com.example.android.tourguide

import android.content.Context

const val HAS_NO_IMAGE = -1

/**
 * Describes a place.
 *
 * @property name is the name of the place.
 * @property description is the description of the place.
 * @property address is address of the place.
 * @property transportation is public transports near the place.
 * @property openingHours are the opening hours of the place.
 * @property imageResId is the resource ID of the image of the place.
 */
class Place(val name: String,
            val description: String,
            val address: String,
            val transportation: String,
            val openingHours: String,
            val imageResId: Int = HAS_NO_IMAGE) {

    /**
     * Checks whether the [Place] object contains an image.
     *
     * @return Whether the [Place] object contains an image.
     */
    fun hasImage() = imageResId != HAS_NO_IMAGE
    
}