package ru.omysin.gbdictionary.ui.dictionarylist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.omysin.gbdictionary.domain.entitys.WordEntity

class DictionaryAdapter : RecyclerView.Adapter<DictionaryVH>() {
    private var data: List<WordEntity> = emptyList()

    fun setData(words: List<WordEntity>) {
        data = words
        notifyDataSetChanged()
    }

    var listenerClick: OnWordClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryVH {
        return DictionaryVH.create(parent)
    }

    override fun onBindViewHolder(holder: DictionaryVH, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            listenerClick?.onWordClick(getItem(position))
        }
    }

    private fun getItem(position: Int): WordEntity = data[position]

    override fun getItemCount(): Int = data.size

    fun interface OnWordClickListener {
        fun onWordClick(word: WordEntity)
    }
}