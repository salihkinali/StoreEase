package com.salihkinali.core.domain.usecase

import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.domain.entity.ProductEntity
import com.salihkinali.core.domain.repository.StoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductUseCaseImpl @Inject constructor(
    private val repository: StoreRepository
) : GetProductUseCase {

    override fun invoke(): Flow<NetworkResponse<List<ProductEntity>>> =
        repository.getAllStoreProducts()
}