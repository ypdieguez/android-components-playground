package com.example.androidtest.ui.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.androidtest.repository.CommentRepository
import com.example.androidtest.repository.PostRepository
import com.example.androidtest.repository.UserRepository
import com.example.androidtest.vo.Post
import com.example.androidtest.vo.Resource
import javax.inject.Inject

class PostViewModel @Inject constructor(
    private val postRepo: PostRepository,
    private val userRepo: UserRepository,
    private val commentRepo: CommentRepository
) : ViewModel() {
    val postList: LiveData<Resource<List<Post>>> =  postRepo.loadPosts()

    fun getUser(postID: Int) = userRepo.loadUser(postID)

    fun getComments(postId: Int) =  commentRepo.loadComments(postId)
}
