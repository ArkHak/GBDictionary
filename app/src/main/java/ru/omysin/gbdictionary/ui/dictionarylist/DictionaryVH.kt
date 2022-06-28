package ru.omysin.gbdictionary.ui.dictionarylist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import ru.omysin.domain.entitys.WordEntity
import ru.omysin.gbdictionary.databinding.ItemWordsListBinding

class DictionaryVH(private val binding: ItemWordsListBinding) :
    RecyclerView.ViewHolder(binding.root) {
    companion object {
        fun create(parent: ViewGroup): DictionaryVH {
            val inflater = LayoutInflater.from(parent.context)
            return DictionaryVH(ItemWordsListBinding.inflate(inflater))
        }
    }

    fun bind(item: WordEntity) {
        binding.headerRecyclerItemTextview.text = item.text
        binding.descriptionRecyclerItemTextview.text =
            item.meanings?.get(0)?.translation?.text
        binding.avatarItemWordListImageView.load("https:${item.meanings?.get(0)?.imageUrl}")
    }
}