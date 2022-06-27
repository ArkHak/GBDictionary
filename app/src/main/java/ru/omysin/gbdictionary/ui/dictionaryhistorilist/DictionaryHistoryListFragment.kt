package ru.omysin.gbdictionary.ui.dictionaryhistorilist

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
import ru.omysin.gbdictionary.databinding.DictionaryHistoryListFragmentBinding
import ru.omysin.gbdictionary.utils.converterDHistoryEntityToDialogWordEntity

class DictionaryHistoryListFragment : Fragment() {
    private var _binding: DictionaryHistoryListFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DictionaryHistoryListViewModel by viewModel()
    private val adapter: DictionaryHistoryAdapter by inject(named("history_dictionary_adapter_rv"))

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DictionaryHistoryListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAction()

        binding.wordsHistoryListRecyclerView.adapter = adapter
        viewModel.allWordsHistoryListRepo()

        viewModel.wordsHistoryList.observe(viewLifecycleOwner) { wordsHistoryList ->
            adapter.setData(wordsHistoryList)
        }
        viewModel.inProgress.observe(viewLifecycleOwner) { inProgress ->
            binding.progressHistoryBarFrameLayout.isVisible = inProgress
            binding.wordsHistoryListRecyclerView.isVisible = !inProgress
        }
    }

    private fun initAction() {
        adapter.listenerClick = DictionaryHistoryAdapter.OnWordClickListener { word ->
            findNavController().navigate(
                DictionaryHistoryListFragmentDirections.actionDictionaryHistoryListFragmentToDictionaryWordDetailFragment(
                    converterDHistoryEntityToDialogWordEntity(word)
                )
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}