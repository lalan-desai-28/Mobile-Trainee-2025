package com.lalan.android_learning.fragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.lalan.android_learning.R

class FragmentC : Fragment() {

    private lateinit var textview: TextView
    private lateinit var clear_button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_c, container, false)

        // Initializing the views
        textview = view.findViewById(R.id.textview)
        clear_button = view.findViewById(R.id.clear_button)

        // Getting the initial data and setting it in the edittext
        textview.text = getArguments()?.getString("data")

        // Clearing the textview and resetting data of both fragment A and B
        clear_button.setOnClickListener {
            textview.text = "Data: "
            setFragmentResult("ctoa", bundleOf("data" to ""))
            setFragmentResult("ctob", bundleOf("data" to ""))
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Adding the result listeners to listen to the data from A and B
        setFragmentResultListener("atoc", { _, bundle ->
            val msg = "Data: ${bundle.getString("data")}"
            textview.setText(msg)
        })
        setFragmentResultListener("btoc", { _, bundle ->
            val msg = "Data: ${bundle.getString("data")}"
            textview.setText(msg)
        })
    }
}