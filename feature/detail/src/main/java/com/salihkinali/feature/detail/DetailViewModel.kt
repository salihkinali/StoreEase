package com.salihkinali.feature.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.domain.entity.ProductDetailEntity
import com.salihkinali.core.domain.usecase.GetDetailProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getDetailProductUseCase: GetDetailProductUseCase
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
                        Log.i("GELEN DATA BURDA ->", productDetail.result.description)
                        _detailUiData.emit(NetworkResponse.Success(productDetail.result))
                    }
                }
            }
        }
    }
}