package com.geektech.shoppingapp.domain.usecases

import com.geektech.shoppingapp.domain.entity.ShopItem
import com.geektech.shoppingapp.domain.repository.ShopListRepository

class GetShopItemUseCase constructor(private val repository: ShopListRepository) {

    fun getShopItem(shopItemId: ShopItem): ShopItem {
        return repository.getShopItem(shopItemId.id)
    }
}