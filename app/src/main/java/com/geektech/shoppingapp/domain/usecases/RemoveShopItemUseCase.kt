package com.geektech.shoppingapp.domain.usecases

import com.geektech.shoppingapp.domain.entity.ShopItem
import com.geektech.shoppingapp.domain.repository.ShopListRepository

class RemoveShopItemUseCase constructor(private val repository: ShopListRepository) {

    fun removeShopItem(shopItem: ShopItem) {
        repository.removeShopItem(shopItem)
    }
}