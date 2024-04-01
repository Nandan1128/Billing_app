package com.example.billing_app.databaseHelper

import android.content.Context
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class dbHelper(private val callback: (String?) -> Unit) {
        private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
        private val businessRef: DatabaseReference = database.getReference("Business")
        private val currentUser = FirebaseAuth.getInstance().currentUser

        init {
                // Fetch the business name upon initialization
                fetchBusinessName()
        }

        private fun fetchBusinessName() {
                businessRef.addListenerForSingleValueEvent(object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                                val businessName = dataSnapshot.child(currentUser?.uid ?: "").child("businessName").value.toString()
                                callback(businessName)
                        }

                        override fun onCancelled(databaseError: DatabaseError) {
                                callback(null)
                        }
                })
        }

        fun savePartyData(partyData: Any, onSuccess: () -> Unit, onFailure: (DatabaseError) -> Unit) {
                // Implement saving party data to the database
        }
}