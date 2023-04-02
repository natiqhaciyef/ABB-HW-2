package com.natiqhaciyef.abb_hw_2.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.natiqhaciyef.abb_hw_2.R
import com.natiqhaciyef.abb_hw_2.data.model.UserModel
import com.natiqhaciyef.abb_hw_2.databinding.FragmentRegisterBinding
import com.natiqhaciyef.abb_hw_2.presentation.viewmodel.RegisterViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RegisterViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.goToLoginFragment.setOnClickListener {
            findNavController().navigate(R.id.loginFragment)
        }

        binding.registerButton.setOnClickListener {
            val username = binding.nameText.text
            val email = binding.emailText.text
            val password = binding.passwordText.text
            if (
                username.isNotEmpty() &&
                email.isNotEmpty() &&
                password.isNotEmpty()
            ) {
                viewModel.insertUser(
                    UserModel(
                        id = 0,
                        name = username.toString(),
                        email = email.toString(),
                        password = password.toString()
                    )
                ){
                    findNavController().navigate(R.id.loginFragment)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}