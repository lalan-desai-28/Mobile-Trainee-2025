package com.lalan.android_learning.dialog

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.lalan.android_learning.R
import java.util.Calendar

class DialogLearning : AppCompatActivity() {

    private lateinit var material_dialogs_checkbox: CheckBox
    private lateinit var simple_dialog_button: Button
    private lateinit var dialog_with_buttons_button: Button
    private lateinit var dialog_with_menu_button: Button
    private lateinit var dialog_with_checkboxes_button: Button
    private lateinit var dialog_with_radios_button: Button
    private lateinit var non_cancelable_button: Button
    private lateinit var dialog_with_custom_layout_button: Button
    private lateinit var date_picker_dialog: Button
    private lateinit var time_picker_dialog: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dialog_learning)

        // initializing the buttons.
        material_dialogs_checkbox = findViewById(R.id.material_dialogs_checkbox)
        simple_dialog_button = findViewById(R.id.simple_dialog_button)
        dialog_with_buttons_button = findViewById(R.id.dialog_with_buttons_button)
        dialog_with_menu_button = findViewById(R.id.dialog_with_menu_button)
        dialog_with_checkboxes_button = findViewById(R.id.dialog_with_checkboxes_button)
        dialog_with_radios_button = findViewById(R.id.dialog_with_radios_button)
        non_cancelable_button = findViewById(R.id.non_cancelable_button)
        dialog_with_custom_layout_button = findViewById(R.id.dialog_with_custom_layout_button)
        date_picker_dialog = findViewById(R.id.date_picker_dialog)
        time_picker_dialog = findViewById(R.id.time_picker_dialog)

        simple_dialog_button.setOnClickListener {

            if (material_dialogs_checkbox.isChecked) {
                MaterialAlertDialogBuilder(this).setTitle("Simple Dialog")
                    .setMessage("This is a simple dialog.").show()
                return@setOnClickListener
            }

            AlertDialog.Builder(this).setTitle("Simple Dialog")
                .setMessage("This is a simple dialog.").show()
        }

        dialog_with_buttons_button.setOnClickListener {

            if (material_dialogs_checkbox.isChecked) {
                MaterialAlertDialogBuilder(this).setTitle("Dialog with buttons")
                    .setMessage("You get three options: Positive, Neutral and Negative.")
                    .setPositiveButton("Positive", { dialog, view ->
                        Toast.makeText(this, "Positive button clicked.", Toast.LENGTH_SHORT).show()
                    })
                    .setNeutralButton("Neutral", { dialog, view ->
                        Toast.makeText(this, "Neutral button clicked.", Toast.LENGTH_SHORT).show()
                    })
                    .setNegativeButton("Negative", { dialog, view ->
                        Toast.makeText(this, "Negative button clicked.", Toast.LENGTH_SHORT).show()
                    }).show()
                return@setOnClickListener
            }

            AlertDialog.Builder(this).setTitle("Dialog with buttons")
                .setMessage("You get three options: Positive, Neutral and Negative.")
                .setPositiveButton("Positive", { dialog, view ->
                    Toast.makeText(this, "Positive button clicked.", Toast.LENGTH_SHORT).show()
                })
                .setNeutralButton("Neutral", { dialog, view ->
                    Toast.makeText(this, "Neutral button clicked.", Toast.LENGTH_SHORT).show()
                })
                .setNegativeButton("Negative", { dialog, view ->
                    Toast.makeText(this, "Negative button clicked.", Toast.LENGTH_SHORT).show()
                }).show()
        }

        dialog_with_menu_button.setOnClickListener {

            if (material_dialogs_checkbox.isChecked) {
                MaterialAlertDialogBuilder(this).setTitle("Dialog with menu")
                    .setItems(arrayOf("First", "Second", "Third"), { dialog, index ->
                        Toast.makeText(this, "You selected $index", Toast.LENGTH_SHORT).show()
                    }).show()
            }

            AlertDialog.Builder(this).setTitle("Dialog with menu")
                .setItems(arrayOf("First", "Second", "Third"), { dialog, index ->
                    Toast.makeText(this, "You selected $index", Toast.LENGTH_SHORT).show()
                }).show()
        }

        dialog_with_checkboxes_button.setOnClickListener {

            if (material_dialogs_checkbox.isChecked) {
                MaterialAlertDialogBuilder(this).setTitle("Dialog with checkboxes")
                    .setMultiChoiceItems(
                        arrayOf("First", "Second", "Third"),
                        null,
                        { dialog, index, bool ->
                            Toast.makeText(this, "You selected $index", Toast.LENGTH_SHORT).show()
                        })
                    .setPositiveButton("Ok", { dialog, view ->
                        Toast.makeText(this, "You pressed the ok button", Toast.LENGTH_SHORT).show()
                    }).show()

                return@setOnClickListener
            }

            AlertDialog.Builder(this).setTitle("Dialog with checkboxes")
                .setMultiChoiceItems(
                    arrayOf("First", "Second", "Third"),
                    null,
                    { dialog, index, bool ->
                        Toast.makeText(this, "You selected $index", Toast.LENGTH_SHORT).show()
                    })
                .setPositiveButton("Ok", { dialog, view ->
                    Toast.makeText(this, "You pressed the ok button", Toast.LENGTH_SHORT).show()
                }).show()
        }

        dialog_with_radios_button.setOnClickListener {

            if (material_dialogs_checkbox.isChecked) {
                MaterialAlertDialogBuilder(this).setTitle("Dialog with radios")
                    .setSingleChoiceItems(
                        arrayOf("First", "Second", "Third"),
                        -1,
                        { dialog, index ->
                            Toast.makeText(this, "You selected $index", Toast.LENGTH_SHORT).show()
                        })
                    .setPositiveButton("Ok", { dialog, view ->
                        Toast.makeText(this, "You pressed the ok button", Toast.LENGTH_SHORT).show()
                    }).show()
                return@setOnClickListener
            }

            AlertDialog.Builder(this).setTitle("Dialog with radios")
                .setSingleChoiceItems(
                    arrayOf("First", "Second", "Third"),
                    -1,
                    { dialog, index ->
                        Toast.makeText(this, "You selected $index", Toast.LENGTH_SHORT).show()
                    })
                .setPositiveButton("Ok", { dialog, view ->
                    Toast.makeText(this, "You pressed the ok button", Toast.LENGTH_SHORT).show()
                }).show()
        }

        dialog_with_custom_layout_button.setOnClickListener {

            if (material_dialogs_checkbox.isChecked) {
                MaterialAlertDialogBuilder(this).setTitle("Custom layout dialog")
                    .setMessage("You can add your layout here like for example login as shown below.")
                    .setView(R.layout.login_dialog)
                    .setCancelable(false)
                    .setPositiveButton("Login", { dialog, view ->
                        dialog.dismiss()
                        Toast.makeText(
                            this,
                            "You pressed on the login button.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }).show()
                    .show()

                return@setOnClickListener
            }

            AlertDialog.Builder(this).setTitle("Custom layout dialog")
                .setMessage("You can add your layout here like for example login as shown below.")
                .setView(R.layout.login_dialog)
                .setCancelable(false)
                .setPositiveButton("Login", { dialog, view ->
                    dialog.dismiss()
                    Toast.makeText(
                        this,
                        "You pressed on the login button.",
                        Toast.LENGTH_SHORT
                    ).show()
                }).show()
                .show()
        }

        non_cancelable_button.setOnClickListener {

            if (material_dialogs_checkbox.isChecked) {
                MaterialAlertDialogBuilder(this).setTitle("Non Cancelable Dialog")
                    .setMessage("You can't dismiss this by pressing outside.")
                    .setCancelable(false)
                    .setPositiveButton("Got it", { dialog, view ->
                        dialog.dismiss()
                        Toast.makeText(
                            this,
                            "You can only dismiss it by pressing this button.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }).show()

                return@setOnClickListener
            }

            AlertDialog.Builder(this).setTitle("Non Cancelable Dialog")
                .setMessage("You can't dismiss this by pressing outside.")
                .setCancelable(false)
                .setPositiveButton("Got it", { dialog, view ->
                    dialog.dismiss()
                    Toast.makeText(
                        this,
                        "You can only dismiss it by pressing this button.",
                        Toast.LENGTH_SHORT
                    ).show()
                }).show()
        }

        date_picker_dialog.setOnClickListener {

            if (material_dialogs_checkbox.isChecked) {

                val materialDatePicker = MaterialDatePicker.Builder
                    .datePicker().setTitleText("Choose a date").build()

                materialDatePicker.addOnPositiveButtonClickListener {
                    Toast.makeText(
                        this,
                        "Selected date: ${materialDatePicker.headerText}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                materialDatePicker.show(supportFragmentManager, "MATERIAL_DATE_PICKER")
                return@setOnClickListener
            }

            val calendar: Calendar = Calendar.getInstance()
            DatePickerDialog(
                this,
                { datePicker: DatePicker, year: Int, month: Int, day: Int ->
                    Toast.makeText(
                        this,
                        "Selected date: $day/${month + 1}/$year",
                        Toast.LENGTH_SHORT
                    ).show()
                }, calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        time_picker_dialog.setOnClickListener {

            if (material_dialogs_checkbox.isChecked) {

                val materialTimePicker = MaterialDatePicker.Builder
                    .datePicker().setTitleText("Choose a time").build()

                materialTimePicker.addOnPositiveButtonClickListener {
                    Toast.makeText(
                        this,
                        "Selected date: ${materialTimePicker.headerText}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                materialTimePicker.show(supportFragmentManager, "MATERIAL_DATE_PICKER")
                return@setOnClickListener
            }

            val calendar = Calendar.getInstance()
            TimePickerDialog(this, { timePicker: TimePicker, hour: Int, minutes: Int ->
                Toast.makeText(
                    this,
                    "Selected time: $hour:$minutes",
                    Toast.LENGTH_SHORT
                ).show()
            }, calendar.get(Calendar.HOUR), calendar.get(Calendar.MINUTE), true).show()
        }
    }
}