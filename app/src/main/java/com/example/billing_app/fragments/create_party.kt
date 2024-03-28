import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.billing_app.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

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

    private lateinit var dbRef : DatabaseReference
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_create_party, container, false)

        etpartyname = view.findViewById(R.id.partynameinput)
        etnumber = view.findViewById(R.id.partymobileinput)
        customerbtn = view.findViewById(R.id.customerbtn)
        supplierbtn = view.findViewById(R.id.supplierbtn)
        etgst = view.findViewById(R.id.gstinput)
        etpan = view.findViewById(R.id.paninput)
        etaddress = view.findViewById(R.id.streetaddressinput)
        stateinput = view.findViewById(R.id.statesection)
        etpincode = view.findViewById(R.id.pincodeinput)
        savebtn = view.findViewById(R.id.savebtn)

        dbRef = FirebaseDatabase.getInstance().getReference("party")

        savebtn.setOnClickListener{
            savepartydata()
        }
        val items = listOf("Andaman and Nicobar Islands",
            "Andhra Pradesh",
            "Arunachal Pradesh",
            "Assam",
            "Bihar",
            "Chandigarh",
            "Chhattisgarh",
            "Dadra and Nagar Haveli and Daman and Diu",
            "Delhi (National Capital Territory of Delhi)",
            "Goa",
            "Gujarat",
            "Haryana",
            "Himachal Pradesh",
            "Jharkhand",
            "Karnataka",
            "Kerala",
            "Ladakh",
            "Lakshadweep",
            "Madhya Pradesh",
            "Maharashtra",
            "Manipur",
            "Meghalaya",
            "Mizoram",
            "Nagaland",
            "Odisha",
            "Puducherry",
            "Punjab",
            "Rajasthan",
            "Sikkim",
            "Tamil Nadu",
            "Telangana",
            "Tripura",
            "Uttar Pradesh",
            "Uttarakhand",
            "West Bengal")

        val autoComplete : AutoCompleteTextView = view.findViewById(R.id.stateinput)

        val adapter01 = ArrayAdapter(requireContext(),R.layout.list_item,items)

        autoComplete.setAdapter(adapter01)

        autoComplete.setOnItemClickListener { adaptorView, view, i, l ->
            val itemSelected = adaptorView.getItemAtPosition(i)

        }

        return view
    }
    private fun savepartydata(){

        var partyname = etpartyname.text.toString()
        var phonenumber = etnumber.text.toString()
        var customerbtn = customerbtn.
    }





}

