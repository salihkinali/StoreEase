package com.salihkinali.core.domain.di

import com.salihkinali.core.domain.usecase.GetProductUseCase
import com.salihkinali.core.domain.usecase.GetProductUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
 abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindUseCase(getProductUseCaseImpl: GetProductUseCaseImpl): GetProductUseCase
}