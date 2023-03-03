package com.salihkinali.core.data.repository


import com.salihkinali.common.coroutine.IoDispatcher
import com.salihkinali.common.mapper.StoreListMapper
import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.data.dto.home.StoreProductItem
import com.salihkinali.core.data.source.RemoteDataSource
import com.salihkinali.core.domain.entity.ProductEntity
import com.salihkinali.core.domain.repository.StoreRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class StoreRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val productMapper: StoreListMapper<StoreProductItem, ProductEntity>,
   @IoDispatcher private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : StoreRepository {
    override fun getAllStoreProducts(): Flow<NetworkResponse<List<ProductEntity>>> =
        flow {

            emit(NetworkResponse.Loading)
            when (val response = remoteDataSource.getAllStoreProduct()) {
                is NetworkResponse.Error -> {
                    emit(NetworkResponse.Error(response.exception))
                }

                NetworkResponse.Loading -> emit(NetworkResponse.Loading)

                is NetworkResponse.Success -> {
                    emit(NetworkResponse.Success(productMapper.map(response.result)))
                }
            }
        }.flowOn(ioDispatcher)
}
