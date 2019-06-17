package com.example.androidtest.ui.postlist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.androidtest.databinding.FragmentPostListBinding
import com.example.androidtest.ui.common.PostViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PostListFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: PostViewModel
    private lateinit var binding: FragmentPostListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PostViewModel::class.java)

        val adapter = PostAdapter()
        binding.postList.adapter = adapter

        viewModel.postList.observe(viewLifecycleOwner, Observer { result ->
            adapter.submitList(result.data)
        })
    }
}
