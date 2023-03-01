package com.salihkinali.storeease.data.source

import com.salihkinali.storeease.data.api.StoreEaseApi
import com.salihkinali.storeease.data.dto.home.StoreProductItem
import com.salihkinali.storeease.utility.NetworkResponse
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getAllStoreProduct(api: StoreEaseApi): Flow<NetworkResponse<List<StoreProductItem>>>
}