package com.natiqhaciyef.abb_hw_2.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart_item_model")
data class CartItemModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var name: String,
    var image: String,
    var price: Int,
    var count: Int,
)
