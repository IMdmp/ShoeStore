package com.udacity.shoestore.shoedetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeListViewModel
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    lateinit var binding: FragmentShoeDetailBinding
    lateinit var shoeListViewModel: ShoeListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_shoe_detail, container, false)
        binding = FragmentShoeDetailBinding.bind(root)

        shoeListViewModel = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.btnAddShoe.setOnClickListener {
            val shoeName = binding.etShoeName.text.toString()
            val shoeSize: Double = binding.etShoeSize.text.toString().toDouble()
            val company = binding.etCompany.text.toString()
            val description = binding.etDesciption.text.toString()

            shoeListViewModel.addShoe(Shoe(shoeName,shoeSize,company,description))
            findNavController().navigate(R.id.action_shoeDetailFragment_to_shoeListFragment)
        }



        return binding.root
    }
}