package com.example.androidtest.ui.postlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.androidtest.databinding.ItemPostBinding
import com.example.androidtest.vo.Post

class PostAdapter : ListAdapter<Post,PostAdapter.ViewHolder>(PostDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ViewHolder(private val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Post) {
            binding.apply {
                post = item
                postView.setOnClickListener {
                    val dir = PostListFragmentDirections
                        .actionPostListFragmentToPostDetailFragment(item.id, item.userId, item)
                    it.findNavController().navigate(dir)
                }
            }

        }
    }
}

private class PostDiffCallback : DiffUtil.ItemCallback<Post>() {
    override fun areItemsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Post, newItem: Post): Boolean {
        return oldItem.title == newItem.title
    }
}