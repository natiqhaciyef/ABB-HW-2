package com.natiqhaciyef.abb_hw_2.data.repository

import android.content.Context
import com.natiqhaciyef.abb_hw_2.data.model.UserModel
import com.natiqhaciyef.abb_hw_2.data.roomdb.DatabaseInstance

class DatabaseRepository(
    var context: Context
) {
    var dao = DatabaseInstance.getDao(context)

    fun getUsers(name: String, password: String) = dao.getUser(name,password)

    fun insertUser(userModel: UserModel) = dao.insertUser(userModel)

    fun deleteUser(userModel: UserModel) = dao.deleteUser(userModel)
}