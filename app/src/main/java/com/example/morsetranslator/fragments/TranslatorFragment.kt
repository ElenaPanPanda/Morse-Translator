package com.example.morsetranslator.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.morsetranslator.Morse
import com.example.morsetranslator.R
import com.example.morsetranslator.databinding.FragmentTranslatorBinding


class TranslatorFragment : Fragment(R.layout.fragment_translator) {
    private lateinit var binding: FragmentTranslatorBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentTranslatorBinding.bind(view)


        var toMorse = true

        binding.switchBtn.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.inputLayout.hint = getString(R.string.morse)
                binding.isCheckedTv.setText(R.string.to_text)
                toMorse = false
            } else {
                binding.inputLayout.hint = getString(R.string.text)
                binding.isCheckedTv.setText(R.string.to_morse)
                toMorse = true
            }
        }



        binding.inputEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val result = if (toMorse)
                    Morse.translateToMorse(s.toString())
                else
                    Morse.translateFromMorse(s.toString())

                binding.resultEt.setText(result)

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
        binding.inputEt.setText("")
        binding.resultEt.setText("")
    }
}