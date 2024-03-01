package com.example.morsetranslator.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.morsetranslator.R
import com.example.morsetranslator.databinding.FragmentTranslatorBinding


class TranslatorFragment : Fragment(R.layout.fragment_translator) {
    private lateinit var binding: FragmentTranslatorBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTranslatorBinding.bind(view)

        binding.textEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {


            }
        })


        binding.morseEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {


            }
        })


        binding.clearBtn.setOnClickListener {
            clear()
        }

        binding.guideBtn.setOnClickListener {
            findNavController().navigate(R.id.MorseCodeFragment)
        }


    }

    private fun clear() {
        binding.textEt.setText("")
        binding.morseEt.setText("")
    }
}