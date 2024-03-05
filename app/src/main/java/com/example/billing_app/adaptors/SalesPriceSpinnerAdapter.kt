package com.example.billing_app.adaptors

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.billing_app.R

class SalesPriceSpinnerAdapter(context: Context, resource: Int, objects: Array<String>) : ArrayAdapter<String>(context, resource, objects) {
    override  fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    private fun getCustomView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View

        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.sales_price_spinner_item, parent, false)
        } else {
            view = convertView
        }

        (view as TextView).text = getItem(position)
        return view
    }
}