package com.example.roomdatabase

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class TypeConvertors {

    @TypeConverter
    fun fromStringToArrayList(value: String): ArrayList<String> {
        return Gson().fromJson(value, object : TypeToken<ArrayList<String>>() {}.type)
    }

    @TypeConverter
    fun fromArrayListToString(value: ArrayList<String>): String {
        return Gson().toJson(value)
    }
}