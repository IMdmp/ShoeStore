package com.udacity.shoestore.shoelist

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeListViewModel
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import timber.log.Timber

class ShoeListFragment: Fragment() {

    lateinit var binding: FragmentShoeListBinding
    lateinit var shoeListViewModel: ShoeListViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_shoe_list,container,false)
        binding = FragmentShoeListBinding.bind(root)
        shoeListViewModel  = ViewModelProvider(requireActivity()).get(ShoeListViewModel::class.java)

        binding.shoeListViewModel = shoeListViewModel
        binding.fabAddShoe.setOnClickListener {
            shoeListViewModel.goAddShoe()
        }
        shoeListViewModel.eventAddShoe.observe(viewLifecycleOwner, Observer { addShoe ->
            if (addShoe) {
                findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
                shoeListViewModel.onAddShoeEventComplete()
            }
        })
        shoeListViewModel.shoeList.observe(viewLifecycleOwner, Observer { shoeList->
            Timber.d("shoe size: ${shoeList.size}")

            shoeList.forEach {shoe->
                val tv = TextView(context)
                tv.text = shoe.name
                binding.llShoeList.addView(tv)
            }
        })

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.account_menu, menu)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

}