package com.example.androidtest.vo

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity(tableName = "comments", primaryKeys = ["id"])
data class Comment(
    @SerializedName("postId")
    val postId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("body")
    val body: String
)