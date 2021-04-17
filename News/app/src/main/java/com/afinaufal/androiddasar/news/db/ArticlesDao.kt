package com.afinaufal.androiddasar.news.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.afinaufal.androiddasar.news.model.Article

@Dao
interface ArticlesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article):Long

    @Query("SELECT * FROM articles")
    fun getAllArticle():LiveData<List<Article>>


    @Delete
    suspend fun deleteArticle(article: Article)


}