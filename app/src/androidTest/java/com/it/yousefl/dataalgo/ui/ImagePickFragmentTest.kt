package com.it.yousefl.dataalgo.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.FragmentFactory
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import com.google.common.truth.Truth.assertThat
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.MediumTest
import com.it.yousefl.dataalgo.R
import com.it.yousefl.dataalgo.adapters.ImageAdapter
import com.it.yousefl.dataalgo.getOrAwaitValue
import com.it.yousefl.dataalgo.lunchFragmentInHiltContainer
import com.it.yousefl.dataalgo.repositories.FakeShoppingRepositoryAndroidTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify
import javax.inject.Inject

@MediumTest
@ExperimentalCoroutinesApi
@HiltAndroidTest
class ImagePickFragmentTest{

    @get:Rule
    var instantTaskExecutorRule=InstantTaskExecutorRule()

    @get:Rule
    var hiltRule=HiltAndroidRule(this)

    @Inject
    lateinit var fragmentFactory: ShoppingFragmentFactory


    @Before
    fun setUp(){
        hiltRule.inject()
    }

    @Test
    fun clickImage_popBackStackSetImageUrl(){
        val imageUrl="Test"
      val navController=mock(NavController::class.java)
        val testViewModel=ShoppingViewModel(FakeShoppingRepositoryAndroidTest())
      lunchFragmentInHiltContainer<ImagePickFragment>(fragmentFactory = fragmentFactory){
          Navigation.setViewNavController(requireView(),navController)
          imageAdapter.images= listOf(imageUrl)
          viewModel=testViewModel
      }
        onView(withId(R.id.rvImages)).perform(
            RecyclerViewActions.actionOnItemAtPosition<ImageAdapter.ImageViewHolder>(
                0,
                click()
            )
        )

        verify(navController).popBackStack()
        assertThat(testViewModel.currentImageUrl.getOrAwaitValue()).isEqualTo(imageUrl)
    }
}