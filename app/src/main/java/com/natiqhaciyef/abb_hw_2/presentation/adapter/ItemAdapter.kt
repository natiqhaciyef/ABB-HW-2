package com.natiqhaciyef.abb_hw_2.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.natiqhaciyef.abb_hw_2.data.model.ItemModel
import com.natiqhaciyef.abb_hw_2.databinding.RecyclerItemRowBinding

class ItemAdapter(val mContext: Context, val list: MutableList<ItemModel>) :
    RecyclerView.Adapter<ItemAdapter.ItemHolder>() {

    var onClick: ( (ItemModel) -> Unit)? = null
    inner class ItemHolder(val binding: RecyclerItemRowBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder {
        val binding = RecyclerItemRowBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return ItemHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        val view = holder.binding
        val item = list[position]

        view.itemNameText.text = item.name
        view.itemPriceText.text = "Rs ${item.price}"
        Glide.with(mContext).load(item.image).into(view.itemImage)

        holder.itemView.setOnClickListener {
            onClick?.invoke(item)
        }
    }
}