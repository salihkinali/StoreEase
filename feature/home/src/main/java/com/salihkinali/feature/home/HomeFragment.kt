package com.salihkinali.feature.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.design.base.BaseFragment
import com.salihkinali.core.design.extension.hide
import com.salihkinali.core.design.extension.show
import com.salihkinali.feature.home.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel by viewModels<HomeViewModel>()


    private val adapter by lazy { HomeAdapter(::navigateToFragment) }
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
                    is NetworkResponse.Error -> {
                        binding.loadingBar.hide()
                    }

                    NetworkResponse.Loading -> {
                        binding.loadingBar.show()
                        binding.productRv.hide()
                    }
                    is NetworkResponse.Success -> {
                        binding.loadingBar.hide()
                        binding.productRv.show()
                        loadDataAdapter(it.result)
                    }
                }
            }
        }
    }

    private fun loadDataAdapter(result: List<ProductUiData>) {
        adapter.updateItems(result)
    }
    private fun navigateToFragment(id: Int) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(id)
        findNavController().navigate(action)

    }
}