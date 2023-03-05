package com.salihkinali.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salihkinali.common.mapper.StoreListMapper
import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.domain.entity.ProductEntity
import com.salihkinali.core.domain.usecase.GetProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductUseCase: GetProductUseCase,
    private val productUiMapper: StoreListMapper<ProductEntity, ProductUiData>
) : ViewModel() {

    private val _homeUiData = MutableStateFlow<NetworkResponse<List<ProductUiData>>>(
        NetworkResponse.Loading
    )
    val homeUidata = _homeUiData.asStateFlow()

    init {
        getProductData()
    }

    private fun getProductData() {
        viewModelScope.launch {
            getProductUseCase.invoke().collect {
                when (it) {
                    is NetworkResponse.Error -> {
                        _homeUiData.emit(NetworkResponse.Error(it.exception))
                    }
                    NetworkResponse.Loading -> {
                        _homeUiData.emit(NetworkResponse.Loading)
                    }
                    is NetworkResponse.Success -> {
                        _homeUiData.emit(NetworkResponse.Success(mappingUiData(it.result)))
                    }
                }
            }
        }
    }

    private fun mappingUiData(result: List<ProductEntity>): List<ProductUiData> {
        return productUiMapper.map(result)
    }

}