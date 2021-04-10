package com.it.yousefl.dataalgo.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.it.yousefl.dataalgo.data.local.ShoppingItem
import com.it.yousefl.dataalgo.data.remote.responses.ImageResponse
import com.it.yousefl.dataalgo.other.Resource
import com.it.yousefl.dataalgo.reposetories.ShoppingRepository


class FakeShoppingRepositoryAndroidTest : ShoppingRepository {

    private val shoppingItems = mutableListOf<ShoppingItem>()

    private val observableShoppingItems = MutableLiveData<List<ShoppingItem>>(shoppingItems)
    private val observableTotalPrice = MutableLiveData<Float>()

    private var shouldReturnANetworkError = false

    fun setshouldReturnANetworkError(value: Boolean) {
        shouldReturnANetworkError = value
    }

    private fun refreshLiveData() {
        observableShoppingItems.postValue(shoppingItems)
        observableTotalPrice.postValue(getTotalPrice())
    }

    private fun getTotalPrice(): Float {
        return shoppingItems.sumByDouble {
            it.price.toDouble()
        }.toFloat()
    }

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingItems.add(shoppingItem)
        refreshLiveData()
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingItems.remove(shoppingItem)
        refreshLiveData()
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
        return observableShoppingItems
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return observableTotalPrice
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
     return if (shouldReturnANetworkError){
         Resource.error("Error",null)
     }else{
         Resource.success(ImageResponse(listOf(),0,0))
     }
    }
}