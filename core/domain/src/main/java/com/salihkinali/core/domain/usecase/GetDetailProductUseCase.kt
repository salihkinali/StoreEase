package com.salihkinali.core.domain.usecase

import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.domain.entity.ProductDetailEntity
import kotlinx.coroutines.flow.Flow

interface GetDetailProductUseCase{

    operator fun invoke(productId:Int): Flow<NetworkResponse<ProductDetailEntity>>

}