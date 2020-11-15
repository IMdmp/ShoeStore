package com.udacity.shoestore.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionBinding

class InstructionFragment : Fragment() {

    lateinit var fragmentInstructionBinding: FragmentInstructionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentInstructionBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.fragment_instruction,
            container,
            false)
        fragmentInstructionBinding.instructionFragment= this
        return fragmentInstructionBinding.root
    }

    fun onNextSelected() {
        findNavController().navigate(R.id.action_instructionFragment_to_shoeListFragment)
    }
}