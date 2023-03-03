package com.salihkinali.core.domain.usecase

import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.domain.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface GetProductUseCase {

    operator fun invoke(): Flow<NetworkResponse<List<ProductEntity>>>
}