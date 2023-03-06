package com.salihkinali.feature.detail

import android.os.Bundle
import android.view.View
import com.salihkinali.core.design.base.BaseFragment
import com.salihkinali.feature.product.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}