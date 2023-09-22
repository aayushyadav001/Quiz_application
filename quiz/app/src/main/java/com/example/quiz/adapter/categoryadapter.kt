package com.example.quiz.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz.model.categorymodelclass
import com.example.quiz.Quizactivity
import com.example.quiz.databinding.CategoryitemBinding

class categoryadapter(
    private var categoryList: ArrayList<categorymodelclass>, private var requireActivity: FragmentActivity) :RecyclerView.Adapter<categoryadapter.MycategoryViewHolder>() {
    class MycategoryViewHolder(var binding:CategoryitemBinding):RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MycategoryViewHolder {
       return MycategoryViewHolder(CategoryitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount()= categoryList.size

    override fun onBindViewHolder(holder: MycategoryViewHolder, position: Int) {
         var datalist=categoryList[position]
        holder.binding.categoryimage.setImageResource(datalist.catimage)
        holder.binding.category.text=datalist.cattext
        holder.binding.cardbutton.setOnClickListener(){
            var intent=Intent(requireActivity,Quizactivity::class.java)
            intent.putExtra("img",datalist.catimage)
            intent.putExtra("questionType",datalist.cattext)
requireActivity.startActivity(intent)
        }
             }


}