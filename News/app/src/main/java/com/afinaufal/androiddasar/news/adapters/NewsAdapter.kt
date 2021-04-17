package com.afinaufal.androiddasar.news.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.afinaufal.androiddasar.news.databinding.ListBeritaBinding
import com.afinaufal.androiddasar.news.model.Article
import com.bumptech.glide.Glide

class NewsAdapter:RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    class NewsViewHolder(val binding:ListBeritaBinding):RecyclerView.ViewHolder(binding.root) {

    }

    val differCallback = object :DiffUtil.ItemCallback<Article>(){
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder(ListBeritaBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.binding.apply {
            tvTitleNews.text = differ.currentList[position].title
            tvValueNews.text = differ.currentList[position].description
            Glide.with(this.root)
                .load(differ.currentList[position].urlToImage).into(ivNews)

            setOnItemClickListener {
                setOnClickListener?.let { it(differ.currentList[position]) }
            }
        }
    }

    override fun getItemCount() = differ.currentList.size


    private var setOnClickListener:((Article)->Unit)? = null

    fun setOnItemClickListener(listener:(Article)->Unit){
        setOnClickListener = listener
    }

}