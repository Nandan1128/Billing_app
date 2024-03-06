package com.example.billing_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import com.example.billing_app.R
import com.example.billing_app.adaptors.SalesPriceSpinnerAdapter

class add_item : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentView = inflater.inflate(R.layout.fragment_add_item, container, false)

        val salesPriceSpinner: Spinner = fragmentView.findViewById(R.id.salesPriceSpinner)


        val salesPriceSpinnerAdapter = SalesPriceSpinnerAdapter(requireContext(), R.layout.sales_price_spinner_item, arrayOf(
            resources.getString(R.string.sales_price_menu_without_tax),
            resources.getString(R.string.sales_price_menu_with_tax)
        ))
        salesPriceSpinner.adapter = salesPriceSpinnerAdapter
        salesPriceSpinner.setSelection(1)

        salesPriceSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position) as String
                if (selectedItem == resources.getString(R.string.sales_price_menu_without_tax)) {
                    TODO()
                }
                else if (selectedItem == resources.getString(R.string.sales_price_menu_with_tax)) {
                    TODO()
                }

            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                // Handle the case where no option is selected
            }
        }

        salesPriceSpinner.onItemSelectedListener = null
        salesPriceSpinner.post {
            salesPriceSpinner.setSelection(0)

        }

        return fragmentView
    }

}
