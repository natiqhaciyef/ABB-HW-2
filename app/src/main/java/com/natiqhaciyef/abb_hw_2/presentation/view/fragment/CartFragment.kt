package com.natiqhaciyef.abb_hw_2.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.natiqhaciyef.abb_hw_2.R
import com.natiqhaciyef.abb_hw_2.data.model.CartItemModel
import com.natiqhaciyef.abb_hw_2.databinding.FragmentCartBinding
import com.natiqhaciyef.abb_hw_2.presentation.adapter.CartAdapter
import com.natiqhaciyef.abb_hw_2.presentation.viewmodel.CartViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {
    private var _binding : FragmentCartBinding? = null
    private val binding get() = _binding!!
    private lateinit var list: MutableList<CartItemModel?>
    private val viewModel:CartViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLiveData()

    }

    private fun observeLiveData(){
        viewModel.liveData.observe(viewLifecycleOwner){
            list = it
            val adapter = CartAdapter(requireContext(), list)
            binding.cartRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            binding.cartRecyclerView.adapter = adapter



            var totalPrice = 0
            list.forEach { it?.let { totalPrice += it.price } }
            binding.cartTotalPriceText.text = "Rs $totalPrice"
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}