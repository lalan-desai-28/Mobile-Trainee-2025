package com.lalan.android_learning.fragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import com.lalan.android_learning.R


class FragmentB : Fragment() {

    private lateinit var edittext: EditText
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_b, container, false)

        // Initializing the views
        edittext = view.findViewById(R.id.editext)
        button = view.findViewById(R.id.button)

        // Getting the initial data and setting it in the edittext
        edittext.setText(getArguments()?.getString("data"))

        // Passing the data to fragment A and C
        button.setOnClickListener {
            setFragmentResult("btoa", bundleOf("data" to edittext.text.toString()))
            setFragmentResult("btoc", bundleOf("data" to edittext.text.toString()))
        }

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Adding the result listeners to listen to the data from A and C
        setFragmentResultListener("atob", { _, bundle ->
            edittext.setText(bundle.getString("data"))
        })
        setFragmentResultListener("ctob", { _, bundle ->
            edittext.setText(bundle.getString("data"))
        })

    }

}