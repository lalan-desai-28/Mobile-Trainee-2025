package com.lalan.android_learning.map.fragments

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.lalan.android_learning.R


class MapsFragment(private val initialMarkerPoint: LatLng) : Fragment() {


    private fun getAddress(latLng: LatLng): String {
        val addresses = Geocoder(requireContext()).getFromLocation(
            latLng.latitude, latLng.longitude, 1
        )

        return if (addresses != null) {
            if (addresses.size > 0) addresses[0].getAddressLine(0)
            else "Could not resolve!"
        } else "Could not resolve!"
    }

    private val callback = OnMapReadyCallback { googleMap ->

        val bitmapDrawable =
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.shah_rukh_khan
            ) as BitmapDrawable

        val bitmap = Bitmap.createScaledBitmap(bitmapDrawable.bitmap, 100, 100, true)

        googleMap.addMarker(
            MarkerOptions().position(initialMarkerPoint).title(getAddress(initialMarkerPoint)).icon(
                BitmapDescriptorFactory.fromBitmap(bitmap)
            )
        )

        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(initialMarkerPoint, 17.5f))

        googleMap.setOnMarkerClickListener { latLng ->
            Toast.makeText(requireContext(), getAddress(latLng.position), Toast.LENGTH_SHORT)
                .show()
            true
        }

        googleMap.setOnMapLongClickListener { latLng ->
            googleMap.addMarker(MarkerOptions().position(latLng))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}