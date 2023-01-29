package com.example.android_study

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_study.databinding.ItemClothesBinding


class clothes_adapter(context: Context) :
    RecyclerView.Adapter<clothes_adapter.clothesViewHolder>() {

    private val inflater by lazy { LayoutInflater.from(context) }
    private var clothesList: List<clothes_data> = emptyList()

    class clothesViewHolder(
        private val binding: ItemClothesBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(data: clothes_data) {
            binding.ivClothes.setImageDrawable(binding.root.context.getDrawable(data.image))
            binding.tvTitle.text = data.title
            binding.tvPrice.text = data.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): clothesViewHolder {
        val binding = ItemClothesBinding.inflate(inflater, parent, false)
        return clothesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: clothesViewHolder, position: Int) {
        holder.onBind(clothesList[position])
    }

    override fun getItemCount(): Int = clothesList.size

    fun setclothesList(clothesList: List<clothes_data>) {
        this.clothesList = clothesList.toList()
        notifyDataSetChanged()
    }
}
