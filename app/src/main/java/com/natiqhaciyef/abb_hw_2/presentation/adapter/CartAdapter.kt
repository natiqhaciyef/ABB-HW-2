package com.natiqhaciyef.abb_hw_2.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.natiqhaciyef.abb_hw_2.data.model.CartItemModel
import com.natiqhaciyef.abb_hw_2.databinding.RecyclerCartRowBinding

class CartAdapter(val mContext: Context, val list: MutableList<CartItemModel?>)
    : RecyclerView.Adapter<CartAdapter.CartHolder>() {

    inner class CartHolder(val binding: RecyclerCartRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartHolder {
        val binding = RecyclerCartRowBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CartHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CartHolder, position: Int) {
        val view = holder.binding
        val cartItem = list[position]

        cartItem?.let {
            view.cartCountText.text = "Qyt: ${it.count}"
            view.cartNameText.text = it.name
            view.cartTotalPriceText.text = "Rs ${it.price * it.count}"
            Glide.with(mContext).load(it.image).into(view.cartImageView)
        }
    }
}