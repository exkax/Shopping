package com.geektech.shoppingapp.presentation.ui.activity.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.shoppingapp.databinding.ItemNotShopBinding
import com.geektech.shoppingapp.databinding.ItemShopBinding
import com.geektech.shoppingapp.domain.entity.ShopItem

private const val LAYOUT_ONE = 0
private const val LAYOUT_TWO = 1

class ShopAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list = mutableListOf<ShopItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            LAYOUT_ONE -> {
                return ShopViewHolder(
                    ItemShopBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            LAYOUT_TWO -> {
                return NotShopViewHolder(
                    ItemNotShopBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> throw RuntimeException("element not found")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position].enable) {
            true -> LAYOUT_ONE
            false -> LAYOUT_TWO
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        return when (getItemViewType(position)) {
            LAYOUT_ONE -> (holder as ShopViewHolder).onBind(list[position])
            LAYOUT_TWO -> (holder as NotShopViewHolder).onBind(list[position])
            else -> throw RuntimeException("element not found")
        }
    }

    override fun getItemCount() = list.size

    fun setList(list: MutableList<ShopItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class ShopViewHolder(private val binding: ItemShopBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(shopItem: ShopItem) {
            binding.tvCount.text = shopItem.count.toString()
            binding.tvName.text = shopItem.name.toString()
        }
    }

    inner class NotShopViewHolder(private val binding: ItemNotShopBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(shopItem: ShopItem) {
            binding.tvCount.text = shopItem.count.toString()
            binding.tvName.text = shopItem.name.toString()
        }
    }
}