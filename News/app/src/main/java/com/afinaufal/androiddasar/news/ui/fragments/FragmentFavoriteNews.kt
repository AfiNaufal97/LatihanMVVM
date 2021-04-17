package com.afinaufal.androiddasar.news.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.afinaufal.androiddasar.news.databinding.FragmentFavoriteNewsBinding

class FragmentFavoriteNews:Fragment() {

    private var _binding:FragmentFavoriteNewsBinding? = null
    private val binding get() = _binding

    override fun onCreateView(inflater:LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentFavoriteNewsBinding.inflate(layoutInflater, container, false)
        val view = binding!!.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }
}