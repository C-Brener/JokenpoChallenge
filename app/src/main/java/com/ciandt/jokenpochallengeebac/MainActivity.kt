package com.ciandt.jokenpochallengeebac

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.ciandt.jokenpochallengeebac.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var bottomNavigationView: BottomNavigationView
    var currentPlayer: String = "Pedra"
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
        drawerLayout.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.resultFragment ->{
                    val args = Bundle()
                    args.putString("currentPlay", currentPlayer)
                    navController.navigate(it.itemId, args)
                }
                else -> navController.navigate(it.itemId)
            }
            true
        }
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
        bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.resultFragment ->{
                    val args = Bundle()
                    args.putString("currentPlay", currentPlayer)
                    navController.navigate(it.itemId, args)
                }
                else -> navController.navigate(it.itemId)
            }
            true
        }
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

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        val availablePlays = resources.getStringArray(R.array.available_plays_array)
        currentPlayer =  availablePlays[p2]

        Toast.makeText(this, currentPlayer,Toast.LENGTH_SHORT).show()

    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

}