package com.ciandt.jokenpochallengeebac.presentation.initialscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ciandt.jokenpochallengeebac.R
import com.ciandt.jokenpochallengeebac.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setupActionBar()
        setContentView(binding.root)
    }

    private fun setupActionBar(){
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = getString(R.string.app_name_initial_screen)
    }
}

