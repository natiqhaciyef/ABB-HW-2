package com.natiqhaciyef.abb_hw_2.data.roomdb

import androidx.room.Database
import androidx.room.RoomDatabase
import com.natiqhaciyef.abb_hw_2.data.model.CartItemModel
import com.natiqhaciyef.abb_hw_2.data.model.UserModel

@Database(entities = [UserModel::class, CartItemModel::class], version = 2)
abstract class AppDatabase: RoomDatabase() {
    abstract fun getDao(): AppDao
}