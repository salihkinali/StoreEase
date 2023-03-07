package com.salihkinali.feature.home

import android.view.ViewGroup
import com.junior.kekod.study.utility.inflateAdapterItem
import com.kekodstudy.core.ui.base.BaseViewHolder
import com.salihkinali.core.design.extension.downloadImage
import com.salihkinali.feature.home.databinding.ProductItemBinding

class HomeViewHolder(private val binding: ProductItemBinding,private val itemClick: ((Int) -> Unit)?) : BaseViewHolder<ProductUiData>(binding.root) {

    override fun onBind(data: ProductUiData) {
        binding.apply {
            productImage.downloadImage(data.image)
            productName.text = data.title
            priceText.text = data.price.toString()
            itemBody.rootView.setOnClickListener {
                itemClick?.invoke(data.id)
            }

        }
    }

    companion object {
        fun createfrom(parent: ViewGroup, itemClickListener: ((Int) -> Unit)?): HomeViewHolder {
            return HomeViewHolder(parent.inflateAdapterItem(ProductItemBinding::inflate),itemClickListener)
        }
    }
}