package com.natiqhaciyef.abb_hw_2.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.abb_hw_2.data.model.UserModel
import com.natiqhaciyef.abb_hw_2.data.repository.DatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext
    var repository = DatabaseRepository(context)

    fun checkUser(username: String, password: String, content: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            var user = repository.getUsers(username, password)
            withContext(Dispatchers.Main){
                if (user != null)
                    content()
            }
        }
    }

}