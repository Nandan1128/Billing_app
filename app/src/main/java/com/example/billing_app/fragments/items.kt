package com.example.billing_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.billing_app.R
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
class items : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_items, container, false)
        val fab01: ExtendedFloatingActionButton = view.findViewById(R.id.additemfab)
        fab01.setOnClickListener {
            // Handle FAB click to open new fragment
            val transaction = requireActivity().supportFragmentManager.beginTransaction()
            transaction.replace(R.id.mainFrame, add_item())
            transaction.addToBackStack(null)
            transaction.commit()
        }
        return view
    }




}