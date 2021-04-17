package com.afinaufal.androiddasar.news.db

import androidx.room.TypeConverter
import com.afinaufal.androiddasar.news.model.Source

class Converter {

    @TypeConverter
    fun fromSource(source: Source):String{
        return source.name
    }


    @TypeConverter
    fun toSource(string: String): Source {
        return Source(string, string)
    }
}