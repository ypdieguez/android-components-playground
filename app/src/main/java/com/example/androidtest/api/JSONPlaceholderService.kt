package com.example.androidtest.api

import androidx.lifecycle.LiveData
import com.example.androidtest.vo.Comment
import com.example.androidtest.vo.Post
import com.example.androidtest.vo.User
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * REST API access points
 */
interface JSONPlaceholderService {
    @GET("posts")
    fun getPosts(): LiveData<ApiResponse<List<Post>>>

    @GET("users/{id}")
    fun getUser(@Path("id") id: Int): LiveData<ApiResponse<User>>

    @GET("comments")
    fun getComments(@Query("postId") postId: Int): LiveData<ApiResponse<List<Comment>>>
}
