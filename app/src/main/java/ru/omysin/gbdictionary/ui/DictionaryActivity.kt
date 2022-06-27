package ru.omysin.gbdictionary.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import ru.omysin.gbdictionary.databinding.DictionaryMainBinding

class DictionaryActivity : AppCompatActivity() {

    private lateinit var binding: DictionaryMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = DictionaryMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
