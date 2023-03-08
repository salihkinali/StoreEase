package com.salihkinali.core.data.repository


import com.salihkinali.common.coroutine.IoDispatcher
import com.salihkinali.common.mapper.StoreListMapper
import com.salihkinali.common.mapper.StoreMapper
import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.data.dto.detail.ResponseDetail
import com.salihkinali.core.data.dto.home.StoreProductItem
import com.salihkinali.core.data.source.RemoteDataSource
import com.salihkinali.core.domain.entity.ProductDetailEntity
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
    private val detailMapper: StoreMapper<ResponseDetail, ProductDetailEntity>,
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

    override fun getDetailProduct(productId: Int): Flow<NetworkResponse<ProductDetailEntity>> =
        flow {
            emit(NetworkResponse.Loading)
            when (val response = remoteDataSource.getProductDetail(productId)) {
                is NetworkResponse.Error ->{
                    emit(NetworkResponse.Error(response.exception))
                }

                NetworkResponse.Loading -> emit(NetworkResponse.Loading)

                is NetworkResponse.Success -> {
                    emit(NetworkResponse.Success(detailMapper.map(response.result)))
                }
            }
        }.flowOn(ioDispatcher)
}
