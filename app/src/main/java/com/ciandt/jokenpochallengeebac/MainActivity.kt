package com.ciandt.jokenpochallengeebac

import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.ciandt.jokenpochallengeebac.databinding.ActivityMainBinding
import com.ciandt.jokenpochallengeebac.presentation.playselectionscreen.TAG
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var bottomNavigationView: BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        drawerLayout = binding.root

        setupNavigationComponent()
        setupActionBar()
        setupVisibilityBottomNavigation()
        setBottomNavigationController()
        setDrawerLayoutNavigationController()
        setContentView(binding.root)
    }

    private fun setDrawerLayoutNavigationController() {
        val drawerLayout = binding.navigationView
        drawerLayout.setupWithNavController(navController)
    }

    private fun setupActionBar() {
        appBarConfiguration =
            AppBarConfiguration(
                setOf(
                    R.id.playSelectionFragment,
                    R.id.resultFragment
                ),
                drawerLayout
            )
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    private fun setBottomNavigationController() {
        bottomNavigationView = binding.bottomNavigation
        bottomNavigationView.setupWithNavController(navController)
    }

    private fun setupNavigationComponent() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_graph_jokenpo) as NavHostFragment
        navController = navHostFragment.navController
    }

    private fun setupVisibilityBottomNavigation() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.initialScreen -> {
                    binding.bottomNavigation.visibility = View.GONE
                }
                else -> {
                    binding.bottomNavigation.visibility = View.VISIBLE
                }
            }

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putString("State","Texto")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG,"Passou pelo estado de resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG,"Passou pelo estado de pause")

    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG,"Passou pelo estado de Stop")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"Passou pelo estado de Destroy")

    }

}