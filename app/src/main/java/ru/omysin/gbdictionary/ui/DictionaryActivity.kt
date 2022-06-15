package ru.omysin.gbdictionary.ui

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.omysin.gbdictionary.databinding.DictionaryMainBinding


class DictionaryActivity : AppCompatActivity() {

    private lateinit var binding: DictionaryMainBinding
    private val viewModel: DictionaryViewModel by viewModel()

    private val adapter = DictionaryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DictionaryMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        initViews()
        initViewModelEvents()
    }

    private fun initViews() {
        binding.wordsListRecyclerView.adapter = adapter
    }

    private fun initViewModelEvents() {
        viewModel.wordsList.observe(this) { wordsList ->
            adapter.setData(wordsList)
        }
        viewModel.inProgress.observe(this) { inProgress ->
            binding.progressBarFrameLayout.isVisible = inProgress
            binding.wordsListRecyclerView.isVisible = !inProgress
        }
        binding.searchTextInputLayout.setEndIconOnClickListener {
            hideKeyboard(this)
            val searchWord = binding.searchTextInputEditText.text.toString()
            viewModel.updateWordsListRepo(searchWord)
        }
    }

    private fun hideKeyboard(activity: Activity) {
        val imm: InputMethodManager =
            activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        var view: View? = activity.currentFocus
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0)
    }


}
