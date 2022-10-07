package com.ciandt.jokenpochallengeebac.presentation.result

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.ciandt.jokenpochallengeebac.R
import com.ciandt.jokenpochallengeebac.databinding.FragmentResultBinding
import com.ciandt.jokenpochallengeebac.presentation.playselectionscreen.TAG
import com.ciandt.jokenpochallengeebac.utils.JokenpoEngine
import com.ciandt.jokenpochallengeebac.utils.Result
import com.google.android.material.navigation.NavigationView

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navDrawer: NavigationView
    lateinit var engine: JokenpoEngine
    lateinit var resultText: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentResultBinding.inflate(inflater, container, false)


        return binding.root
    }

    private fun updateResultText(currentPlay: String): String {
        return when (engine.calculateResult(currentPlay)) {
            Result.WIN -> "Você ganhou"
            Result.LOSS -> "Você perdeu"
            else -> "O jogo Empatou"
        }
    }

    override fun onResume() {
        super.onResume()
        engine = JokenpoEngine(resources.getStringArray(R.array.available_plays_array))

        val currentPlay = arguments?.getString("currentPlay")
        resultText = binding.playerWinner

        resultText.text =
            currentPlay?.let { updateResultText(it) }
        Log.i(TAG, "Passou pelo estado de resume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "Passou pelo estado de pause")

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