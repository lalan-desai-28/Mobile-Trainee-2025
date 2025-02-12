package com.lalan.android_learning.snackbar_fab.snackbar

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.google.android.material.snackbar.Snackbar
import com.lalan.android_learning.R

class SnackbarExamples : AppCompatActivity() {

    private lateinit var simple_snackbar: Button
    private lateinit var simple_snackbar_2: Button
    private lateinit var simple_snackbar_3: Button
    private lateinit var simple_snackbar_4: Button

    private lateinit var colored_snackbar: Button
    private lateinit var snackbar_with_button: Button

    private lateinit var warning_button: Button
    private lateinit var error_button: Button
    private lateinit var to_perform_input_button: Button
    private lateinit var anchored_button: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_snackbar_examples)

        simple_snackbar = findViewById(R.id.simple_snackbar)
        simple_snackbar_2 = findViewById(R.id.simple_snackbar_2)
        simple_snackbar_3 = findViewById(R.id.simple_snackbar_3)
        simple_snackbar_4 = findViewById(R.id.simple_snackbar_4)


        colored_snackbar = findViewById(R.id.colored_snackbar)
        snackbar_with_button = findViewById(R.id.snackbar_with_button)

        warning_button = findViewById(R.id.warning_button)
        error_button = findViewById(R.id.error_button)
        to_perform_input_button = findViewById(R.id.to_perform_input_button)
        anchored_button = findViewById(R.id.anchored_button)

        simple_snackbar.setOnClickListener { view ->
            Snackbar.make(view, "This is a simple with duration short.", Snackbar.LENGTH_SHORT)
                .show()
        }

        simple_snackbar_2.setOnClickListener { view ->
            Snackbar.make(view, "This is a simple with duration long.", Snackbar.LENGTH_LONG).show()
        }

        simple_snackbar_3.setOnClickListener { view ->
            Snackbar.make(view, "Watch me fade!", Snackbar.LENGTH_SHORT)
                .setAnimationMode(Snackbar.ANIMATION_MODE_FADE).show()
        }

        simple_snackbar_4.setOnClickListener { view ->
            Snackbar.make(view, "Watch me slide!", Snackbar.LENGTH_LONG)
                .setAnimationMode(Snackbar.ANIMATION_MODE_SLIDE).show()
        }

        colored_snackbar.setOnClickListener { view ->
            Snackbar.make(view, "This is a colored snackbar.", Snackbar.LENGTH_LONG)
                .setBackgroundTint(ContextCompat.getColor(this, R.color.blue)).show()
        }

        snackbar_with_button.setOnClickListener { view ->
            Snackbar.make(view, "Item deleted!", Snackbar.LENGTH_LONG)
                .setAction("Undo", {
                    Toast.makeText(this, "Undo button pressed!", Toast.LENGTH_LONG).show()
                }).setActionTextColor(ContextCompat.getColor(this, R.color.white))
                .show()
        }

        warning_button.setOnClickListener { view ->
            Snackbar.make(view, "You are about to delete this item!", Snackbar.LENGTH_LONG)
                .setBackgroundTint(ContextCompat.getColor(this, R.color.orange))
                .setTextColor(ContextCompat.getColor(this, R.color.white))
                .show()
        }

        error_button.setOnClickListener { view ->
            Snackbar.make(
                view,
                "We had some error, Please try after sometime.",
                Snackbar.LENGTH_LONG
            )
                .setBackgroundTint(ContextCompat.getColor(this, R.color.red))
                .setTextColor(ContextCompat.getColor(this, R.color.white))
                .show()
        }

        to_perform_input_button.setOnClickListener { view ->
            Snackbar.make(view, "Your order is placed!", Snackbar.LENGTH_LONG)
                .setAction("View orders", {
                    Toast.makeText(this, "View orders button pressed!", Toast.LENGTH_LONG).show()
                }).setActionTextColor(ContextCompat.getColor(this, R.color.white))
                .show()

        }

        anchored_button.setOnClickListener { view ->
            Snackbar.make(view, "I am anchored to this button.", Snackbar.LENGTH_LONG)
                .setAnchorView(R.id.anchored_button)
                .show()
        }

    }
}