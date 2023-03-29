package com.salihkinali.core.data.source

import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.domain.entity.FavoriteProduct


interface LocalDataSource {

    suspend fun addFavoriteProduct(favoriteProduct: FavoriteProduct)
    suspend fun getAllFavoriteProducts(): NetworkResponse<List<FavoriteProduct>>
}