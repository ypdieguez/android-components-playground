package com.example.androidtest.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.androidtest.vo.Post

/**
 * Main database.
 */
@Database(
    entities = [
        Post::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDb : RoomDatabase() {
    abstract fun postDao(): PostDao
}