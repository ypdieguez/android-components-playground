package com.example.androidtest.vo


import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "users", primaryKeys = ["id"])
data class User(
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String
)