package com.salihkinali.feature.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.salihkinali.core.design.base.BaseFragment
import com.salihkinali.feature.home.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel by viewModels<HomeViewModel>()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.generalText.text = viewModel.homeUidata.toString()
    }
}