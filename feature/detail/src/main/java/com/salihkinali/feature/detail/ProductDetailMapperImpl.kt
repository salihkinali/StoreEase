package com.salihkinali.feature.detail

import com.salihkinali.common.mapper.StoreMapper
import com.salihkinali.core.domain.entity.FavoriteProduct
import com.salihkinali.core.domain.entity.ProductDetailEntity
import javax.inject.Inject

class ProductDetailMapperImpl @Inject constructor(): StoreMapper<ProductDetailEntity,FavoriteProduct> {
    override fun map(input: ProductDetailEntity): FavoriteProduct {
        return FavoriteProduct(
            title = input.title,
            image = input.image,
            rating = input.rate
        )
    }
}