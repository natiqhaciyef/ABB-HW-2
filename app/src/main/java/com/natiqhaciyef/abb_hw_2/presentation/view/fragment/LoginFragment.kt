package com.natiqhaciyef.abb_hw_2.presentation.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.natiqhaciyef.abb_hw_2.R
import com.natiqhaciyef.abb_hw_2.databinding.FragmentLoginBinding
import com.natiqhaciyef.abb_hw_2.presentation.viewmodel.LoginViewModel


class LoginFragment : Fragment() {
    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loginButton.setOnClickListener {
            val username = binding.nameText.text
            val password = binding.passwordText.text
            if (username.isNotEmpty() && password.isNotEmpty()) {
                viewModel.checkUser(username.toString(), password.toString()){
                   findNavController().navigate(R.id.homeScreen)
                }
            }
        }

        binding.goToRegisterFragment.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.registerFragment)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}