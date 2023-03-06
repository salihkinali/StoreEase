package com.salihkinali.feature.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.design.base.BaseFragment
import com.salihkinali.feature.home.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel by viewModels<HomeViewModel>()
    private val adapter by lazy { HomeAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeProductData()
        setadapter()
    }

    private fun setadapter() {
        binding.productRv.adapter = adapter
    }

    private fun observeProductData() {
        lifecycleScope.launch {
            viewModel.homeUidata.collect {
                when (it) {
                    is NetworkResponse.Error -> Log.i("hata sebebi", it.exception.toString())
                    NetworkResponse.Loading -> Unit
                    is NetworkResponse.Success -> {
                       loadDataAdapter(it.result)
                        Log.i("GELEN DATA ->", it.result.toString())
                    }
                }
            }
        }
    }

    private fun loadDataAdapter(result: List<ProductUiData>) {
     adapter.updateItems(result)
    }
}