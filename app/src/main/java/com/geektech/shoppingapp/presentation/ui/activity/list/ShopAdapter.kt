package com.geektech.shoppingapp.presentation.ui.activity.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.shoppingapp.databinding.ItemNotShopBinding
import com.geektech.shoppingapp.databinding.ItemShopBinding
import com.geektech.shoppingapp.domain.entity.ShopItem
import com.google.android.material.snackbar.Snackbar

private const val LAYOUT_TRUE = 0
private const val LAYOUT_FALSE = 1

class ShopAdapter(private val onClickItem: (shopItem: ShopItem) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var list = listOf<ShopItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        try {
            when (viewType) {
                LAYOUT_TRUE -> {
                    return ShopViewHolder(
                        ItemShopBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        )
                    )
                }
                LAYOUT_FALSE -> {
                    return NotShopViewHolder(
                        ItemNotShopBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                        )
                    )
                }
            }
        } catch (e: IllegalStateException) {
            Snackbar.make(parent, "An error has occurred, wait", Snackbar.LENGTH_SHORT).show()
        }
        throw RuntimeException("Not Found")
    }

    override fun getItemViewType(position: Int): Int {
        return when (list[position].enable) {
            true -> LAYOUT_TRUE
            false -> LAYOUT_FALSE
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        try {
            when (getItemViewType(position)) {
                LAYOUT_TRUE -> (holder as ShopViewHolder).onBind(list[position])
                LAYOUT_FALSE -> (holder as NotShopViewHolder).onBind(list[position])
            }
        } catch (e: IllegalStateException) {
            Snackbar.make(holder.itemView, "An error has occurred, wait", Snackbar.LENGTH_SHORT)
                .show()
        }
    }

    override fun getItemCount() = list.size

    fun setList(list: List<ShopItem>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class ShopViewHolder(private val binding: ItemShopBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(shopItem: ShopItem) {
            binding.tvCount.text = shopItem.count.toString()
            binding.tvName.text = shopItem.name.toString()

            binding.root.setOnLongClickListener {
                onClickItem(shopItem)
                return@setOnLongClickListener true
            }
        }
    }

    inner class NotShopViewHolder(private val binding: ItemNotShopBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(shopItem: ShopItem) {
            binding.tvCount.text = shopItem.count.toString()
            binding.tvName.text = shopItem.name.toString()

            binding.root.setOnLongClickListener {
                onClickItem(shopItem)
                return@setOnLongClickListener true
            }
        }
    }
}