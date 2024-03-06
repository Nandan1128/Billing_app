package com.example.billing_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.example.billing_app.R

class More : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_more, container, false)

        // Find the CardView
        val gstsetting : CardView = view.findViewById(R.id.businessandgstcard)

        // Set click listener for the CardView
        gstsetting.setOnClickListener{
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.mainFrame, gstsetting())
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return view
    }
}
