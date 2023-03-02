package com.salihkinali.core.data.repository

import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.data.api.StoreEaseApi
import com.salihkinali.core.data.source.RemoteDataSource
import com.salihkinali.core.domain.entity.ProductEntity
import com.salihkinali.core.domain.repository.StoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class StoreRepositoryImpl @Inject constructor(
    var remoteDataSource: RemoteDataSource,
    var api: StoreEaseApi
): StoreRepository {

    override suspend fun getAllStoreProducts(): Flow<NetworkResponse<List<ProductEntity>>> =
        flow {
            // Gelen Datayı Karşılamalıyız.
        }
}
