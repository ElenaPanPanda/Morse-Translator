package com.example.morsetranslator.fragments

import android.graphics.Typeface
import android.os.Bundle
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.StyleSpan
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.morsetranslator.Adapter
import com.example.morsetranslator.R
import com.example.morsetranslator.databinding.FragmentMorseCodeBinding


class MorseCodeFragment : Fragment(R.layout.fragment_morse_code) {
    private lateinit var binding: FragmentMorseCodeBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMorseCodeBinding.bind(view)

        binding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 3)
            adapter = Adapter()
        }

        setAlphabetRules()

    }

    private fun setAlphabetRules() {
        val text = getString(R.string.alphabet_rules)
        val spannableString = SpannableStringBuilder(text)

        val start1 = 27
        val end1 = 36

        val start2 = 63
        val end2 = 71

        spannableString.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start1, end1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(StyleSpan(Typeface.BOLD_ITALIC), start2, end2, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)

        binding.rulesTv.text = spannableString
    }
}