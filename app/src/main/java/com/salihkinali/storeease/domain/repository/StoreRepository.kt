package com.salihkinali.storeease.domain.repository

import com.salihkinali.storeease.data.dto.home.StoreProductItem
import com.salihkinali.storeease.utility.NetworkResponse
import kotlinx.coroutines.flow.Flow

interface StoreRepository {

    suspend fun getAllStoreProducts(): Flow<NetworkResponse<List<StoreProductItem>>>

}