package com.example.androidtest.di

import android.app.Application
import androidx.room.Room
import com.example.androidtest.api.JSONPlaceholderService
import com.example.androidtest.db.AppDb
import com.example.androidtest.db.CommentDao
import com.example.androidtest.db.PostDao
import com.example.androidtest.db.UserDao
import com.example.androidtest.util.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideJSONPlaceholderService(): JSONPlaceholderService {
        return Retrofit.Builder()
            .baseUrl("http://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(JSONPlaceholderService::class.java)
    }

    @Singleton
    @Provides
    fun provideDb(app: Application): AppDb {
        return Room
            .databaseBuilder(app, AppDb::class.java, "jsonplaceholder.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providePostDao(db: AppDb): PostDao {
        return db.postDao()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: AppDb): UserDao {
        return db.userDao()
    }

    @Singleton
    @Provides
    fun provideCommentDao(db: AppDb): CommentDao {
        return db.commentDao()
    }
}
