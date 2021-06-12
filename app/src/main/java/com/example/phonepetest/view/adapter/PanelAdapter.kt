package com.example.phonepetest.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.phonepetest.databinding.LayoutCharItemBinding

class PanelAdapter(val delegate: (String) -> Unit) : ListAdapter<String, PanelAdapter.PanelViewHolder>(
    object: DiffUtil.ItemCallback<String>(){
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
           return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
)

 {
     inner class PanelViewHolder(val binding: LayoutCharItemBinding) :
         RecyclerView.ViewHolder(binding.root) {
         fun bind(item: String) {
             binding.character = item
             binding.btnKey.setOnClickListener {
                 val input = "${binding.btnKey.text}"
                 if (input.isNotEmpty()) {
                     delegate(input)
                 }
                 binding.btnKey.text = ""
             }

         }
    }

     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PanelViewHolder {
         val binding =
             LayoutCharItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
         return PanelViewHolder(binding)
     }

    override fun onBindViewHolder(holder: PanelViewHolder, position: Int) = holder.bind(getItem(position))

}