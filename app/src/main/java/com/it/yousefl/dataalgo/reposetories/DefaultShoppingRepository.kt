package com.it.yousefl.dataalgo.reposetories

import androidx.lifecycle.LiveData
import com.it.yousefl.dataalgo.data.local.ShoppingDao
import com.it.yousefl.dataalgo.data.local.ShoppingItem
import com.it.yousefl.dataalgo.data.remote.PixabayAPI
import com.it.yousefl.dataalgo.data.remote.responses.ImageResponse
import com.it.yousefl.dataalgo.other.Resource
import retrofit2.Response
import java.lang.Exception
import javax.inject.Inject

class DefaultShoppingRepository @Inject constructor(
    private val shoppingDao: ShoppingDao,
    private val pixabayAPI: PixabayAPI
) :ShoppingRepository{
    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.insertShoppingItem(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.deleteShoppingItem(shoppingItem)
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
       return shoppingDao.observeAllShoppingItems()
    }

    override fun observeTotalPrice(): LiveData<Float> {
      return  shoppingDao.observeTotalPrice()
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ImageResponse> {
       return try {
                    val response=pixabayAPI.searchForImage(imageQuery)
           if (response.isSuccessful){
               response.body()?.let {
                 return@let  Resource.success(it)
               }?:Resource.error("An unknown error accourd",null)
           }else {
               Resource.error("An unknown error accourd",null)
           }
       }catch (exception:Exception){
            Resource.error("Could fetch data",null)
       }
    }
}