package com.geektech.shoppingapp.presentation.ui.activity.main

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geektech.shoppingapp.R
import com.geektech.shoppingapp.databinding.ActivityMainBinding
import com.geektech.shoppingapp.domain.entity.ShopItem

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val viewModel: MainViewModel by viewModels()
    private val binding: ActivityMainBinding by viewBinding(ActivityMainBinding::bind)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initListeners()
    }

    private fun initListeners() {
        binding.apply {
            btnEditItem.setOnClickListener {
                viewModel.editShopItem(
                    ShopItem(
                        "potato",
                        14,
                        false,
                        binding.etItem.text.toString().toInt()
                    )
                )
            }
            btnRemoveItem.setOnClickListener {
                viewModel.removeShopItem(
                    ShopItem(
                        "tomato",
                        10,
                        false,
                        binding.etItem.text.toString().toInt()
                    )
                )
            }
            btnGetItem.setOnClickListener {
                viewModel.getShopItem(ShopItem(binding.etItem.text.toString(), 14, false, 14))
                Log.d(
                    TAG,
                    "initListeners: ${
                        viewModel.getShopItem(
                            ShopItem(
                                binding.etItem.text.toString(),
                                14,
                                false,
                                binding.etItem.text.toString().toInt()
                            )
                        )
                    }"
                )

            }
            btnGetList.setOnClickListener {
                Log.d(TAG, "initListeners: ${viewModel.getShopList()}")
            }
            btnAddItem.setOnClickListener {
                viewModel.addShopItem(ShopItem(binding.etItem.text.toString(), 10, false))
            }
        }
    }
}