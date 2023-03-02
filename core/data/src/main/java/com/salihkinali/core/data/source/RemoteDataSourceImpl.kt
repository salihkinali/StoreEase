package com.salihkinali.core.data.source

import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.data.api.StoreEaseApi
import com.salihkinali.core.data.dto.home.StoreProductItem
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor() : RemoteDataSource {

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