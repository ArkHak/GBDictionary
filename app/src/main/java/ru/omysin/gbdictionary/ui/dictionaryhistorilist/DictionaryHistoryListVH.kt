package ru.omysin.gbdictionary.ui.dictionaryhistorilist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import ru.omysin.domain.entitys.DHistoryEntity
import ru.omysin.gbdictionary.databinding.ItemWordsListBinding

class DictionaryHistoryListVH(private val binding: ItemWordsListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(parent: ViewGroup): DictionaryHistoryListVH {
            val inflater = LayoutInflater.from(parent.context)
            return DictionaryHistoryListVH(ItemWordsListBinding.inflate(inflater))
        }
    }

    fun bind(item: DHistoryEntity) {
        binding.headerRecyclerItemTextview.text = item.word
        binding.descriptionRecyclerItemTextview.text = item.description
        binding.avatarItemWordListImageView.load("https:${item.imageUrl}")
    }

}