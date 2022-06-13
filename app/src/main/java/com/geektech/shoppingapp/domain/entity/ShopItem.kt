package com.geektech.shoppingapp.domain.entity

data class ShopItem(
    val name: String?,
    val count: Int?,
    val enable: Boolean,
    var id: Int = UNDEFINED_ID
) {
    companion object {
        const val UNDEFINED_ID = 0
    }
}