package com.salihkinali.feature.home

import android.view.ViewGroup
import com.kekodstudy.core.ui.base.BaseAdapter

class HomeAdapter(private val itemClickListener: ((Int) -> Unit)?) : BaseAdapter<ProductUiData,HomeViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        return HomeViewHolder.createfrom(parent,itemClickListener)
    }
}