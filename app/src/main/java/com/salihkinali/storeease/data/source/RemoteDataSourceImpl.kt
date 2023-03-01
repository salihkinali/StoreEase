package com.salihkinali.storeease.data.source

import com.salihkinali.storeease.data.api.StoreEaseApi
import com.salihkinali.storeease.data.dto.home.StoreProductItem
import com.salihkinali.storeease.utility.NetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class RemoteDataSourceImpl : RemoteDataSource {

    override suspend fun getAllStoreProduct(api: StoreEaseApi): Flow<NetworkResponse<List<StoreProductItem>>> =
        flow {
            try {
                emit(NetworkResponse.Loading)
                val data = api.getAllStoreProduct()
                emit(NetworkResponse.Success(data))

            } catch (e: Exception) {
                emit(NetworkResponse.Error(e))
            }
        }
}