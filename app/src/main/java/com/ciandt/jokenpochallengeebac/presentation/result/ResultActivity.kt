package com.ciandt.jokenpochallengeebac.presentation.result

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.ciandt.jokenpochallengeebac.R
import com.ciandt.jokenpochallengeebac.databinding.ActivityResultBinding
import com.ciandt.jokenpochallengeebac.presentation.initialscreen.MainActivity
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navDrawer: NavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        setupToolbar()
        setupClickListener()
        drawerLayout = binding.root
        navDrawer = binding.navigationView
        setupDrawer()

    }

    override fun onSupportNavigateUp(): Boolean {
        drawerLayout.openDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.home_option -> {
                val intent = Intent(this, MainActivity::class.java)
                navigateUpTo(intent)
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

    private fun bottomNavigationMovement(item: MenuItem) {
        when (item.itemId) {
            R.id.player_one -> {
                playScreenStart()
            }
            R.id.result -> {
                resultScreenStart()
            }
        }
    }

    private fun playScreenStart() {
        onBackPressed()
    }

    private fun resultScreenStart() {
        Snackbar.make(binding.root, "Você já está na tela de Resultado", Snackbar.LENGTH_SHORT)
            .show()
    }

    private fun setupToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_baseline_menu)
    }

    private fun setupDrawer() {
        navDrawer.setNavigationItemSelectedListener { menuItem ->
            drawerLayout.closeDrawers()
            when (menuItem.itemId) {
                R.id.player_one_navigation_drawer -> {
                    onBackPressed()
                    true
                }
                else -> {
                    Snackbar.make(
                        binding.root,
                        "Você está na tela selecionada",
                        Snackbar.LENGTH_SHORT
                    ).show()
                    true
                }
            }
        }
    }

}