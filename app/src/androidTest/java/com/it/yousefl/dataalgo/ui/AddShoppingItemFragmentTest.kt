package com.it.yousefl.dataalgo.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.google.common.truth.Truth.assertThat
import com.it.yousefl.dataalgo.R
import com.it.yousefl.dataalgo.data.local.ShoppingItem
import com.it.yousefl.dataalgo.getOrAwaitValue
import com.it.yousefl.dataalgo.lunchFragmentInHiltContainer
import com.it.yousefl.dataalgo.repositories.FakeShoppingRepositoryAndroidTest
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.android.synthetic.main.item_image.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import javax.inject.Inject

@ExperimentalCoroutinesApi
@MediumTest
@HiltAndroidTest
class AddShoppingItemFragmentTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()//this is for test liveData

    @Inject
    lateinit var fragmentFactory: ShoppingFragmentFactory


    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun clickInsertIntoDb(){
        val testViewModel=ShoppingViewModel(FakeShoppingRepositoryAndroidTest())
        lunchFragmentInHiltContainer<AddShoppingItemFragment>(fragmentFactory = fragmentFactory) {
             viewModel=testViewModel
        }

        onView(withId(R.id.etShoppingItemName)).perform(replaceText("Shopping item"))
        onView(withId(R.id.etShoppingItemAmount)).perform(replaceText("1"))
        onView(withId(R.id.etShoppingItemPrice)).perform(replaceText("10"))
        onView(withId(R.id.btnAddShoppingItem)).perform(click())

        assertThat(testViewModel.shoppingItems.getOrAwaitValue())
            .contains(ShoppingItem("Shopping item",1,10f,""))
    }

    @Test
    fun pressNavButton_popBackStack() {
        val navController = mock(NavController::class.java)
        lunchFragmentInHiltContainer<AddShoppingItemFragment> {
            Navigation.setViewNavController(requireView(), navController)
        }
        pressBack()
        verify(navController).popBackStack()
    }

    @Test
    fun navigateToImagePickFragment() {
        val navController = mock(NavController::class.java)
        lunchFragmentInHiltContainer<AddShoppingItemFragment> {
            Navigation.setViewNavController(requireView(), navController)
        }
        onView(ViewMatchers.withId(R.id.ivShoppingImage)).perform(ViewActions.click())
        verify(navController).navigate(
            AddShoppingItemFragmentDirections.actionAddShoppingItemFragmentToImagePickFragment()
        )
    }




}