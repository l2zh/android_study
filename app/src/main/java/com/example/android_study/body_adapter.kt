package com.example.android_study

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android_study.databinding.ItemSlideBinding

class body_adapter(context: Context):
    RecyclerView.Adapter<body_adapter.bodyViewholder>() {

    private val inflater by lazy { LayoutInflater.from(context) }
    private var bodyList: List<body_data> = emptyList()


    class bodyViewholder(
        private val binding: ItemSlideBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: body_data) {
            binding.ivBodypic.setImageDrawable(binding.root.context.getDrawable(data.image))
            binding.tvBodyname.text = data.bodyname
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): body_adapter.bodyViewholder {
        val binding = ItemSlideBinding.inflate(inflater, parent, false)
        return body_adapter.bodyViewholder(binding)
    }

    override fun onBindViewHolder(holder: body_adapter.bodyViewholder, position: Int) {
        holder.onBind(bodyList[position])
    }

    override fun getItemCount(): Int = bodyList.size


    fun setbodyList(bodyList: List<body_data>) {
        this.bodyList = bodyList.toList()
        notifyDataSetChanged()
    }

}