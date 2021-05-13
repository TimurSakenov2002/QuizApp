package com.taiyabali.basictruefalsequizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.taiyabali.basictruefalsequizapp.databinding.ActivityStartBinding

class StartActivity : AppCompatActivity() {


    private lateinit var binding: ActivityStartBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityStartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStartQuiz.setOnClickListener {

            val intent=Intent(this,PlayActivity::class.java)
            startActivity(intent)
        }
    }
}