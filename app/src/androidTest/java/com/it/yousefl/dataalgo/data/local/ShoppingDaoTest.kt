package com.it.yousefl.dataalgo.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.google.common.truth.Truth.assertThat
import com.it.yousefl.dataalgo.getOrAwaitValue
import com.it.yousefl.dataalgo.lunchFragmentInHiltContainer
import com.it.yousefl.dataalgo.ui.ShoppingFragment
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import javax.inject.Inject
import javax.inject.Named

@ExperimentalCoroutinesApi //its for coroutine
//@RunWith(AndroidJUnit4::class)//TODO:-this is to assure that will run on an emulator because is an instrumented test
@SmallTest /**Note: here they know that we also rite unit test  (Large test is annotation is for ui test if is annotated with Medium the is integrated test)*/
@HiltAndroidTest //this is for using hilt here
class ShoppingDaoTest {

    @get:Rule
    var hiltRule=HiltAndroidRule(this)

    //TODO:-this is for junit to know that this class need to run asynchronously for liveData
    @get:Rule
    var instantTaskExecutorRule=InstantTaskExecutorRule()

    @Inject
    @Named("test_db")
    lateinit var database: ShoppingItemDatabase
    private lateinit var dao: ShoppingDao

    @Before
    fun setUp(){
        //we use this inMemoryDatabaseBuilder to build a fake database just for testing in memory means
        // that only will hold the data in the Ram
//        database = Room.inMemoryDatabaseBuilder(
//                ApplicationProvider.getApplicationContext(),
//                ShoppingItemDatabase::class.java
//        ).allowMainThreadQueries().build()
        /**here we don't need to initialize our database we just did it in our module
         *instead we just need to use hiltRule.inject()
         * */
        hiltRule.inject()
        dao = database.shoppingDao()
    }

    @After
    fun tearDown(){
        database.close()//just to close the databse
    }



    @Test
    fun insertShoppingItem()= runBlockingTest{
        val shoppingItem=ShoppingItem("name",1,1f,"url",id = 1)
         dao.insertShoppingItem(shoppingItem)

        val allShopingItems=dao.observeAllShoppingItems().getOrAwaitValue()

        assertThat(allShopingItems).contains(shoppingItem)
    }

    @Test
    fun deleteShoppingItem()= runBlockingTest{
        val shoppingItem=ShoppingItem("name",1,1f,"url",id = 1)
        dao.insertShoppingItem(shoppingItem)
        dao.deleteShoppingItem(shoppingItem)

        val allShoppingItem=dao.observeAllShoppingItems().getOrAwaitValue()

        assertThat(allShoppingItem).doesNotContain(shoppingItem)
    }

    @Test
    fun observeTotalPriceSum()= runBlockingTest {
        val shoppingItem1=ShoppingItem("name",2,10f,"url",id = 1)
        val shoppingItem2=ShoppingItem("name",4,5.5f,"url",id = 2)
        val shoppingItem3=ShoppingItem("name",0,100f,"url",id = 3)
        dao.insertShoppingItem(shoppingItem1)
        dao.insertShoppingItem(shoppingItem2)
        dao.insertShoppingItem(shoppingItem3)

        val totalPriceSum=dao.observeTotalPrice().getOrAwaitValue()

       assertThat(totalPriceSum).isEqualTo(2*10f + 4*5.5f + 0*100)
    }
}