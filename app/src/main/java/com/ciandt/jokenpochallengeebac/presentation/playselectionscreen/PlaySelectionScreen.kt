package com.ciandt.jokenpochallengeebac.presentation.playselectionscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ciandt.jokenpochallengeebac.R
import com.ciandt.jokenpochallengeebac.databinding.ActivityMainBinding
import com.ciandt.jokenpochallengeebac.databinding.ActivityPlaySelectionScreenBinding

class PlaySelectionScreen : AppCompatActivity() {
    private lateinit var  binding: ActivityPlaySelectionScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaySelectionScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}