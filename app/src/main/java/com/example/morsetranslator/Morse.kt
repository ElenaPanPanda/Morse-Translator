package com.example.morsetranslator

import android.util.Log

data class Code(
    val char: Char,
    val symbols: String
)

object Morse {
    val CODE = listOf(
        Code('A', ".-"),
        Code('B', "-..."),
        Code('C', "-.-."),
        Code('D', "-.."),
        Code('E', "."),
        Code('F', "..-."),
        Code('G', "--."),
        Code('H', "...."),
        Code('I', ".."),
        Code('J', ".---"),
        Code('K', "-.-"),
        Code('L', ".-.."),
        Code('M', "--"),
        Code('N', "-."),
        Code('O', "---"),
        Code('P', ".--."),
        Code('Q', "--.-"),
        Code('R', ".-."),
        Code('S', "..."),
        Code('T', "-"),
        Code('U', "..-"),
        Code('V', "...-"),
        Code('W', ".--"),
        Code('X', "-..-"),
        Code('Y', "-.--"),
        Code('Z', "--.."),
        Code('0', "-----"),
        Code('1', ".----"),
        Code('2', "..---"),
        Code('3', "...--"),
        Code('4', "....-"),
        Code('5', "....."),
        Code('6', "-...."),
        Code('7', "--..."),
        Code('8', "---.."),
        Code('9', "----."),
        )


    private val SPACE = Code(' ', "   ")

    const val DIVIDER = '|'

    private const val UNKNOWN = '?'

    private fun containsChar(c: Char): Code? {
        for (code in CODE) {
            if (c == code.char) return code
        }
        return null
    }

    private fun containsSymbols(s: String): Code? {
        for (code in CODE) {
            if (s == code.symbols) return code
        }
        return null
    }


    fun translateToMorse(string: String): String {
        val array = string.uppercase().toCharArray()
        val morseCode = mutableListOf<String>()

        Log.d("msg", array.joinToString(""))


        for (c in array) {
            if (c == SPACE.char) {
                morseCode.add(SPACE.symbols)
            } else {
                val code = containsChar(c)

                if (code != null) {
                    morseCode.add(code.symbols)
                } else morseCode.add(UNKNOWN.toString())
            }
        }

        Log.d("msg", morseCode.toString())

        return morseCode.joinToString(" ")
    }


    fun translateFromMorse(string: String): String {
        val text = mutableListOf<String>()
        val wordsSymbolsList = string.split("   ")

        for (wordSymbols in wordsSymbolsList) {
            var word = ""
            val symbolsList = wordSymbols.split(" ")

            for (symbols in symbolsList) {
                val code = containsSymbols(symbols)
                word += code?.char ?: UNKNOWN
            }
            text.add(word)
        }

        return text.joinToString(" ")
    }
}
