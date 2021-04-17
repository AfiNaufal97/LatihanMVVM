package com.afinaufal.androiddasar.news.model

import com.afinaufal.androiddasar.news.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)