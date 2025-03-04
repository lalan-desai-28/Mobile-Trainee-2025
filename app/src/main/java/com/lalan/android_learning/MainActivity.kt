package com.lalan.android_learning

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

import com.lalan.android_learning.activity.ActivityLearning
import com.lalan.android_learning.appbar_toolbar.AppbarToolbarLearning
import com.lalan.android_learning.broadcast.BroadcastLearning
import com.lalan.android_learning.coil_glide_dark_theme.CoilGlideDarkThemeLearning
import com.lalan.android_learning.dependency_injection.DependencyInjectionLearning
import com.lalan.android_learning.dialog.DialogLearning
import com.lalan.android_learning.dimensions.DimensionsLearning
import com.lalan.android_learning.drawable.DrawableActivity
import com.lalan.android_learning.font.FontLearning
import com.lalan.android_learning.fragments.FragmentsLearning
import com.lalan.android_learning.intent.IntentLearning
import com.lalan.android_learning.layout.LayoutLearning
import com.lalan.android_learning.map.MapLearning
import com.lalan.android_learning.multithreading.MultiThreadingLearning
import com.lalan.android_learning.notification_fcm.NotificationAndFCMLearning
import com.lalan.android_learning.permissions.RuntimePermissionsLearning
import com.lalan.android_learning.recyclerview_with_room.RecyclerViewLearning
import com.lalan.android_learning.retrofit.GetRequestExampleActivity
import com.lalan.android_learning.service.ServiceLearning
import com.lalan.android_learning.sharedpreferences.LoginActivity
import com.lalan.android_learning.snackbar_fab.SnakckbarAndFABLearning
import com.lalan.android_learning.viewpager.ViewPagerActivity
import com.lalan.android_learning.webview.WebViewLearning
import com.lalan.android_learning.workmanager.WorkManagerLearning

class MainActivity : AppCompatActivity() {


    private lateinit var activity_button: Button
    private lateinit var layout_button: Button
    private lateinit var drawable_button: Button
    private lateinit var view_pager_button: Button
    private lateinit var dimension_button: Button
    private lateinit var appbar_toolbar_button: Button
    private lateinit var snackbar_fab_button: Button
    private lateinit var fonts_button: Button
    private lateinit var dialogs_button: Button
    private lateinit var fragments_button: Button
    private lateinit var recyclerViewButton: Button
    private lateinit var intentButton: Button
    private lateinit var permissionsButton: Button
    private lateinit var sharedPrefButton: Button
    private lateinit var webviewButton: Button
    private lateinit var retrofitButton: Button
    private lateinit var mapButton: Button
    private lateinit var notificationAndFCMButton: Button
    private lateinit var multiThreadingButton: Button
    private lateinit var workManagerButton: Button
    private lateinit var broadcastButton: Button
    private lateinit var serviceButton: Button
    private lateinit var dependencyInjectionButton: Button
    private lateinit var coilGlideDarkThemeButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing buttons.
        activity_button = findViewById(R.id.activity_button)
        layout_button = findViewById(R.id.layout_button)
        drawable_button = findViewById(R.id.drawable_button)
        dimension_button = findViewById(R.id.dimension_button)
        view_pager_button = findViewById(R.id.view_pager_button)
        appbar_toolbar_button = findViewById(R.id.appbar_toolbar_button)
        snackbar_fab_button = findViewById(R.id.snackbar_fab_button)
        fonts_button = findViewById(R.id.fonts_button)
        dialogs_button = findViewById(R.id.dialogs_button)
        fragments_button = findViewById(R.id.fragments_button)
        recyclerViewButton = findViewById(R.id.recyclerViewButton)
        intentButton = findViewById(R.id.intentButton)
        permissionsButton = findViewById(R.id.permissionsButton)
        sharedPrefButton = findViewById(R.id.sharedPrefButton)
        webviewButton = findViewById(R.id.webviewButton)
        retrofitButton = findViewById(R.id.retrofitButton)
        mapButton = findViewById(R.id.mapButton)
        notificationAndFCMButton = findViewById(R.id.notificationAndFCMButton)
        multiThreadingButton = findViewById(R.id.multiThreadingButton)
        workManagerButton = findViewById(R.id.workManagerButton)
        broadcastButton = findViewById(R.id.broadcastButton)
        serviceButton = findViewById(R.id.serviceButton)
        dependencyInjectionButton = findViewById(R.id.dependencyInjectionButton)
        coilGlideDarkThemeButton = findViewById(R.id.coilGlideDarkThemeButton)

        activity_button.setOnClickListener {
            val intent = Intent(this, ActivityLearning::class.java)
            startActivity(intent)
        }

        layout_button.setOnClickListener {
            val intent = Intent(this, LayoutLearning::class.java)
            startActivity(intent)
        }

        drawable_button.setOnClickListener {
            val intent = Intent(this, DrawableActivity::class.java)
            startActivity(intent)
        }

        dimension_button.setOnClickListener {
            val intent = Intent(this, DimensionsLearning::class.java)
            startActivity(intent)
        }

        view_pager_button.setOnClickListener {
            val intent = Intent(this, ViewPagerActivity::class.java)
            startActivity(intent)
        }

        appbar_toolbar_button.setOnClickListener {
            val intent = Intent(this, AppbarToolbarLearning::class.java)
            startActivity(intent)
        }

        snackbar_fab_button.setOnClickListener {
            val intent = Intent(this, SnakckbarAndFABLearning::class.java)
            startActivity(intent)
        }

        fonts_button.setOnClickListener {
            val intent = Intent(this, FontLearning::class.java)
            startActivity(intent)
        }

        dialogs_button.setOnClickListener {
            val intent = Intent(this, DialogLearning::class.java)
            startActivity(intent)
        }

        fragments_button.setOnClickListener {
            val intent = Intent(this, FragmentsLearning::class.java)
            startActivity(intent)
        }

        recyclerViewButton.setOnClickListener {
            val intent = Intent(this, RecyclerViewLearning::class.java)
            startActivity(intent)
        }

        intentButton.setOnClickListener {
            val intent = Intent(this, IntentLearning::class.java)
            startActivity(intent)
        }

        permissionsButton.setOnClickListener {
            val intent = Intent(this, RuntimePermissionsLearning::class.java)
            startActivity(intent)
        }

        sharedPrefButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        webviewButton.setOnClickListener {
            val intent = Intent(this, WebViewLearning::class.java)
            startActivity(intent)
        }

        retrofitButton.setOnClickListener {
            val intent = Intent(this, GetRequestExampleActivity::class.java)
            startActivity(intent)
        }

        mapButton.setOnClickListener {
            val intent = Intent(this, MapLearning::class.java)
            startActivity(intent)
        }

        notificationAndFCMButton.setOnClickListener {
            val intent = Intent(this, NotificationAndFCMLearning::class.java)
            startActivity(intent)
        }

        multiThreadingButton.setOnClickListener {
            val intent = Intent(this, MultiThreadingLearning::class.java)
            startActivity(intent)
        }

        workManagerButton.setOnClickListener {
            val intent = Intent(this, WorkManagerLearning::class.java)
            startActivity(intent)
        }

        broadcastButton.setOnClickListener {
            val intent = Intent(this, BroadcastLearning::class.java)
            startActivity(intent)
        }

        serviceButton.setOnClickListener {
            val intent = Intent(this, ServiceLearning::class.java)
            startActivity(intent)
        }

        dependencyInjectionButton.setOnClickListener {
            val intent = Intent(this, DependencyInjectionLearning::class.java)
            startActivity(intent)
        }

        coilGlideDarkThemeButton.setOnClickListener {
            val intent = Intent(this, CoilGlideDarkThemeLearning::class.java)
            startActivity(intent)
        }


    }
}