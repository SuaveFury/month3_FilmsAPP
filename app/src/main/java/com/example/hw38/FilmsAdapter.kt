package com.example.hw38

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw38.databinding.ItemFilmBinding


class FilmsAdapter(
    val filmList: ArrayList<Film>,
    val onclick: (position: Int) -> Unit
): RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmsViewHolder {
        return FilmsViewHolder(ItemFilmBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FilmsViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount(): Int = filmList.size
    inner class FilmsViewHolder(private val binding: ItemFilmBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(){
            val item = filmList[adapterPosition]
            binding.tvName.text = item.name
            binding.ivFilms.loadImage(item.image)

            itemView.setOnClickListener {
                onclick(adapterPosition)
            }
        }
    }
}