package com.example.quiz.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.quiz.R
import com.example.quiz.model.user
import com.example.quiz.databinding.FragmentProfilefragmentBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class Profilefragment : Fragment() {
val binding by lazy {
FragmentProfilefragmentBinding.inflate(layoutInflater)
}
    private var isExpand=true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding.imagebutton.setOnClickListener {
            if (isExpand) {
                binding.ExpandableconstraintLayout.visibility = View.VISIBLE
                binding.imagebutton.setImageResource(R.drawable.arrowup)
            } else {
                binding.ExpandableconstraintLayout.visibility = View.GONE
                binding.imagebutton.setImageResource(R.drawable.downarrow)
                isExpand != isExpand
            }
            isExpand=!isExpand
        }
        Firebase.database.reference.child("Users")
            .child(FirebaseAuth.getInstance().currentUser!!.uid)
            .addListenerForSingleValueEvent(
            object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                         val user=snapshot.getValue<user>()
                         binding.name2.text=user?.name
                         binding.nameUp.text=user?.name
                         binding.email2.text=user?.email
                         binding.password2.text=user?.password
                         binding.age2.text=user?.age.toString()
                }

                override fun onCancelled(error: DatabaseError) {
                }

            }
        )
            return binding.root
        }

    companion object {

    }
}