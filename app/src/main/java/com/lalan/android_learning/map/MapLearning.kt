package com.lalan.android_learning.map

import android.Manifest
import android.annotation.SuppressLint
import android.location.Location
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.LatLng
import com.lalan.android_learning.R
import com.lalan.android_learning.map.fragments.MapsFragment

class MapLearning : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar

    private lateinit var locationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_map_learning)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        progressBar = findViewById(R.id.progressBar)

        locationClient = LocationServices.getFusedLocationProviderClient(this)

        requestPermissions(arrayOf(Manifest.permission.ACCESS_FINE_LOCATION), 1)

    }

    @SuppressLint("MissingPermission")
    private fun getLocation() {
        locationClient.lastLocation
            .addOnSuccessListener { location: Location? ->
                location?.let {
                    progressBar.visibility = View.GONE
                    supportFragmentManager.beginTransaction()
                        .add(R.id.mapFCV, MapsFragment(LatLng(it.latitude, it.longitude)))
                        .commit()
                }
            }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        Log.d("TAG", "onRequestPermissionsResult: ${grantResults[0]}")
        if (grantResults[0] == -1) {
            Toast.makeText(this, "Please allow the location permission.", Toast.LENGTH_LONG).show()
            finish()
        } else
            getLocation()
    }
}