package com.natiqhaciyef.abb_hw_2.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.natiqhaciyef.abb_hw_2.R
import com.natiqhaciyef.abb_hw_2.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragmentBottomView) as NavHostFragment

        NavigationUI.setupWithNavController(binding.bottomNavigationView, navHostFragment.navController)

    }
}