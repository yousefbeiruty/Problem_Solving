package com.it.yousefl.dataalgo.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.LEFT
import androidx.recyclerview.widget.ItemTouchHelper.RIGHT
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.it.yousefl.dataalgo.R
import com.it.yousefl.dataalgo.adapters.ShoppingItemAdapter
import kotlinx.android.synthetic.main.fragment_shopping.*
import javax.inject.Inject

class ShoppingFragment @Inject constructor(
    val shoppingItemAdapter: ShoppingItemAdapter,
    var viewModel: ShoppingViewModel?=null //here we added to make a test environment for our fragment because of the fake repository to work
) : Fragment(R.layout.fragment_shopping) {


  //  lateinit var viewModel: ShoppingViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //we want to bind our viewModel to our activity for its survives if our fragments are destroyed
        //since we share this viewModel between all of aur fragments
        viewModel = viewModel ?: ViewModelProvider(requireActivity()).get(ShoppingViewModel::class.java)
        subscribeToObservers()
        setRC()
        fabAddShoppingItem.setOnClickListener {
            findNavController().navigate(ShoppingFragmentDirections.actionShoppingFragmentToAddShoppingItemFragment())
        }
    }

    private val itemTouchCallBack = object : ItemTouchHelper.SimpleCallback(
        0, LEFT or RIGHT
    ) {
        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ) = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            val position = viewHolder.layoutPosition
            val item = shoppingItemAdapter.shoppingItems[position]
            viewModel?.deleteShoppingItem(item)
            Snackbar.make(requireView(), "Item deleted", Snackbar.LENGTH_LONG).apply {
                setAction("Undo") {
                    viewModel?.insertShoppingItemIntoDb(item)
                }
            }.show()
        }
    }

    private fun subscribeToObservers(){
        viewModel?.shoppingItems?.observe(viewLifecycleOwner, Observer {
            shoppingItemAdapter.shoppingItems=it
        })

        viewModel?.totalPrice?.observe(viewLifecycleOwner, Observer {
            val price=it ?: 0f
            val priceText="Total Price: $price$"
            tvShoppingItemPrice.text=priceText
        })
    }

    private fun setRC(){
        rvShoppingItems.apply {
            adapter=shoppingItemAdapter
            layoutManager=LinearLayoutManager(requireContext())
            ItemTouchHelper(itemTouchCallBack).attachToRecyclerView(this)
        }
    }
}