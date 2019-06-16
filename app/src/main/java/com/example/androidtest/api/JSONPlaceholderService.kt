package com.example.androidtest.api

import androidx.lifecycle.LiveData
import com.example.androidtest.vo.Post
import retrofit2.http.GET

/**
 * REST API access points
 */
interface JSONPlaceholderService {
    @GET("posts")
    fun getPosts(): LiveData<ApiResponse<List<Post>>>
}
