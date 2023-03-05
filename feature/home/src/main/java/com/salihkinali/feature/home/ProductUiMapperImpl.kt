package com.salihkinali.feature.home

import com.salihkinali.common.mapper.StoreListMapper
import com.salihkinali.core.domain.entity.ProductEntity
import javax.inject.Inject

class ProductUiMapperImpl @Inject constructor(): StoreListMapper<ProductEntity, ProductUiData> {
    override fun map(input: List<ProductEntity>?): List<ProductUiData> {
        return input?.map {product->
            ProductUiData(
                id = product.id,
                image = product.image,
                category = product.category,
                price = product.price,
                title = product.title
            )
        } ?: emptyList()
    }
}