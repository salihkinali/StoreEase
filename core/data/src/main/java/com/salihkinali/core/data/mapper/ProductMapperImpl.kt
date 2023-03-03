package com.salihkinali.core.data.mapper

import com.salihkinali.common.mapper.StoreListMapper
import com.salihkinali.core.data.dto.home.StoreProductItem
import com.salihkinali.core.domain.entity.ProductEntity
import javax.inject.Inject

class ProductMapperImpl @Inject constructor(): StoreListMapper<StoreProductItem, ProductEntity> {
    override fun map(input: List<StoreProductItem>?): List<ProductEntity> {
        return input?.map {
            ProductEntity(
                description = it.description.orEmpty(),
                image = it.image.orEmpty(),
                title = it.title.orEmpty(),
                category = it.category.orEmpty(),
                id = it.id ?: 0,
                price = it.price ?: 0.00,
                rating = it.rating?.rate ?: 0.00
            )
        } ?: emptyList()
    }
}