package com.udacity.shoestore.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding

class LoginFragment: Fragment() {

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_login, container, false)
        binding = FragmentLoginBinding.bind(root)
        binding.loginFragment = this
        return binding.root
    }

    fun onLoginSelected() {
        val email = binding.etEmail.text.toString()
        val password = binding.etPassword.toString()

        findNavController().navigate(R.id.action_loginFragment_to_welcomeFragment)

    }


    fun onCreateAccountSelected() {
        onLoginSelected()
    }
}