package com.salihkinali.core.domain.repository

import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.domain.entity.FavoriteProduct
import com.salihkinali.core.domain.entity.ProductDetailEntity
import com.salihkinali.core.domain.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface StoreRepository {
    fun getAllStoreProducts(): Flow<NetworkResponse<List<ProductEntity>>>
    fun getDetailProduct(productId: Int): Flow<NetworkResponse<ProductDetailEntity>>

    suspend fun addFavoriteProduct(favoriteProduct: FavoriteProduct)

    fun getAllFavoriteProducts() : Flow<NetworkResponse<List<FavoriteProduct>>>
}