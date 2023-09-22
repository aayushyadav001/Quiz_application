package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quiz.databinding.ActivityMainBinding
import com.example.quiz.model.user
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

//
        binding.signup.setOnClickListener() {
            if (binding.name1.text.toString() == "" ||
                binding.age1.text.toString() == "" ||
                binding.email1.text.toString() == "" ||
                binding.pass1.text.toString() == ""
            ) {
                Toast.makeText(this, "please fill all the details", Toast.LENGTH_SHORT).show()
            } else {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    binding.email1.text.toString(),
                    binding.pass1.text.toString()
                ).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val user = user(
                            binding.name1.text.toString(),
                            binding.age1.text.toString().toInt(),
                            binding.email1.text.toString(),
                            binding.pass1.text.toString()
                        )
                        Firebase.database.reference.child("Users")
                            .child(FirebaseAuth.getInstance().currentUser!!.uid).push().setValue(user).addOnSuccessListener {
                                startActivity(Intent(this, HomeActivity::class.java))
                                finish()
                            }
                    } else {
                        Toast.makeText(this, it.exception?.localizedMessage, Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            }
        }
    }

    override fun onStart() {
       super.onStart()
        if(FirebaseAuth.getInstance().currentUser!=null){
startActivity(Intent(this,HomeActivity::class.java))
            finish()
        }
    }
}
