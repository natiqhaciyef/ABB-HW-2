package com.natiqhaciyef.abb_hw_2.data.repository

import android.content.Context
import com.natiqhaciyef.abb_hw_2.data.model.CartItemModel
import com.natiqhaciyef.abb_hw_2.data.model.UserModel
import com.natiqhaciyef.abb_hw_2.data.roomdb.AppDao
import com.natiqhaciyef.abb_hw_2.data.roomdb.DatabaseInstance

class DatabaseRepository(
    var dao: AppDao
) {
    fun getUsers(name: String, password: String) = dao.getUser(name,password)

    fun insertUser(userModel: UserModel) = dao.insertUser(userModel)

    fun deleteUser(userModel: UserModel) = dao.deleteUser(userModel)

    fun getCartItems() = dao.getCartItems()

    fun insertCartItem(cartItemModel:CartItemModel) = dao.insertCartItem(cartItemModel)

    fun deleteCartItem(cartItemModel:CartItemModel) = dao.deleteCartItem(cartItemModel)
}