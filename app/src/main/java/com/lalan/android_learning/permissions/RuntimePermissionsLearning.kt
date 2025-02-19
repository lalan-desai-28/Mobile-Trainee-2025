package com.lalan.android_learning.permissions

import android.Manifest
import android.os.Build
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.lalan.android_learning.R

class RuntimePermissionsLearning : AppCompatActivity() {

    private lateinit var permissionStatusTextview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_runtime_permissions_learning)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        permissionStatusTextview = findViewById(R.id.permissionStatusTextview)


        val permissions = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.CAMERA,
            if (Build.VERSION.SDK_INT > 32)
                Manifest.permission.READ_MEDIA_IMAGES
            else
                Manifest.permission.READ_EXTERNAL_STORAGE
        )

        requestPermissions(permissions, 1)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        var output = ""
        for (result in permissions.zip(grantResults.toList())) {
            output += "${result.first.split(".").last()} = ${result.second == 0}\n\n"
        }
        permissionStatusTextview.text = output
    }

}