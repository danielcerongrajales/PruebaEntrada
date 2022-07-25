package com.example.pruebaentrada.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.pruebaentrada.data.model.Product
import com.example.pruebaentrada.databinding.ProductItemBinding
import com.example.pruebaentrada.ui.utils.loadCoiler


class MovieAdapter() :
    ListAdapter<Product, MovieAdapter.MovieHolder>(MovieComparator){
    companion object {
        private val MovieComparator = object : DiffUtil.ItemCallback<Product>() {
            override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {

                return (
                        oldItem.id == newItem.id)
            }

            override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean =
                ( oldItem == newItem)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieHolder {
        val binding =
           ProductItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieHolder, position: Int) {
        getItem(position)?.let { holder.render(it) }
    }



    class MovieHolder(private val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun render(movie: Product) {
            binding.textView.text = movie.title
            binding.imageView.loadCoiler(movie.image,"#1339C1")
//            binding.root.setOnClickListener { listener(ActionUI.Click(movie)) }

        }

    }


}


