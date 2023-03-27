package com.salihkinali.feature.detail.di

import com.salihkinali.common.mapper.StoreMapper
import com.salihkinali.core.domain.entity.FavoriteProduct
import com.salihkinali.core.domain.entity.ProductDetailEntity
import com.salihkinali.feature.detail.ProductDetailMapperImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class DetailMapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindDetailMapper(productDetailMapperImpl: ProductDetailMapperImpl):
            StoreMapper<ProductDetailEntity, FavoriteProduct>
}