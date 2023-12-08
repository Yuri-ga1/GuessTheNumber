package com.example.guessthenumber

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class GameActivity : AppCompatActivity() {
    private lateinit var question:TextView
    private var begin:Int = 0
    private var end:Int = 0
    private var guessedNumber:Int = 0
    private var isFinished:Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.guess_number_window)
        question = findViewById(R.id.question)


        begin = intent.getIntExtra("begin", 0)
        end = intent.getIntExtra("end", 100)
        setNewQuestion()
    }

    fun yesBtnOnClick(view: View){
        if(!isFinished){
            begin = guessedNumber + 1
            setNewQuestion()
        } else {
            question.text = "Your number is $guessedNumber"
        }
    }

    fun noBtnOnClick(view: View){
        if (!isFinished){
            end = guessedNumber
            setNewQuestion()
        } else {
            question.text = "I think you're lie at me"
        }
    }

    private fun setNewQuestion(){
        if (begin - end != 0){
            guessedNumber = (begin+end)/2
            val newQuestion = "The number is greater than $guessedNumber?"
            question.text = newQuestion
        } else {
            isFinished = true
            guessedNumber = begin
            val newQuestion = "The number is greater than $guessedNumber?"
            question.text = newQuestion
        }
    }
}