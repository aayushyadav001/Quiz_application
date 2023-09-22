package com.example.quiz.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.example.quiz.databinding.HistoryitemBinding
import com.example.quiz.model.Historymodelclass
import java.sql.Timestamp

class Historyadapter(var ListHistory:ArrayList<Historymodelclass>) :RecyclerView.Adapter<Historyadapter.Historycoinviewholder>(){
     class Historycoinviewholder(var binding: HistoryitemBinding) :RecyclerView.ViewHolder(binding.root) {

     }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Historycoinviewholder {
return Historycoinviewholder(HistoryitemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
     }

     override fun getItemCount() =ListHistory.size

     override fun onBindViewHolder(holder: Historycoinviewholder, position: Int) {
         var timestamp=Timestamp(ListHistory.get(position).timeAndDate.toLong())
         holder.binding.status.text=if (ListHistory.get(position).iswithdrawal){"- Money withdrawal"}else{"+ Money added"}
          holder.binding.time.text=ListHistory[position].timeAndDate
          holder.binding.coins.text=ListHistory[position].coin


     }
 }