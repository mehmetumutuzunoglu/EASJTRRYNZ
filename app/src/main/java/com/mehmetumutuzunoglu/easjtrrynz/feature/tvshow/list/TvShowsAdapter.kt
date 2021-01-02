package com.mehmetumutuzunoglu.easjtrrynz.feature.tvshow.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mehmetumutuzunoglu.easjtrrynz.databinding.ItemTvShowBinding

class TvShowsAdapter(
    private val clickListener: TvShowsItemClickListener?
) : RecyclerView.Adapter<TvShowsAdapter.TvShowItemViewHolder>() {

    private var itemList = arrayListOf<TvShowItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowItemViewHolder {
        val binding = ItemTvShowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowItemViewHolder(binding, clickListener)
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
        private val binding: ItemTvShowBinding,
        private val clickListener: TvShowsItemClickListener?
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: TvShowItem) {
            binding.item = item
            binding.root.setOnClickListener{
                clickListener?.onItemClick(item.itemData.itemId)
            }
        }
    }
}