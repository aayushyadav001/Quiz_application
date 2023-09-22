package com.example.quiz.model

 class Historymodelclass{
    var timeAndDate: String=""
    var coin:String=""
     var iswithdrawal:Boolean = false
     constructor()
     constructor(timeAndDate: String, coin: String, iswithdrawal:Boolean) {
         this.timeAndDate = timeAndDate.toString()
         this.coin = coin
         this.iswithdrawal = iswithdrawal
     }
 }
