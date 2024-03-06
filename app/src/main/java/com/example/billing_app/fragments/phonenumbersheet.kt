package com.example.billing_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.billing_app.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class phonenumbersheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_phonenumbersheet, container, false)

    companion object {
        const val TAG = "ModalBottomSheet"
    }

}