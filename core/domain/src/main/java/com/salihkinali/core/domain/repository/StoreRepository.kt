package com.salihkinali.core.domain.repository

import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.domain.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface StoreRepository {
    fun getAllStoreProducts(): Flow<NetworkResponse<List<ProductEntity>>>
}