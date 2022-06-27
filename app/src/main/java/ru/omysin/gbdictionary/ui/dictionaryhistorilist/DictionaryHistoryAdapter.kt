package ru.omysin.gbdictionary.ui.dictionaryhistorilist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.omysin.domain.entitys.DHistoryEntity

class DictionaryHistoryAdapter : RecyclerView.Adapter<DictionaryHistoryListVH>() {
    private var data: List<DHistoryEntity> = emptyList()

    fun setData(words: List<DHistoryEntity>) {
        data = words
        notifyDataSetChanged()
    }

    var listenerClick: OnWordClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DictionaryHistoryListVH {
        return DictionaryHistoryListVH.create(parent)
    }

    override fun onBindViewHolder(holder: DictionaryHistoryListVH, position: Int) {
        holder.bind(getItem(position))
        holder.itemView.setOnClickListener {
            listenerClick?.onWordClick(getItem(position))
        }
    }

    private fun getItem(position: Int): DHistoryEntity = data[position]

    override fun getItemCount(): Int = data.size

    fun interface OnWordClickListener {
        fun onWordClick(word: DHistoryEntity)
    }
}