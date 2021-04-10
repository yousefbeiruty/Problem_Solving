package com.it.yousefl.dataalgo.di

import android.content.Context
import androidx.room.Room
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.it.yousefl.dataalgo.R
import com.it.yousefl.dataalgo.data.local.ShoppingDao
import com.it.yousefl.dataalgo.data.local.ShoppingItemDatabase
import com.it.yousefl.dataalgo.data.remote.PixabayAPI
import com.it.yousefl.dataalgo.other.Constants.BASE_URL
import com.it.yousefl.dataalgo.other.Constants.DATABASE_NAME
import com.it.yousefl.dataalgo.reposetories.DefaultShoppingRepository
import com.it.yousefl.dataalgo.reposetories.ShoppingRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideRoomDatabase( @ApplicationContext contex: Context)= Room.databaseBuilder(contex,
    ShoppingItemDatabase::class.java,DATABASE_NAME).build()

    @Singleton
    @Provides
    fun provideDefaultShoppingRepository(
        dao: ShoppingDao,
        api: PixabayAPI
    )=DefaultShoppingRepository(dao,api) as ShoppingRepository


    @Singleton
    @Provides
    fun provideShoppingDao(database: ShoppingItemDatabase)=database.shoppingDao()

    @Singleton
    @Provides
    fun providePixabayApi():PixabayAPI{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(PixabayAPI::class.java)
    }

    @Singleton
    @Provides
    fun provideGlideInstance(@ApplicationContext context: Context)
    =Glide.with(context).setDefaultRequestOptions(
        RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
    )

}