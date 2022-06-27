package ru.omysin.gbdictionary.ui.dictionaryworddetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import coil.ImageLoader
import coil.request.LoadRequest
import ru.omysin.gbdictionary.R
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
        binding.titleWordTextView.text = word.title
        binding.meaningWord.text = word.translation
        useLoadImage(binding.posterWordImageView, word.urlImage)
    }

    private fun useLoadImage(
        imageView: ImageView,
        imageLink: String,
    ) {
        val request = LoadRequest.Builder(requireContext())
            .data("https:$imageLink")
            .target(
                onStart = {
                    imageView.setImageResource(R.drawable.loading)
                },
                onSuccess = { result ->
                    imageView.setImageDrawable(result)
                },
                onError = {
                    imageView.setImageResource(R.drawable.img_item_word_default)
                }
            )
            .build()
        ImageLoader(requireContext()).execute(request)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}