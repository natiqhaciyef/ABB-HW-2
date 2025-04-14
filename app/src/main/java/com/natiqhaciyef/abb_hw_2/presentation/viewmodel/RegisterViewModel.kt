package com.natiqhaciyef.abb_hw_2.presentation.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.abb_hw_2.data.model.UserModel
import com.natiqhaciyef.abb_hw_2.data.repository.DatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.coroutines.coroutineContext

@HiltViewModel
class RegisterViewModel @Inject constructor(
    application: Application,
    var repository: DatabaseRepository
) : AndroidViewModel(application) {

    fun insertUser(userModel: UserModel, content: () -> Unit){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertUser(userModel)
            withContext(Dispatchers.Main){
                content()
            }
        }
    }
}