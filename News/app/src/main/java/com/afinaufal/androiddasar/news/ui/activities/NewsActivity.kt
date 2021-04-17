package com.afinaufal.androiddasar.news.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.afinaufal.androiddasar.news.R
import com.afinaufal.androiddasar.news.databinding.ActivityMainBinding
import com.afinaufal.androiddasar.news.db.ArticleDatabase
import com.afinaufal.androiddasar.news.repository.NewsRepository
import com.afinaufal.androiddasar.news.ui.NewsViewModel
import com.afinaufal.androiddasar.news.ui.NewsViewModelProviderFactory
import com.google.android.material.bottomnavigation.BottomNavigationView

class NewsActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel:NewsViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repository = NewsRepository(ArticleDatabase(this))
        val viewModelProvider = NewsViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this, viewModelProvider).get(NewsViewModel::class.java)

        val navigasiBottom = binding.bottomNav
        val nvComponent = findNavController(R.id.nav_host_fragment)
        navigasiBottom.setupWithNavController(nvComponent)

        binding.bottomNav.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.fragmentFavoriteNews -> {
                binding.toolbarMain.title = "Favorite News"
            }
            R.id.fragmentHeadlineNews -> {
                binding.toolbarMain.title = "Headline News"
            }
            R.id.fragmentSearchNews -> {
                binding.toolbarMain.title = "Search News"
            }
        }
        return true
    }
}