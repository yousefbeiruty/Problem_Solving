package com.it.yousefl.dataalgo.reposetories

import androidx.lifecycle.LiveData
import com.it.yousefl.dataalgo.data.local.ShoppingItem
import com.it.yousefl.dataalgo.data.remote.responses.ImageResponse
import com.it.yousefl.dataalgo.other.Resource
import retrofit2.Response

interface ShoppingRepository {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems():LiveData<List<ShoppingItem>>

    fun observeTotalPrice():LiveData<Float>

    suspend fun searchForImage(imageQuery:String): Resource<ImageResponse>
}