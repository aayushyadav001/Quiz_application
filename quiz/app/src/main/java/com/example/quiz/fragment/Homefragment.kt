package com.example.quiz.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quiz.R
import com.example.quiz.databinding.FragmentHomefragmentBinding
import com.example.quiz.model.categorymodelclass
import com.example.quiz.adapter.categoryadapter
import com.example.quiz.Withdrawal
import com.example.quiz.model.user
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase

class Homefragment : Fragment() {
private val binding:FragmentHomefragmentBinding by lazy {
    FragmentHomefragmentBinding.inflate(layoutInflater)
}
private var categoryList=ArrayList<categorymodelclass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoryList.add(categorymodelclass(R.drawable.scince,"science"))
        categoryList.add(categorymodelclass(R.drawable.english,"english"))
        categoryList.add(categorymodelclass(R.drawable.math,"maths"))
        categoryList.add(categorymodelclass(R.drawable.history,"history"))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     binding.coinwithdrawl.setOnClickListener() {
         var bottomSheetDialog: BottomSheetDialogFragment = Withdrawal()
         bottomSheetDialog.show(requireActivity().supportFragmentManager, "TEST")
         bottomSheetDialog.enterTransition
     }
         binding.coinwithdrawl1.setOnClickListener(){
         var bottomSheetDialog:BottomSheetDialogFragment=Withdrawal()
         bottomSheetDialog.show(requireActivity().supportFragmentManager,"TEST")
         bottomSheetDialog.enterTransition
        }
        Firebase.database.reference.child("Users")
            .child(FirebaseAuth.getInstance().currentUser!!.uid)
            .addListenerForSingleValueEvent(
                object : ValueEventListener {
                    override fun onDataChange(snapshot: DataSnapshot) {
                        var user = snapshot.getValue<user>()
                        binding.name2.text = user?.name

                    }

                    override fun onCancelled(error: DatabaseError) {
                    }
                }
            )
        Firebase.database.reference.child("playercoin").child(FirebaseAuth.getInstance().currentUser!!.uid)
            .addValueEventListener(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()){
                        var currentcoin=snapshot.value as Long
                        binding.coinwithdrawl1.text=currentcoin.toString()
                    }

                }
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recycleview.layoutManager=GridLayoutManager(requireContext(),2)
        var adapter=categoryadapter(categoryList,requireActivity())
        binding.recycleview.adapter=adapter
        binding.recycleview.setHasFixedSize(true)
    }
    companion object {
    }
}