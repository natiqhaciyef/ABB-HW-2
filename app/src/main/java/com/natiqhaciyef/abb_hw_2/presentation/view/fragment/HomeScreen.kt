package com.natiqhaciyef.abb_hw_2.presentation.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.natiqhaciyef.abb_hw_2.R
import com.natiqhaciyef.abb_hw_2.data.util.ItemList
import com.natiqhaciyef.abb_hw_2.databinding.FragmentHomeScreenBinding
import com.natiqhaciyef.abb_hw_2.presentation.adapter.ItemAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class HomeScreen : Fragment() {
    private var _binding: FragmentHomeScreenBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ItemAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().bottomNavigationView.visibility = View.VISIBLE
        requireActivity().topBar.visibility = View.VISIBLE
        adapter = ItemAdapter(requireContext(), ItemList.itemList)
        binding.recyclerItemView.adapter = adapter
        binding.recyclerItemView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)

        adapter.onClick = {
            val action = HomeScreenDirections.actionHomeScreenToDetailsFragment(it)
            findNavController().navigate(action)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}