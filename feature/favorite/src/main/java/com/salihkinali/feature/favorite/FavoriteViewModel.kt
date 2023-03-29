package com.salihkinali.feature.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.domain.entity.FavoriteProduct
import com.salihkinali.core.domain.repository.StoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: StoreRepository) : ViewModel() {

    private val _favoriteUiData = MutableStateFlow<NetworkResponse<List<FavoriteProduct>>>(
        NetworkResponse.Loading
    )
    val favoriteUiData = _favoriteUiData.asStateFlow()

    init {
        getFavoriteProducts()
    }

    private fun getFavoriteProducts() {
        viewModelScope.launch {
            repository.getAllFavoriteProducts().collect { response ->
                when (response) {

                    is NetworkResponse.Error -> _favoriteUiData.emit(NetworkResponse.Error(response.exception))

                    NetworkResponse.Loading -> _favoriteUiData.emit(NetworkResponse.Loading)

                    is NetworkResponse.Success -> _favoriteUiData.emit(
                        NetworkResponse.Success(response.result))
                }
            }
        }
    }
}