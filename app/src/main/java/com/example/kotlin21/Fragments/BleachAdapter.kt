package com.example.kotlin21.Fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlin21.R
import com.example.kotlin21.databinding.ItembleachBinding

class BleachAdapter(val oncClick: OncClick) :
    RecyclerView.Adapter<BleachAdapter.BleachViewHolder>() {

    private var bleachList = mutableListOf<Anime>()

    fun setBleachList(marvelList: MutableList<Anime>) {
        this.bleachList = marvelList
    }

    inner class BleachViewHolder(private val binding: ItembleachBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBInd(anime: Anime) = with(binding) {
            binding.root.setOnClickListener {
                oncClick.onClick(anime)
            }
            Glide.with(ivAnime.context)
                .load(anime.image)
                .placeholder(R.drawable.imgnot)
                .into(ivAnime)
            tvName.text = anime.name.replace("[", "").replace("]", "")
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BleachViewHolder {
        val binding = ItembleachBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BleachViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BleachViewHolder, position: Int) {
        holder.onBInd(bleachList[position])
    }

    override fun getItemCount() = bleachList.size
}