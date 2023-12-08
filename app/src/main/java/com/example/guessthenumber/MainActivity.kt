package com.example.guessthenumber

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var from:EditText
    private lateinit var to:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        from = findViewById(R.id.fromTextInput)
        to = findViewById(R.id.toTextInput)
    }

    fun onStartClick(view: View){
        val intent = Intent(this, GameActivity::class.java)

        var begin:Int
        var end:Int

        if (from.text.toString().isEmpty()){
            begin = 0
        } else {
            begin = Integer.parseInt(from.text.toString())
        }

        if (to.text.toString().isEmpty()){
            end = 100
        } else {
            end = Integer.parseInt(to.text.toString())
        }

        if (end<begin){
            val buff = end
            end = begin
            begin = buff
        }

        intent.putExtra("begin", begin)
        intent.putExtra("end", end)
//        Toast.makeText(this, "$intent", Toast.LENGTH_SHORT).show()
        Log.i("intent", intent.toString())
        startActivity(intent)
    }
}