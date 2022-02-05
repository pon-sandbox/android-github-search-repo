package com.example.githubsearchrepo.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.githubsearchrepo.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private val viewModel: MainViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = MainFragmentBinding.inflate(inflater, container, false)
        val adapter = RepositoriesAdapter()
        binding.repositoryList.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.uiState.collect {
                adapter.submitList(it.repositories)
            }
        }
        viewModel.searchRepository("Android")

        return binding.root
    }

}