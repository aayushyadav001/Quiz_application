package com.example.quiz

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.quiz.databinding.FragmentWithdrawlBinding
import com.example.quiz.databinding.FragmentHistoryfragmentBinding
import com.example.quiz.databinding.FragmentSpinfragmentBinding
import com.example.quiz.databinding.FragmentHomefragmentBinding
import com.example.quiz.databinding.FragmentProfilefragmentBinding
import com.example.quiz.model.Historymodelclass
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class Withdrawal :BottomSheetDialogFragment() {
    private lateinit var binding: FragmentWithdrawlBinding
    var currentcoin=0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =FragmentWithdrawlBinding.inflate(inflater, container, false)
        Firebase.database.reference.child("playercoin")
            .child(FirebaseAuth.getInstance().currentUser!!.uid)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    if (snapshot.exists()) {
                        currentcoin = snapshot.value as Long
                    }

                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        binding.transfer.setOnClickListener(){
            if (binding.amount.text.toString().toDouble()<=currentcoin){
                Firebase.database.reference.child("playercoin")
                    .child(FirebaseAuth.getInstance().currentUser!!.uid).setValue(currentcoin-binding.amount.text.toString().toDouble())

                var historymodelclass= Historymodelclass(System.currentTimeMillis().toString(), binding.amount.text.toString(), true)
                Firebase.database.reference.child("playercoinhistory").child(FirebaseAuth.getInstance().currentUser!!.uid).push()
                    .setValue( historymodelclass)
            }
            else Toast.makeText(activity, "out of money", Toast.LENGTH_SHORT).show()
        }
   return binding.root
}

    companion object {
    }
}