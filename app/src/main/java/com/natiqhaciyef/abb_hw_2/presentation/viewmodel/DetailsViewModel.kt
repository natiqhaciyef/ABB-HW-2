package com.natiqhaciyef.abb_hw_2.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.abb_hw_2.data.model.CartItemModel
import com.natiqhaciyef.abb_hw_2.data.repository.DatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    application: Application,
    val repository: DatabaseRepository
) : AndroidViewModel(application) {

    fun insertCartItem(cartItemModel: CartItemModel){
        viewModelScope.launch(Dispatchers.Main) {
            withContext(Dispatchers.IO){
                repository.insertCartItem(cartItemModel)
            }
        }
    }

}