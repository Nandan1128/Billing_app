import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.billing_app.R
import com.example.billing_app.dataclass.partyModel
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class create_party : Fragment() {

    private lateinit var etpartyname : EditText
    private lateinit var etnumber : EditText
    private lateinit var customerbtn : Button
    private lateinit var supplierbtn : Button
    private lateinit var etgst : EditText
    private lateinit var etpan : EditText
    private lateinit var etaddress : EditText
    private lateinit var stateinput : AutoCompleteTextView
    private lateinit var etpincode : EditText
    private lateinit var savebtn : CardView

    var Parties = "Parties"
    private var partytype = ""
    //database reference
    private lateinit var partyRef : DatabaseReference
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_create_party, container, false)
        customerbtn = view.findViewById(R.id.customerbtn)
        supplierbtn = view.findViewById(R.id.supplierbtn)


        savebtn = view.findViewById(R.id.savebtn)

        val partyNameInputLayout = view.findViewById<TextInputLayout>(R.id.partynameinput)
        etpartyname = partyNameInputLayout.findViewById(R.id.partyinput)

        val partyMobileInputLayout = view.findViewById<TextInputLayout>(R.id.partymobileinput)
        etnumber = partyMobileInputLayout.findViewById(R.id.etnumber)

        val gstInputLayout = view.findViewById<TextInputLayout>(R.id.gstinput)
        etgst = gstInputLayout.findViewById(R.id.etgst)

        val panInputLayout = view.findViewById<TextInputLayout>(R.id.paninput)
        etpan = panInputLayout.findViewById(R.id.etpan)

        val streetAddressInputLayout = view.findViewById<TextInputLayout>(R.id.streetaddressinput)
        etaddress = streetAddressInputLayout.findViewById(R.id.etaddress)

        val stateInputLayout = view.findViewById<TextInputLayout>(R.id.statesection)
        stateinput = stateInputLayout.findViewById<AutoCompleteTextView>(R.id.stateinput)

        val pincodeInputLayout = view.findViewById<TextInputLayout>(R.id.pincodeinput)
        etpincode = pincodeInputLayout.findViewById(R.id.etpincode)


        partyRef = FirebaseDatabase.getInstance().getReference("Business")


        savebtn.setOnClickListener{
            savepartydata()
        }

        customerbtn.setOnClickListener {
            customerbtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.lightpink))
            supplierbtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            partytype = "Customer"
        }
        supplierbtn.setOnClickListener {
            customerbtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.white))
            supplierbtn.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.lightpink))
             partytype = "Supplier"
        }

        // statelist
        val items = listOf("Andaman and Nicobar Islands",
            "Andhra Pradesh","Arunachal Pradesh","Assam",
            "Bihar",            "Chandigarh",
            "Chhattisgarh",            "Dadra and Nagar Haveli and Daman and Diu",
            "Delhi (National Capital Territory of Delhi)",             "Goa",            "Gujarat",            "Haryana",            "Himachal Pradesh",            "Jharkhand",            "Karnataka",            "Kerala",            "Ladakh",            "Lakshadweep",            "Madhya Pradesh",
            "Maharashtra",            "Manipur",            "Meghalaya",            "Mizoram",            "Nagaland",            "Odisha",            "Puducherry",           "Punjab",
            "Rajasthan",            "Sikkim",            "Tamil Nadu",            "Telangana",
            "Tripura",            "Uttar Pradesh",            "Uttarakhand",            "West Bengal")
        val autoComplete : AutoCompleteTextView = view.findViewById(R.id.stateinput)
        val adapter01 = ArrayAdapter(requireContext(),R.layout.list_item,items)
        autoComplete.setAdapter(adapter01)
        autoComplete.setOnItemClickListener { adaptorView, view, i, l ->
            val itemSelected = adaptorView.getItemAtPosition(i)

        }
        // end of statelist

        return view
    }
    private fun savepartydata(){

        val partyname = etpartyname.text.toString()
        val phonenumber = etnumber.text.toString()
        val gst = etgst.text.toString()
        val pan = etpan.text.toString()
        val address = etaddress.text.toString()
        val state = stateinput.text.toString()
        val pincode = etpincode.text.toString()




        if (partyname.isEmpty() || phonenumber.isEmpty() || gst.isEmpty() ||  address.isEmpty() || state.isEmpty() || pincode.isEmpty()){
            etpartyname.error = "Please Enter Party Name"
            etnumber.error = "Please Enter Contect Number"
            etgst.error = "Please Enter GST Number"
            etaddress.error = "Please Enter Street Address"
            stateinput.error = "Please Select State"
            etpincode.error = "Please Enter Pincode"
            return
        }
        val partyId = partyRef.push().key ?: "first"

        val party = partyModel(partyId, partyname, phonenumber, gst, pan, address, state, pincode,partytype )
        if(partytype === "Customer"){
            partyRef.child(Parties).child(partytype).child(partyId).setValue(party)
                .addOnCompleteListener{
                    Toast.makeText(requireContext(),"Party Created",Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                    Toast.makeText(requireContext(),"failed to Create Party",Toast.LENGTH_SHORT).show()
                }
        }
        else{
            partyRef.child(Parties).child(partytype).child(partyId).setValue(party)
                .addOnCompleteListener{
                    Toast.makeText(requireContext(),"Party Created",Toast.LENGTH_SHORT).show()
                }.addOnFailureListener{
                    Toast.makeText(requireContext(),"failed to Create Party",Toast.LENGTH_SHORT).show()
                }
        }

    }




    // Define a function to fetch the business name from the database


}