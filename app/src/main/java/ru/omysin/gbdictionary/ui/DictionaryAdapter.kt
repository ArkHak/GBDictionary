package ru.omysin.gbdictionary.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.omysin.gbdictionary.domain.entitys.WordEntity

class DictionaryAdapter : RecyclerView.Adapter<DictionaryVH>() {
    private var data: List<WordEntity> = emptyList()

    fun setData(words: List<WordEntity>) {
        data = words
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryVH {
        return DictionaryVH.create(parent)
    }

    override fun onBindViewHolder(holder: DictionaryVH, position: Int) {
        holder.bind(getItem(position))
    }

    private fun getItem(position: Int): WordEntity = data[position]

    override fun getItemCount(): Int = data.size
}