package com.arsenbasha.testeo

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arsenbasha.testeo.databinding.RecycleviewRowBinding
import com.bumptech.glide.Glide


class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.myHolder>() {
    var item = ArrayList<RecyclerData>()
    fun setDataList(data: ArrayList<RecyclerData>) {
        this.item = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecycleviewRowBinding.inflate(layoutInflater)
        return myHolder(binding)
    }

    override fun getItemCount() = item.size

    override fun onBindViewHolder(holder: myHolder, position: Int) {
        holder.bind(item[position])
    }

    class myHolder(val binding: RecycleviewRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: RecyclerData) {
            binding.recycleView = data
            binding.executePendingBindings()
        }
    }

    companion object {
        @BindingAdapter("loadImage")
        fun loadImage(thubmImage: ImageView, url: String) {
            Glide.with(thubmImage)
                .load(url)
                .circleCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .error(R.drawable.ic_launcher_foreground)
                .fallback(R.drawable.ic_launcher_foreground)
                .into(thubmImage)
        }
    }
}