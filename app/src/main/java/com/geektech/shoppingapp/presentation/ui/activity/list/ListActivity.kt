package com.geektech.shoppingapp.presentation.ui.activity.list

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.shoppingapp.R
import com.geektech.shoppingapp.databinding.ActivityListBinding
import com.geektech.shoppingapp.domain.entity.ShopItem
import com.geektech.shoppingapp.presentation.ui.activity.main.MainViewModel
import kotlinx.coroutines.launch

class ListActivity : AppCompatActivity(R.layout.activity_list) {

    private val binding: ActivityListBinding by viewBinding()
    private val viewModel: MainViewModel by viewModels()
    private val adapter = ShopAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initAdapter()
        initViewModel()
    }

    private fun initViewModel() {
        lifecycleScope.launch {
            adapter.setList(viewModel.getShopList() as MutableList<ShopItem>)
            Log.d(ContentValues.TAG, "initListeners: ${viewModel.getShopList()}")
        }
    }

    private fun initAdapter() {
        binding.listRv.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@ListActivity)
            adapter = this@ListActivity.adapter
        }
    }
}