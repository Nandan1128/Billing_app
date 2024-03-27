package com.example.billing_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.billing_app.R
import com.google.android.material.bottomsheet.BottomSheetDialog


class gstsetting : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater
        , container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gstsetting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Show bottom sheet when a button is clicked
        view.findViewById<View>(R.id.gstsettingcard).setOnClickListener {
            showBottomSheetDialog()
        }
        view.findViewById<View>(R.id.emailsettingcard).setOnClickListener {
            showBottomSheetDialog1()
        }
        view.findViewById<View>(R.id.cardgst).setOnClickListener{
            showBottomSheetDialog2()
        }
        view.findViewById<View>(R.id.cardpan).setOnClickListener{
            showBottomSheetDialog3()
        }
        view.findViewById<View>(R.id.cardaddress).setOnClickListener{
            showBottomSheetDialog4()
        }
    }
    private fun showBottomSheetDialog() {
        // Inflate the layout for the bottom sheet
        val bottomSheetView = layoutInflater.inflate(R.layout.fragment_phonenumbersheet, null)

        // Create bottom sheet dialog
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()
    }


    private fun showBottomSheetDialog1() {
        // Inflate the layout for the bottom sheet
        val bottomSheetView = layoutInflater.inflate(R.layout.fragment_emailsheet, null)

        // Create bottom sheet dialog
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()
    }


    private fun showBottomSheetDialog2() {
        // Inflate the layout for the bottom sheet
        val bottomSheetView = layoutInflater.inflate(R.layout.fragment_gstnumbersheet, null)

        // Create bottom sheet dialog
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()
    }

    private fun showBottomSheetDialog3() {
        // Inflate the layout for the bottom sheet
        val bottomSheetView = layoutInflater.inflate(R.layout.fragment_pannumbersheet, null)

        // Create bottom sheet dialog
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()
    }

    private fun showBottomSheetDialog4() {
        // Inflate the layout for the bottom sheet
        val bottomSheetView = layoutInflater.inflate(R.layout.fragment_addresssheet, null)

        // Create bottom sheet dialog
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.show()
    }

}