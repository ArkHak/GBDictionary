package ru.omysin.gbdictionary.ui.dictionaryworddetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import coil.api.load
import ru.omysin.gbdictionary.databinding.DictionaryWordDetailFragmentBinding

class DictionaryWordDetailFragment : DialogFragment() {
    private val args by navArgs<DictionaryWordDetailFragmentArgs>()
    private val word by lazy { args.word }

    private var _binding: DictionaryWordDetailFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DictionaryWordDetailFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.titleWordTextView.text = word.text
        binding.meaningWord.text = word.meanings?.get(0)?.translation?.text
        binding.posterWordImageView.load("https:${word.meanings?.get(0)?.imageUrl}")
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}