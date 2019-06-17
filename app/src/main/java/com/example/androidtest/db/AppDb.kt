package com.example.androidtest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidtest.vo.Comment
import com.example.androidtest.vo.Post
import com.example.androidtest.vo.User

/**
 * Main database.
 */
@Database(
    entities = [
        Post::class,
        User::class,
        Comment::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDb : RoomDatabase() {
    abstract fun postDao(): PostDao
    abstract fun userDao():UserDao
    abstract fun commentDao(): CommentDao
}