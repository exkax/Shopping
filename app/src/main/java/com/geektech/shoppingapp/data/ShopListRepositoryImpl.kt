package com.geektech.shoppingapp.data

import com.geektech.shoppingapp.domain.entity.ShopItem
import com.geektech.shoppingapp.domain.repository.ShopListRepository
import kotlin.random.Random

class ShopListRepositoryImpl : ShopListRepository {

    private val shopList = sortedSetOf<ShopItem>({ o1, o2 ->
        o1.id.compareTo(o2.id)
    })
    private var autoIncrementId = 0

    init {
        for (i in 1..100) {
            addShopItem(ShopItem("potato", i, Random.nextBoolean()))
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
            println(autoIncrementId)
        }
        shopList.add(shopItem)
    }

    override fun removeShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getShopItem(shopItem.id)
        removeShopItem(oldElement)
        addShopItem(shopItem)
    }

    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("element not found")
    }

    override fun getShopList(): List<ShopItem> {
        return shopList.toList()
    }
}