package com.example.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.quiz.databinding.ActivityQuizactivityBinding
import com.example.quiz.model.Question
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


class Quizactivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityQuizactivityBinding.inflate(layoutInflater)
    }
     private var currentquestion=0
     private var score=0
    var  currentchance=0L
     private lateinit var questionList:ArrayList<Question>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        Firebase.database.reference.child("playercoin").child(FirebaseAuth.getInstance().currentUser!!.uid)
            .addValueEventListener(object :ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    if(snapshot.exists()){
                        var currentcoin=snapshot.value as Long
                        binding.balance1.text=currentcoin.toString()
                    }

                }
                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }
            })
                Firebase.database.reference.child("playchance").child(FirebaseAuth.getInstance().currentUser!!.uid)
                    .addValueEventListener(object :ValueEventListener{
                        override fun onDataChange(snapshot: DataSnapshot) {
                            if(snapshot.exists()){
                      currentchance= snapshot.value as Long
                            }
                        }
                        override fun onCancelled(error: DatabaseError) {
                            TODO("Not yet implemented")
                        }
                    })
        questionList= ArrayList()
        var image=intent.getIntExtra("img",0)
        var cattext=intent.getStringExtra("questionType")
        Firebase.firestore.collection("Questions").document(cattext.toString())
            .collection("QuestionsofScience").get().addOnSuccessListener {
                    questionData ->
//                questionList.clear()
                for (data in questionData.documents) {
                    var question: Question? = data.toObject(Question::class.java)
                    questionList.add(question!!)
                }
                if (questionList.size >0) {
                    binding.question.text = questionList[currentquestion].question
                    binding.option1.text = questionList[currentquestion].option1
                    binding.option2.text = questionList[currentquestion].option2
                    binding.option3.text = questionList[currentquestion].option3
                    binding.option4.text = questionList[currentquestion].option4
                }
            }
        Firebase.firestore.collection("Questions").document(cattext.toString())
            .collection("questions").get().addOnSuccessListener {
                    questionData ->
//                questionList.clear()
                for (data in questionData.documents) {
                    var question: Question? = data.toObject(Question::class.java)
                    questionList.add(question!!)
                }
                if (questionList.size >0) {
                    binding.question.text = questionList[currentquestion].question
                    binding.option1.text = questionList[currentquestion].option1
                    binding.option2.text = questionList[currentquestion].option2
                    binding.option3.text = questionList[currentquestion].option3
                    binding.option4.text = questionList[currentquestion].option4
                }
            }
        Firebase.firestore.collection("Questions").document(cattext.toString())
            .collection("questionsofmath").get().addOnSuccessListener {
                    questionData ->
//                questionList.clear()
                for (data in questionData.documents) {
                    var question: Question? = data.toObject(Question::class.java)
                    questionList.add(question!!)
                }
                if (questionList.size >0) {
                    binding.question.text = questionList[currentquestion].question
                    binding.option1.text = questionList[currentquestion].option1
                    binding.option2.text = questionList[currentquestion].option2
                    binding.option3.text = questionList[currentquestion].option3
                    binding.option4.text = questionList[currentquestion].option4
                }
            }
        Firebase.firestore.collection("Questions").document(cattext.toString())
            .collection("questionsofhistory").get().addOnSuccessListener {
                    questionData ->
//                questionList.clear()
                for (data in questionData.documents) {
                    var question: Question? = data.toObject(Question::class.java)
                    questionList.add(question!!)
                }
                if (questionList.size >0) {
                    binding.question.text = questionList[currentquestion].question
                    binding.option1.text = questionList[currentquestion].option1
                    binding.option2.text = questionList[currentquestion].option2
                    binding.option3.text = questionList[currentquestion].option3
                    binding.option4.text = questionList[currentquestion].option4
                }
            }
        binding.img.setImageResource(image)
        binding.coinwithdrawl2.setOnClickListener{
            var bottomSheetDialog: BottomSheetDialogFragment = Withdrawal()
            bottomSheetDialog.show(this@Quizactivity.supportFragmentManager, "TEST")
            bottomSheetDialog.enterTransition
        }
        binding.balance1.setOnClickListener{
            var bottomSheetDialog: BottomSheetDialogFragment =Withdrawal()
            bottomSheetDialog.show(this@Quizactivity.supportFragmentManager,"TEST")
            bottomSheetDialog.enterTransition
        }
        binding.option1.setOnClickListener{
            nextQuestionAndScoreUpdate(binding.option1.text.toString())
        }
        binding.option2.setOnClickListener{
            nextQuestionAndScoreUpdate(binding.option2.text.toString())
        }
        binding.option3.setOnClickListener{
            nextQuestionAndScoreUpdate(binding.option3.text.toString())
        }
        binding.option4.setOnClickListener{
            nextQuestionAndScoreUpdate(binding.option4.text.toString())
        }
    }

    private fun nextQuestionAndScoreUpdate(s:String) {
        if(s == questionList[currentquestion].ans){
            score+=20
        }
           currentquestion++
        if(currentquestion>=questionList.size){
            if (score>=60){
                binding.winner.visibility=View.VISIBLE
                Firebase.database.reference.child("playchance").child(FirebaseAuth.getInstance().currentUser!!.uid).setValue(currentchance+1)
            }
            else{
                binding.sorry.visibility=View.VISIBLE
            }
        }
        else {
            binding.question.text = questionList[currentquestion].question
            binding.option1.text = questionList[currentquestion].option1
            binding.option2.text = questionList[currentquestion].option2
            binding.option3.text = questionList[currentquestion].option3
            binding.option4.text = questionList[currentquestion].option4
        }
    }
}