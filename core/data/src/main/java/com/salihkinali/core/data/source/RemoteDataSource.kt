package com.salihkinali.core.data.source

import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.data.api.StoreEaseApi
import com.salihkinali.core.data.dto.home.StoreProductItem
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getAllStoreProduct(api: StoreEaseApi): Flow<NetworkResponse<List<StoreProductItem>>>
}