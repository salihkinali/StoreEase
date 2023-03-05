package com.salihkinali.feature.home.di

import com.salihkinali.common.mapper.StoreListMapper
import com.salihkinali.core.domain.entity.ProductEntity
import com.salihkinali.feature.home.ProductUiData
import com.salihkinali.feature.home.ProductUiMapperImpl
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
    abstract fun bindProductUiMapper(productUiMapperImpl: ProductUiMapperImpl): StoreListMapper<ProductEntity,ProductUiData>
}