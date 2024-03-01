package com.example.morsetranslator.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.morsetranslator.R
import com.example.morsetranslator.databinding.FragmentMorseCodeBinding


class MorseCodeFragment : Fragment(R.layout.fragment_morse_code) {
    private lateinit var binding: FragmentMorseCodeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMorseCodeBinding.bind(view)




    }
}