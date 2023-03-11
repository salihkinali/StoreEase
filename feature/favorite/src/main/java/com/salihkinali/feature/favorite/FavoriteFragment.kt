package com.salihkinali.feature.favorite

import android.os.Bundle
import android.view.View
import com.salihkinali.core.design.base.BaseFragment
import com.salihkinali.favorite.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}