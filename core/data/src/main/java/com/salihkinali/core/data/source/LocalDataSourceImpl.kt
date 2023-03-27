package com.salihkinali.core.data.source

import com.salihkinali.core.data.datastore.ProductFavoriteDao
import com.salihkinali.core.domain.entity.FavoriteProduct
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val favoriteDao: ProductFavoriteDao) :
    LocalDataSource {

    override suspend fun addFavoriteProduct(favoriteProduct: FavoriteProduct) =
        favoriteDao.addProductItem(favoriteProduct)
}