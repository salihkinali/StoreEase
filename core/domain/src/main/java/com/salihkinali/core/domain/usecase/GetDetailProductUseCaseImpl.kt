package com.salihkinali.core.domain.usecase

import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.domain.entity.ProductDetailEntity
import com.salihkinali.core.domain.repository.StoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDetailProductUseCaseImpl @Inject constructor(private val productRepository: StoreRepository) :
    GetDetailProductUseCase {
    override fun invoke(productId: Int): Flow<NetworkResponse<ProductDetailEntity>> =
        productRepository.getDetailProduct(productId)
}