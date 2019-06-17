package com.example.androidtest.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidtest.vo.Comment

@Dao
interface CommentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(comments: List<Comment>)

    @Query("SELECT * FROM comments WHERE postId = :postId")
    fun getComments(postId: Int): LiveData<List<Comment>>
}