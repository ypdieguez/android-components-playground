package com.example.androidtest.vo

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "posts", primaryKeys = ["id"])
data class Post(
    @SerializedName("userId")
    val userId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("body")
    val body: String
)