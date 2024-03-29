package com.bayraktar.shopapp.repositories

import androidx.lifecycle.LiveData
import com.bayraktar.shopapp.data.local.ShoppingItem
import com.bayraktar.shopapp.data.remote.responses.ImageResponse
import com.bayraktar.shopapp.other.Resource

interface ShoppingRepository {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems(): LiveData<List<ShoppingItem>>

    fun observeTotalPrice(): LiveData<Float>

    suspend fun searchForImage(imageQuery: String): Resource<ImageResponse>
}