package com.ciandt.jokenpochallengeebac.presentation.result

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.ciandt.jokenpochallengeebac.databinding.FragmentResultBinding
import com.ciandt.jokenpochallengeebac.presentation.playselectionscreen.TAG
import com.google.android.material.navigation.NavigationView

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navDrawer: NavigationView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)


        return binding.root
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