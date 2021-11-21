package com.alpha.a002_test_fragment.ui.movie

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.alpha.a002_test_fragment.R
import com.alpha.a002_test_fragment.databinding.ActivityMainBinding
import com.alpha.a002_test_fragment.factory.MovieFragmentFactory

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = MovieFragmentFactory()
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        init()
    }

    private fun init(){
        if(supportFragmentManager.fragments.size == 0){
            val movieId = 1
            val bundle = Bundle()
            bundle.putInt("movie_id", movieId)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MovieDetailFragment::class.java, bundle)
                .commit()
        }
    }

}







