package ru.omysin.gbdictionary.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import ru.omysin.gbdictionary.R
import ru.omysin.gbdictionary.databinding.ItemWordsListBinding
import ru.omysin.gbdictionary.domain.entitys.WordEntity

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
        Picasso.get()
            .load("https:${item.meanings?.get(0)?.imageUrl}")
            .error(R.drawable.img_item_word_default)
            .into(binding.avatarItemWordListImageView)
    }
}