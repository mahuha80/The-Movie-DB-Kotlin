package com.quanda.moviedb.ui.main.moviedetail

import android.arch.lifecycle.ViewModelProviders
import com.quanda.moviedb.R
import com.quanda.moviedb.base.activity.BaseDataLoadActivity
import com.quanda.moviedb.constants.BundleConstants
import com.quanda.moviedb.data.model.Movie
import com.quanda.moviedb.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : BaseDataLoadActivity<ActivityMovieDetailBinding, MovieDetailViewModel>(), MovieDetailNavigator {

    override fun getLayoutId(): Int {
        return R.layout.activity_movie_detail
    }

    override fun initViewModel(): MovieDetailViewModel {
        return ViewModelProviders.of(this, MovieDetailViewModel.CustomFactory(this, this)).get(
                MovieDetailViewModel::class.java)

//        viewModel = ViewModelProviders.of(this).get(MovieDetailViewModel::class.java)
//        viewModel.context = this
//        viewModel.movieDetailNavigator = this
//        return viewModel
    }

    override fun initData() {
        super.initData()
        binding.viewModel = viewModel

        val bundle = intent.extras
        if (bundle != null) {
            val movie = bundle.getParcelable<Movie>(BundleConstants.MOVIE)
            viewModel.movie.postValue(bundle.getParcelable(BundleConstants.MOVIE))
        }
    }
}