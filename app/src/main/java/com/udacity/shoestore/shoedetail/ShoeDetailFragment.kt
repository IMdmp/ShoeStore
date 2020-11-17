package com.udacity.shoestore.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding

class ShoeDetailFragment :Fragment(){

    lateinit var binding: FragmentShoeDetailBinding
    lateinit var shoeDetailViewModel: ShoeDetailViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_shoe_detail,container,false)
        binding = FragmentShoeDetailBinding.bind(root)
        shoeDetailViewModel =ViewModelProvider(this).get(ShoeDetailViewModel::class.java)

        binding.shoeDetailViewModel = shoeDetailViewModel

        shoeDetailViewModel.eventAddShoe.observe(viewLifecycleOwner,
            Observer { addShoe->
                if(addShoe){
                    val shoeName = binding.etShoeName.text.toString()

                    findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
                    shoeDetailViewModel.onAddShoeEventComplete()
                }
            })




        return binding.root
    }
}