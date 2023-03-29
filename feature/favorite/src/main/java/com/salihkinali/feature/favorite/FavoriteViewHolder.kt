package com.salihkinali.feature.favorite

import android.annotation.SuppressLint
import android.view.ViewGroup
import com.junior.kekod.study.utility.inflateAdapterItem
import com.kekodstudy.core.ui.base.BaseViewHolder
import com.salihkinali.core.design.extension.downloadImage
import com.salihkinali.core.domain.entity.FavoriteProduct
import com.salihkinali.favorite.databinding.ItemFavoriteBinding

class FavoriteViewHolder(private val binding: ItemFavoriteBinding) :
    BaseViewHolder<FavoriteProduct>(binding.root) {

    @SuppressLint("SetTextI18n")
    override fun onBind(data: FavoriteProduct) {

        binding.apply {
            favoriteProductName.text = data.title
            favoriteImage.downloadImage(data.image)
            favoriteProductPrice.text = "${data.price} $"
            productRatingBar.rating = data.rating.toFloat()
        }
    }

    companion object {
        fun createfrom(parent: ViewGroup): FavoriteViewHolder {
            return FavoriteViewHolder(parent.inflateAdapterItem(ItemFavoriteBinding::inflate))
        }
    }

}