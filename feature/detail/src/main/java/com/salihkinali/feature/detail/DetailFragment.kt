package com.salihkinali.feature.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.design.base.BaseFragment
import com.salihkinali.core.design.extension.downloadImage
import com.salihkinali.core.design.extension.hide
import com.salihkinali.core.design.extension.show
import com.salihkinali.core.domain.entity.ProductDetailEntity
import com.salihkinali.feature.product.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


@AndroidEntryPoint
class DetailFragment : BaseFragment<FragmentDetailBinding>(FragmentDetailBinding::inflate) {

    private val viewModel by viewModels<DetailViewModel>()
    private val navArgs by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getDetailProduct(navArgs.productId)
        showDetailData()
        setClickListeners()
    }

    private fun setClickListeners() {
        binding.apply {
            minusButton.setOnClickListener {
                val getNumber = productPieceText.text
                val getPrice = productPriceText.text
                val result = viewModel.getminus(getNumber)
                val lastPrice = viewModel.getRealPrice(getNumber,getPrice,false)
                productPieceText.text = result
                productPriceText.text = lastPrice
            }

            plusButton.setOnClickListener {
                val getNumber = productPieceText.text
                val getPrice = productPriceText.text
                val result = viewModel.plus(getNumber)
                val lastPrice = viewModel.getRealPrice(getNumber,getPrice,true)
                productPieceText.text = result
                productPriceText.text = lastPrice
            }
        }
    }


    private fun showDetailData() {
        binding.apply {
            lifecycleScope.launch {
                viewModel.detailUiData.collectLatest {
                    when (it) {
                        is NetworkResponse.Error -> Unit
                        NetworkResponse.Loading -> binding.progressBar.show()
                        is NetworkResponse.Success -> {
                            showUiData(it.result)
                        }
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showUiData(result: ProductDetailEntity) {
        binding.apply {
            progressBar.hide()
            productImageView.downloadImage(result.image)
            productTitleText.text = result.title
            productDescriptionText.text = result.description
            ratingBar.rating = result.rate.toFloat()
            stockCount.text = "Stock Count: ${result.count}"
            productPieceText.text = "1"
            productPriceText.text = result.price.toString()
        }
    }
}