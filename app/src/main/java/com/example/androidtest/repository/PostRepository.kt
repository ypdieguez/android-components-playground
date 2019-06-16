package com.example.androidtest.repository

import androidx.lifecycle.LiveData
import com.example.androidtest.AppExecutors
import com.example.androidtest.api.JSONPlaceholderService
import com.example.androidtest.db.PostDao
import com.example.androidtest.vo.Post
import com.example.androidtest.vo.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PostRepository @Inject constructor(
    private val appExecutors: AppExecutors,
    private val postDao: PostDao,
    private val jsonPlaceholderService: JSONPlaceholderService
) {

    fun loadRepos(): LiveData<Resource<List<Post>>> {
        return object : NetworkBoundResource<List<Post>, List<Post>>(appExecutors) {
            override fun saveCallResult(item: List<Post>) {
                postDao.insertPosts(item)
            }

            override fun shouldFetch(data: List<Post>?): Boolean {
                return data == null || data.isEmpty()
            }

            override fun loadFromDb() = postDao.loadPosts()

            override fun createCall() = jsonPlaceholderService.getPosts()

        }.asLiveData()
    }

}