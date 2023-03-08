package com.salihkinali.core.data.mapper

import com.salihkinali.common.mapper.StoreMapper
import com.salihkinali.core.data.dto.detail.ResponseDetail
import com.salihkinali.core.domain.entity.ProductDetailEntity
import javax.inject.Inject

class ProductDetailMapperImpl @Inject constructor() :
    StoreMapper<ResponseDetail, ProductDetailEntity> {
    override fun map(input: ResponseDetail): ProductDetailEntity {
        return ProductDetailEntity(
            id = input.id ?: 0,
            category = input.category.orEmpty(),
            description = input.description.orEmpty(),
            image = input.image.orEmpty(),
            price = input.price ?: 0.00,
            count = input.rating?.count ?: 0,
            rate = input.rating?.rate ?: 0.00,
            title = input.title.orEmpty()
        )
    }
}