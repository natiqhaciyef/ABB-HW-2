package com.natiqhaciyef.abb_hw_2.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.abb_hw_2.data.model.CartItemModel
import com.natiqhaciyef.abb_hw_2.data.repository.DatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext
    val repository = DatabaseRepository(context)

    fun insertCartItem(cartItemModel: CartItemModel){
        viewModelScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO){
                repository.insertCartItem(cartItemModel)
            }
        }
    }

}