package com.afinaufal.androiddasar.news.db

import android.content.Context
import androidx.room.*
import com.afinaufal.androiddasar.news.model.Article

@Database(
    entities = [Article::class],
    version = 1
)

@TypeConverters(Converter::class)
abstract class ArticleDatabase: RoomDatabase(){

    abstract fun getAllArticleDao():ArticlesDao

    companion object{
        var instance:ArticleDatabase? = null
        val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance?:createDatabase(context).also{
                instance = it
            }
        }

        fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,
            ArticleDatabase::class.java,
            "ArticleDB"
        ).build()
    }

}