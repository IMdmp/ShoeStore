package com.udacity.shoestore.shoelist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import timber.log.Timber

class ShoeListFragment: Fragment() {

    lateinit var fragmentShoeListBinding: FragmentShoeListBinding
    lateinit var shoeListViewModel: ShoeListViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_shoe_list,container,false)
        fragmentShoeListBinding = FragmentShoeListBinding.bind(root)
        shoeListViewModel  = ViewModelProvider(this).get(ShoeListViewModel::class.java)
        fragmentShoeListBinding.shoeListViewModel = shoeListViewModel

        shoeListViewModel.eventAddShoe.observe(viewLifecycleOwner, Observer { addShoe->
            if(addShoe){
                findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
                shoeListViewModel.onAddShoeEventComplete()
            }
        })

        shoeListViewModel._shoeList.observe(viewLifecycleOwner, Observer { shoeList->
            Timber.d("shoe size: ${shoeList.size}")
        })



        return fragmentShoeListBinding.root
    }



}