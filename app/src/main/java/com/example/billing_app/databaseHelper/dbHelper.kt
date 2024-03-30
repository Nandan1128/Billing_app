package com.example.billing_app.databaseHelper

import com.google.firebase.database.FirebaseDatabase

class dbHelper {
    object FirebaseDatabaseHelper {
        private val database = FirebaseDatabase.getInstance()
        private val BusinessRef = database.getReference("Business")
        private val PartyRef = database.getReference("Parties")
        private val ItemRef = database.getReference("Items")
        private val InvoiceRef = database.getReference("Invoices")

    }

}