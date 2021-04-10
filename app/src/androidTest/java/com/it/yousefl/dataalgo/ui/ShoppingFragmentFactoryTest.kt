package com.it.yousefl.dataalgo.ui

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.RequestManager
import com.it.yousefl.dataalgo.adapters.ImageAdapter
import com.it.yousefl.dataalgo.adapters.ShoppingItemAdapter
import com.it.yousefl.dataalgo.repositories.FakeShoppingRepositoryAndroidTest
import javax.inject.Inject

class ShoppingFragmentFactoryTest @Inject constructor(
    private val imageAdapter: ImageAdapter,
    private val glide :RequestManager,
    private val shoppingItemAdapter: ShoppingItemAdapter
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when (className) {
            ImagePickFragment::class.java.name -> ImagePickFragment(imageAdapter)
            AddShoppingItemFragment::class.java.name->AddShoppingItemFragment(glide)
            ShoppingFragment::class.java.name->ShoppingFragment(shoppingItemAdapter,
            ShoppingViewModel(FakeShoppingRepositoryAndroidTest()))
            else -> super.instantiate(classLoader, className)
        }
    }

}