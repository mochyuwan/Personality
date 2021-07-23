package com.example.personality

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var ikuti1: TextView
    lateinit var btnikt:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnikt = findViewById(R.id.btnikutitest)

        btnikt.setOnClickListener {
            val pindah = Intent(this, QuizActivity::class.java)
            startActivity(pindah)
        }
    }
}