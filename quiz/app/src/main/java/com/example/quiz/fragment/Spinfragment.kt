package com.example.quiz.fragment
import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.quiz.Withdrawal
import com.example.quiz.databinding.FragmentSpinfragmentBinding
import com.example.quiz.model.user
import com.example.quiz.model.Historymodelclass
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import java.util.Random

class Spinfragment : Fragment() {
    private lateinit var binding:FragmentSpinfragmentBinding
    private lateinit var timer: CountDownTimer
    private val itemTitles= arrayOf("200","Ultimate BBQ Hamper",
        "100","Double up your meats","300","Great tasting meat hamper")
    var currentchance=0L
    var currentcoin=0L
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding= FragmentSpinfragmentBinding.inflate(inflater,container,false)
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
        Firebase.database.reference.child("playchance").child(FirebaseAuth.getInstance().currentUser!!.uid)
            .addValueEventListener(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()){
                        currentchance=snapshot.value as Long
                     binding.spinchance.text= (snapshot.value as Long).toString()
                          }
                    else{
                        val temp=0
                     binding.spinchance.text= temp.toString()
                      binding.Spin.isEnabled=false
                    }
                }
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        Firebase.database.reference.child("playercoin").child(FirebaseAuth.getInstance().currentUser!!.uid)
            .addValueEventListener(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()){
                        currentcoin=snapshot.value as Long
                        binding.balance2.text=currentcoin.toString()
                          }

                }
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
        return binding.root
    }
    private fun showResult(itemTitle: String,spin:Int) {
        if (spin % 2 == 0) {
            val wincoin = itemTitle.toInt()
            Firebase.database.reference.child("playercoin")
                .child(FirebaseAuth.getInstance().currentUser!!.uid).setValue(wincoin + currentcoin)
            binding.balance2.text = (wincoin + currentcoin).toString()
            var historymodelclass=Historymodelclass(System.currentTimeMillis().toString(), wincoin.toString(), false)
            Firebase.database.reference.child("playercoinhistory").child(FirebaseAuth.getInstance().currentUser!!.uid).push()
                 .setValue( historymodelclass)
                        binding.balance2.text= (wincoin+currentcoin).toString()
        }
            Toast.makeText(requireContext(), itemTitle, Toast.LENGTH_SHORT).show()
            currentchance -= 1
            Firebase.database.reference.child("playchance")
                .child(FirebaseAuth.getInstance().currentUser!!.uid).setValue(currentchance)
            binding.Spin.isEnabled = true
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.coinwithdrawl3.setOnClickListener() {
            val bottomSheetDialog: BottomSheetDialogFragment = Withdrawal()
            bottomSheetDialog.show(requireActivity().supportFragmentManager, "TEST")
            bottomSheetDialog.enterTransition
        }
        binding.balance2.setOnClickListener(){
            val bottomSheetDialog: BottomSheetDialogFragment = Withdrawal()
            bottomSheetDialog.show(requireActivity().supportFragmentManager,"TEST")
            bottomSheetDialog.enterTransition
        }
        binding.Spin.setOnClickListener() {
            binding.Spin.isEnabled = false
            if(currentchance>0){
                val spin = Random().nextInt(6)
                val degrees = 60f * spin
                timer = object : CountDownTimer(5000, 50) {
                    var rotation = 0f
                    override fun onTick(millisUntilFinished: Long) {
                        rotation += 5f
                        if (rotation >= degrees) {
                            rotation = degrees
                            timer.cancel()
                            showResult(itemTitles[spin],spin)
                        }
                        binding.wheel.rotation = rotation
                    }

                    override fun onFinish() {}
                }.start()
            }else{
                Toast.makeText(activity, "out of bounds", Toast.LENGTH_SHORT).show()
            }

            }
    }
}
