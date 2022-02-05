package com.example.githubsearchrepo.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.githubsearchrepo.databinding.ListItemRepositoryBinding
import com.example.githubsearchrepo.model.GitHubRepo

class RepositoriesAdapter :
    ListAdapter<GitHubRepo, RecyclerView.ViewHolder>(RepositoryDiffCallback()) {

    private class RepositoryDiffCallback : DiffUtil.ItemCallback<GitHubRepo>() {
        override fun areItemsTheSame(oldItem: GitHubRepo, newItem: GitHubRepo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GitHubRepo, newItem: GitHubRepo): Boolean {
            return oldItem == newItem
        }
    }

    class RepositoryViewHolder(private val binding: ListItemRepositoryBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: GitHubRepo) {
            binding.run {
                repository = item
                executePendingBindings()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder {
        return RepositoryViewHolder(
            ListItemRepositoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {
        (viewHolder as RepositoryViewHolder).bind(getItem(position))
    }

    override fun getItemCount() = currentList.size
}