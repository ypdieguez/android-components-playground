package com.example.androidtest.ui.postdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.androidtest.databinding.FragmentPostDetailBinding
import com.example.androidtest.ui.common.PostViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class PostDetailFragment : DaggerFragment() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: PostViewModel
    private lateinit var binding: FragmentPostDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPostDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(PostViewModel::class.java)

        val post = PostDetailFragmentArgs.fromBundle(arguments!!).post
        binding.post = post
        viewModel.apply {
            getUser(post.userId).observe(viewLifecycleOwner, Observer {
                it.data?.run {
                    binding.user = this
                }
            })

            getComments(post.id).observe(viewLifecycleOwner, Observer {
                it.data?.run {
                    binding.commentsCount = this.size
                }
            })
        }
    }

}
