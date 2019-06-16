package com.example.androidtest.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.androidtest.repository.PostRepository
import com.example.androidtest.vo.Post
import com.example.androidtest.vo.Resource
import javax.inject.Inject

class PostViewModel @Inject constructor(repository: PostRepository) : ViewModel() {
    val results: LiveData<Resource<List<Post>>> = repository.loadRepos()
}
