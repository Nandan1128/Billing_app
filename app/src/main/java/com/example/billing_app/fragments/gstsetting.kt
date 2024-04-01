package com.example.billing_app.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.billing_app.R
import com.example.billing_app.dataclass.BusinessModel
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class gstsetting : Fragment() {

    private lateinit var etbusinessname : EditText
    private lateinit var etbusinessphone: EditText
    private lateinit var etbusinessgst: EditText
    private lateinit var etbusinesspan: EditText
    private lateinit var etbusinessaddress: EditText
    private lateinit var etbusinesspincode: EditText
    private lateinit var etbusinessstateinput: EditText
    private lateinit var savebtn : CardView
    private lateinit var businessRef : DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater
        , container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_gstsetting, container, false)

        savebtn = view.findViewById(R.id.savebtn)

        val businessNameInputLayout = view.findViewById<TextInputLayout>(R.id.businessnameinput)
        etbusinessname = businessNameInputLayout.findViewById(R.id.etbusinessinput)

        val businessPhoneInputLayout = view.findViewById<TextInputLayout>(R.id.businessmobileinput)
        etbusinessphone = businessPhoneInputLayout.findViewById(R.id.etbusinessmobile)

        val businessGstInputLayout = view.findViewById<TextInputLayout>(R.id.businessgstinput)
        etbusinessgst = businessGstInputLayout.findViewById(R.id.etbusinessgst)

        val businessPanInputLayout = view.findViewById<TextInputLayout>(R.id.businesspaninput)
        etbusinesspan = businessPanInputLayout.findViewById(R.id.etbusinesspan)

        val businessAddressInputLayout = view.findViewById<TextInputLayout>(R.id.businessaddressinput)
        etbusinessaddress = businessAddressInputLayout.findViewById(R.id.etbusinessaddress)

        val businessStateInputLayout = view.findViewById<TextInputLayout>(R.id.businessstateselection)
        etbusinessstateinput = businessStateInputLayout.findViewById(R.id.etbusinessstateinput)

        val businessPincodeInputLayout = view.findViewById<TextInputLayout>(R.id.businesspincodeinput)
        etbusinesspincode = businessPincodeInputLayout.findViewById(R.id.etbusinesspincode)

        businessRef = FirebaseDatabase.getInstance().getReference("Business")


        savebtn.setOnClickListener {
            savedata()
        }

        return view
    }

   private fun savedata(){
       val Businessname = etbusinessname.text.toString()
       val Businessphone = etbusinessphone.text.toString()
       val Businessgst = etbusinessgst.text.toString()
       val Businesspan = etbusinesspan.text.toString()
       val Businessaddress = etbusinessaddress.text.toString()
       val pincode = etbusinesspincode.text.toString()
       val Businessstate = etbusinessstateinput.text.toString()


       val BusinessId = businessRef.push().key ?: ""

       val Businessmodal = BusinessModel(BusinessId,Businessname,Businessphone,Businessgst,Businesspan,Businessaddress,pincode,Businessstate)

       businessRef.child(BusinessId).setValue(Businessmodal)
           .addOnCompleteListener{
               Toast.makeText(requireContext(),"Party Created", Toast.LENGTH_SHORT).show()
           }.addOnFailureListener{
               Toast.makeText(requireContext(),"failed to Create Party", Toast.LENGTH_SHORT).show()
           }
   }

}