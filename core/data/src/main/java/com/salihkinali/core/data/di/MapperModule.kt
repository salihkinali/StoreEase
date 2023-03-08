package com.salihkinali.core.data.di

import com.salihkinali.common.mapper.StoreListMapper
import com.salihkinali.common.mapper.StoreMapper
import com.salihkinali.core.data.dto.detail.ResponseDetail
import com.salihkinali.core.data.dto.home.StoreProductItem
import com.salihkinali.core.data.mapper.ProductDetailMapperImpl
import com.salihkinali.core.data.mapper.ProductMapperImpl
import com.salihkinali.core.domain.entity.ProductDetailEntity
import com.salihkinali.core.domain.entity.ProductEntity
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class MapperModule {

    @Binds
    @ViewModelScoped
    abstract fun bindStoreListMapper(productMapperImpl: ProductMapperImpl): StoreListMapper<StoreProductItem, ProductEntity>

    @Binds
    @ViewModelScoped
    abstract fun bindDetailStoreMapper(detailMapper: ProductDetailMapperImpl): StoreMapper<ResponseDetail, ProductDetailEntity>
}