package com.ciandt.jokenpochallengeebac.presentation.playselectionscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.ciandt.jokenpochallengeebac.R
import com.ciandt.jokenpochallengeebac.databinding.ActivityMainBinding
import com.ciandt.jokenpochallengeebac.databinding.ActivityPlaySelectionScreenBinding
import com.google.android.material.snackbar.Snackbar

class PlaySelectionScreen : AppCompatActivity() {
    private lateinit var binding: ActivityPlaySelectionScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaySelectionScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        spinner()
        bottomNavigationMovement()

    }

    private fun spinner() {
        val spinner: Spinner = binding.spinner
        ArrayAdapter.createFromResource(
            this,
            R.array.jogadas,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    private fun bottomNavigationMovement() {
        val bottomNavigationView = binding.bottomNavigation

        bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.player_one -> {
                    navigationIntent()
                    true
                }
                else -> {
                    Snackbar.make(binding.root, "Result Screen", Snackbar.LENGTH_SHORT).show()
                    true
                }
            }

        }
    }

    private fun navigationIntent() {
        val intent = Intent(this, PlaySelectionScreen::class.java)
        startActivity(intent)
    }
}