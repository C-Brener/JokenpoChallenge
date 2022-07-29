package com.ciandt.jokenpochallengeebac.presentation.initialscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ciandt.jokenpochallengeebac.databinding.FragmentInitialScreenBinding

class InitialScreen : Fragment() {
    private var _binding: FragmentInitialScreenBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentInitialScreenBinding.inflate(inflater, container, false)


        binding.buttonInit.setOnClickListener {
            val action = InitialScreenDirections.actionInitialScreenToNavigation()
            findNavController().navigate(action)

        }

        return binding.root
    }

//    private fun setupActionBar() {
//        setSupportActionBar(binding.toolbar)
//        supportActionBar?.title = getString(R.string.app_name_initial_screen)
//    }
//    private fun navigationIntent(){
//        val intent = Intent(this, HomeFragment::class.java)
//        startActivity(intent)
//    }
}

