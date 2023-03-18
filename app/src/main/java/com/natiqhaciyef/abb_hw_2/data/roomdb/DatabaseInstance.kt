package com.natiqhaciyef.abb_hw_2.data.roomdb

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase

object DatabaseInstance {
    fun getDao(context:Context) =
        Room.databaseBuilder(context,AppDatabase::class.java,"app_database")
            .build()
            .getDao()
}