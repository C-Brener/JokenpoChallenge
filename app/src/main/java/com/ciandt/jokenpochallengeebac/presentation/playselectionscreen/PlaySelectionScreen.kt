package com.ciandt.jokenpochallengeebac.presentation.playselectionscreen

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.ciandt.jokenpochallengeebac.R
import com.ciandt.jokenpochallengeebac.databinding.ActivityPlaySelectionScreenBinding
import com.ciandt.jokenpochallengeebac.presentation.initialscreen.MainActivity
import com.ciandt.jokenpochallengeebac.presentation.result.ResultActivity
import com.google.android.material.snackbar.Snackbar

class PlaySelectionScreen : AppCompatActivity() {
    private lateinit var binding: ActivityPlaySelectionScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaySelectionScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        spinner()
        setupClickListener()
        setSupportActionBar(binding.toolbar)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home_option -> {
                onBackPressed()
                true
            }
            else -> {
                false
            }
        }
    }

    private fun setupClickListener() {
        with(binding) {
            bottomNavigation.setOnItemSelectedListener {
                bottomNavigationMovement(it)
                true
            }
        }
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

    private fun bottomNavigationMovement(it: MenuItem) {
        when (it.itemId) {
            R.id.player_one -> {
                playScreenStart()
            }
            R.id.result -> {
                resultScreenStart()
            }
        }
    }

    private fun playScreenStart() {
        Snackbar.make(binding.root, "Você já está na tela de Player one", Snackbar.LENGTH_SHORT)
            .show()
    }

    private fun resultScreenStart() {
        val intent2 = Intent(this, ResultActivity::class.java)
        startActivity(intent2)
    }
}