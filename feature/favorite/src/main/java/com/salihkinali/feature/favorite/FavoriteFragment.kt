package com.salihkinali.feature.favorite

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.design.base.BaseFragment
import com.salihkinali.core.design.extension.hide
import com.salihkinali.core.design.extension.show
import com.salihkinali.favorite.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>(FragmentFavoriteBinding::inflate) {

    private val viewModel by viewModels<FavoriteViewModel>()
    private val adapter by lazy { FavoriteAdapter() }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeFavoriteProduct()
        setRvAdapter()
    }

    private fun setRvAdapter() {
        binding.favoriteRv.adapter = adapter
    }

    private fun observeFavoriteProduct() {
        lifecycleScope.launchWhenStarted {
            viewModel.favoriteUiData.collect {data ->

                when(data){
                    is NetworkResponse.Error ->{
                        binding.favoriteRatingBar.hide()
                     Toast.makeText(requireContext(),data.toString(),Toast.LENGTH_SHORT).show()
                }

                    NetworkResponse.Loading ->{
                        binding.favoriteRatingBar.show()
                    }

                    is NetworkResponse.Success ->{
                       binding.favoriteRatingBar.hide()
                        adapter.updateItems(data.result)
                    }
                }
            }
        }
    }
}