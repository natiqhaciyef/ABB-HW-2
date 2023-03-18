package com.natiqhaciyef.abb_hw_2.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.natiqhaciyef.abb_hw_2.R
import com.natiqhaciyef.abb_hw_2.databinding.FragmentDetailsBinding
import kotlinx.android.synthetic.main.activity_main.*


class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_details, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().bottomNavigationView.visibility = View.GONE
        val data: DetailsFragmentArgs by navArgs()
        val itemModel = data.itemModel
        binding.itemModel = itemModel
        binding.itemDetailsPrice.text = itemModel.price.toString()
        Glide.with(requireView()).load(itemModel.image).into(binding.itemImageView)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}