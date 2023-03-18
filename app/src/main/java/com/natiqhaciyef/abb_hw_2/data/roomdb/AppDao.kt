package com.natiqhaciyef.abb_hw_2.data.roomdb

import androidx.room.*
import com.natiqhaciyef.abb_hw_2.data.model.UserModel

@Dao
interface AppDao {

    @Query("SELECT * FROM user_model WHERE name = :name AND password = :password")
    fun getUser(name: String, password: String): UserModel

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertUser(userModel: UserModel)

    @Delete
    fun deleteUser(userModel: UserModel)
}