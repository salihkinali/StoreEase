package com.salihkinali.feature.favorite

import android.view.ViewGroup
import com.kekodstudy.core.ui.base.BaseAdapter
import com.salihkinali.core.domain.entity.FavoriteProduct

class FavoriteAdapter :BaseAdapter<FavoriteProduct,FavoriteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        return FavoriteViewHolder.createfrom(parent)
    }
}