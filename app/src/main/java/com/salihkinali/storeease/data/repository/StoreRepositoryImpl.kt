package com.salihkinali.storeease.data.repository

import com.salihkinali.storeease.data.api.StoreEaseApi
import com.salihkinali.storeease.data.dto.home.StoreProductItem
import com.salihkinali.storeease.data.source.RemoteDataSource
import com.salihkinali.storeease.domain.repository.StoreRepository
import com.salihkinali.storeease.utility.NetworkResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class StoreRepositoryImpl(var remoteDataSource: RemoteDataSource,
                          var api: StoreEaseApi):StoreRepository {

    override suspend fun getAllStoreProducts(): Flow<NetworkResponse<List<StoreProductItem>>> =
        flow {
            // Gelen Datayı Karşılamalıyız.
        }
}
