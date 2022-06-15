package com.ciandt.jokenpochallengeebac.presentation.result

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.ciandt.jokenpochallengeebac.R
import com.ciandt.jokenpochallengeebac.databinding.ActivityResultBinding
import com.google.android.material.snackbar.Snackbar

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupClickListener()
    }

    private fun setupClickListener() {
        with(binding) {
            bottomNavigation.setOnItemSelectedListener {
                bottomNavigationMovement(it)
                true
            }
        }
    }

    private fun bottomNavigationMovement(item: MenuItem) {
        when (item.itemId){
            R.id.player_one->{
                playScreenStart()
            }
            R.id.result->{
                resultScreenStart()
            }
        }
    }
    private fun playScreenStart() {
       onBackPressed()
    }

    private fun resultScreenStart(){
        Snackbar.make(binding.root, "Você já está na tela de Resultado", Snackbar.LENGTH_SHORT)
            .show()
    }
}