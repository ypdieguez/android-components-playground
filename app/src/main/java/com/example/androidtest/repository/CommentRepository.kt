package com.example.androidtest.repository

import androidx.lifecycle.LiveData
import com.example.androidtest.AppExecutors
import com.example.androidtest.api.ApiResponse
import com.example.androidtest.api.JSONPlaceholderService
import com.example.androidtest.db.CommentDao
import com.example.androidtest.vo.Comment
import com.example.androidtest.vo.Resource
import javax.inject.Inject

class CommentRepository @Inject constructor(
    private val appExecutors: AppExecutors,
    private val commentDao: CommentDao,
    private val jsonPlaceholderService: JSONPlaceholderService
) {

    fun loadComments(postId: Int): LiveData<Resource<List<Comment>>> {
        return object : NetworkBoundResource<List<Comment>, List<Comment>>(appExecutors) {
            override fun saveCallResult(item: List<Comment>) = commentDao.insert(item)

            override fun shouldFetch(data: List<Comment>?) = data == null || data.isEmpty()

            override fun loadFromDb() = commentDao.getComments(postId)

            override fun createCall(): LiveData<ApiResponse<List<Comment>>> = jsonPlaceholderService.getComments(postId)
        }.asLiveData()
    }
}