package com.example.morsetranslator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val letter: TextView = view.findViewById(R.id.letter)
        val divider: TextView = view.findViewById(R.id.divider)
        val symbols: TextView = view.findViewById(R.id.symbols)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_letter, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return Morse.CODE.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val code = Morse.CODE[position]

        holder.letter.text = code.char.toString()
        holder.divider.text = Morse.DIVIDER
        holder.symbols.text = code.symbols
    }
}