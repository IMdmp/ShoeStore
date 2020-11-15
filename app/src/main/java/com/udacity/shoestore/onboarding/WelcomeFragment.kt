package com.udacity.shoestore.onboarding

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding

class WelcomeFragment : Fragment() {

    lateinit var fragmentWelcomeBinding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentWelcomeBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_welcome,
            container, false
        )

        fragmentWelcomeBinding.welcomeFragment = this
        return fragmentWelcomeBinding.root
    }

    fun onNextSelected() {
        Log.i("TAg","selected!")
        findNavController().navigate(R.id.action_welcomeFragment_to_instructionFragment)
    }
}