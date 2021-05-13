package com.taiyabali.basictruefalsequizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.taiyabali.basictruefalsequizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityResultBinding.inflate(layoutInflater)

        setContentView(binding.root)


        val message = intent.getStringExtra("correctAns")

        binding.scoredMsg.text=("Your scored $message out of 10")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}