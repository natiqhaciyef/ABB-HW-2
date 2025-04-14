package com.natiqhaciyef.abb_hw_2.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.abb_hw_2.data.model.UserModel
import com.natiqhaciyef.abb_hw_2.data.repository.DatabaseRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application,
    var repository: DatabaseRepository
) : AndroidViewModel(application) {

    fun checkUser(username: String, password: String, content: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            val user = repository.getUsers(username, password)
            withContext(Dispatchers.Main){
                if (user != null)
                    content()
            }
        }
    }

}