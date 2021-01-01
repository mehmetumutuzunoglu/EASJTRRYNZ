package com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mehmetumutuzunoglu.easjtrrynz.databinding.ItemTvShowBinding

class TvShowsAdapter : RecyclerView.Adapter<TvShowsAdapter.TvShowItemViewHolder>() {

    private var itemList = arrayListOf<TvShowItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowItemViewHolder {
        val binding = ItemTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowItemViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount() = itemList.size

    fun addList(list: List<TvShowItem>) {
        itemList.addAll(list)
        notifyDataSetChanged()
    }

    class TvShowItemViewHolder(
        private val binding: ItemTvShowBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TvShowItem) {
            binding.item = item
        }

    }
}