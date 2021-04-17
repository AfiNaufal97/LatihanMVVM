package com.afinaufal.androiddasar.news.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.afinaufal.androiddasar.news.databinding.FragmentFavoriteNewsBinding
import com.afinaufal.androiddasar.news.databinding.FragmentHeadlineNewsBinding
import com.afinaufal.androiddasar.news.ui.NewsViewModel
import com.afinaufal.androiddasar.news.ui.activities.NewsActivity

class FragmentHeadlineNews:Fragment() {
    private var _binding: FragmentHeadlineNewsBinding? = null
    private val binding get() = _binding
    private lateinit var viewModel: NewsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHeadlineNewsBinding.inflate(layoutInflater, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = (activity as NewsActivity).viewModel
    }
}