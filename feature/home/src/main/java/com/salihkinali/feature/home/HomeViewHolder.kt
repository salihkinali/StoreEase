package com.salihkinali.feature.home

import android.view.ViewGroup
import com.junior.kekod.study.utility.inflateAdapterItem
import com.kekodstudy.core.ui.base.BaseViewHolder
import com.salihkinali.core.design.extension.downloadImage
import com.salihkinali.feature.home.databinding.ProductItemBinding

class HomeViewHolder(private val binding: ProductItemBinding) : BaseViewHolder<ProductUiData>(binding.root) {

    override fun onBind(data: ProductUiData) {
        binding.apply {
            binding.productImage.downloadImage(data.image)
            binding.productName.text = data.title
            binding.priceText.text = data.price.toString()
        }
    }

    companion object {
        fun createfrom(parent: ViewGroup): HomeViewHolder {
            return HomeViewHolder(parent.inflateAdapterItem(ProductItemBinding::inflate))
        }
    }
}