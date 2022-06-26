package ru.omysin.gbdictionary.ui.dictionarylist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.qualifier.named
import ru.omysin.gbdictionary.databinding.DictionaryListFragmentBinding
import ru.omysin.gbdictionary.utils.hideKeyboard

class DictionaryListFragment : Fragment() {
    private var _binding: DictionaryListFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DictionaryViewModel by viewModel()
    private val adapter: DictionaryAdapter by inject(named("dictionary_adapter_rv"))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DictionaryListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.wordsListRecyclerView.adapter = adapter
        initView()
        initViewModelEvents()
        initAction()
    }

    private fun initAction() {
        adapter.listenerClick = DictionaryAdapter.OnWordClickListener { word ->
            findNavController().navigate(
                DictionaryListFragmentDirections.actionDictionaryListFragmentToDictionaryWordDetailFragment(
                    word
                )
            )
        }
    }

    private fun initView() {
        binding.searchTextInputLayout.setEndIconOnClickListener {
            view?.hideKeyboard()
            val searchWord = binding.searchTextInputEditText.text.toString()
            viewModel.updateWordsListRepo(searchWord)
        }
    }

    private fun initViewModelEvents() {
        viewModel.wordsList.observe(viewLifecycleOwner) { wordsList ->
            adapter.setData(wordsList)
        }
        viewModel.inProgress.observe(viewLifecycleOwner) { inProgress ->
            binding.progressBarFrameLayout.isVisible = inProgress
            binding.wordsListRecyclerView.isVisible = !inProgress
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}