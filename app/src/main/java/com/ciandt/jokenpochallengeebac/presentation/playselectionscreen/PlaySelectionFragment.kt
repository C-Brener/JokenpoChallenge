package com.ciandt.jokenpochallengeebac.presentation.playselectionscreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.ciandt.jokenpochallengeebac.R
import com.ciandt.jokenpochallengeebac.databinding.FragmentPlaySelectionScreenBinding
import com.google.android.material.navigation.NavigationView


const val TAG = "LifeCycle"
class PlaySelectionFragment : Fragment() {
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navDrawerLayout: NavigationView
    private var _binding: FragmentPlaySelectionScreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPlaySelectionScreenBinding.inflate(inflater, container, false)

        spinner()
        return binding.root
    }

    private fun spinner() {
        val spinner: Spinner = binding.spinner
        ArrayAdapter.createFromResource(
            this@PlaySelectionFragment.context!!,
            R.array.jogadas,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG,"Passou pelo estado de Create")

    }
}