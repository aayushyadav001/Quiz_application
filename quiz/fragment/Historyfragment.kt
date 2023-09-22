package com.example.quiz.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quiz.adapter.Historyadapter
import com.example.quiz.model.Historymodelclass
import com.example.quiz.databinding.FragmentHistoryfragmentBinding
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
import java.util.Collections


class Historyfragment : Fragment() {
    val binding by lazy {
        FragmentHistoryfragmentBinding.inflate(layoutInflater)
    }
    lateinit var adapter:Historyadapter
     var ListHistory= ArrayList<Historymodelclass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Firebase.database.reference.child("playercoinhistory")
            .child(FirebaseAuth.getInstance().currentUser!!.uid)
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    ListHistory.clear()
                    var ListHistory1= ArrayList<Historymodelclass>()
                    for (datasnapshot in snapshot.children) {
                        val data = datasnapshot.getValue(Historymodelclass::class.java)
                        ListHistory1.add(data!!)
                    adapter.notifyDataSetChanged()
                    }
                    Collections.reverse(ListHistory1)
                    ListHistory.addAll(ListHistory1)
                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            })
    }
   override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       binding.coinwithdrawl2.setOnClickListener() {
           val bottomSheetDialog: BottomSheetDialogFragment = Withdrawal()
           bottomSheetDialog.show(requireActivity().supportFragmentManager, "TEST")
           bottomSheetDialog.enterTransition
       }
       binding.balance.setOnClickListener(){
           val bottomSheetDialog: BottomSheetDialogFragment = Withdrawal()
           bottomSheetDialog.show(requireActivity().supportFragmentManager,"TEST")
           bottomSheetDialog.enterTransition
       }
binding.historyrecyclerview.layoutManager=LinearLayoutManager(requireContext())
        adapter=Historyadapter(ListHistory)
binding.historyrecyclerview.adapter=adapter
       binding.historyrecyclerview.setHasFixedSize(true)
       Firebase.database.reference.child("Users")
           .child(FirebaseAuth.getInstance().currentUser!!.uid)
           .addListenerForSingleValueEvent(
               object : ValueEventListener {
                   override fun onDataChange(snapshot: DataSnapshot) {
                       val user = snapshot.getValue<user>()
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
                      val currentcoin=snapshot.value as Long
                       binding.balance.text=currentcoin.toString()
                   }

               }
               override fun onCancelled(error: DatabaseError) {
                   TODO("Not yet implemented")
               }
           })
        return binding.root
    }
companion object {

}
}