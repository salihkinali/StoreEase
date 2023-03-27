package com.salihkinali.feature.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salihkinali.common.mapper.StoreMapper
import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.domain.entity.FavoriteProduct
import com.salihkinali.core.domain.entity.ProductDetailEntity
import com.salihkinali.core.domain.repository.StoreRepository
import com.salihkinali.core.domain.usecase.GetDetailProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getDetailProductUseCase: GetDetailProductUseCase,
    private val detailProductMapper : StoreMapper<ProductDetailEntity,FavoriteProduct>,
    private val repository: StoreRepository
) : ViewModel() {

    private val _detailUiData = MutableStateFlow<NetworkResponse<ProductDetailEntity>>(
        NetworkResponse.Loading
    )
    val detailUiData = _detailUiData.asStateFlow()

    fun getDetailProduct(productId: Int) {
        viewModelScope.launch {
            getDetailProductUseCase.invoke(productId).collect { productDetail ->
                when (productDetail) {
                    is NetworkResponse.Error -> {
                        _detailUiData.emit(NetworkResponse.Error(productDetail.exception))
                    }
                    NetworkResponse.Loading -> {
                        _detailUiData.emit(NetworkResponse.Loading)
                    }
                    is NetworkResponse.Success -> {
                        _detailUiData.emit(NetworkResponse.Success(productDetail.result))
                    }
                }
            }
        }
    }

   suspend fun addToBasket(data: ProductDetailEntity?) {
       data?.let {
        repository.addFavoriteProduct(mappingData(it))
       }
    }

    private fun mappingData(it: ProductDetailEntity): FavoriteProduct = detailProductMapper.map(it)
}