package com.natiqhaciyef.abb_hw_2.presentation.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.natiqhaciyef.abb_hw_2.data.model.UserModel
import com.natiqhaciyef.abb_hw_2.data.repository.DatabaseRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(application: Application): AndroidViewModel(application) {
    private val context = getApplication<Application>().applicationContext
    var repository = DatabaseRepository(context)

    fun checkUser(username: String, password:String) =
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("USER CHECKER","${repository.getUsers(username, password)}")
            repository.getUsers(username, password)
        }

}