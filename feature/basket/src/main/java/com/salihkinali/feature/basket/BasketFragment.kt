package com.salihkinali.feature.basket

import android.os.Bundle
import android.view.View
import com.salihkinali.core.design.base.BaseFragment
import com.salihkinali.feature.basket.databinding.FragmentBasketBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BasketFragment : BaseFragment<FragmentBasketBinding>(FragmentBasketBinding::inflate){

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}