package com.salihkinali.core.domain.di

import com.salihkinali.core.domain.usecase.GetDetailProductUseCase
import com.salihkinali.core.domain.usecase.GetDetailProductUseCaseImpl
import com.salihkinali.core.domain.usecase.GetProductUseCase
import com.salihkinali.core.domain.usecase.GetProductUseCaseImpl
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.Binds as Binds1

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds1
    @ViewModelScoped
    abstract fun bindProductGameUseCase(getProductUseCaseImpl: GetProductUseCaseImpl): GetProductUseCase

    @Binds1
    @ViewModelScoped
    abstract fun bindDetailProductUseCase(getDetailProductUseCaseImpl: GetDetailProductUseCaseImpl):GetDetailProductUseCase

}