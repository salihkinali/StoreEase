package com.salihkinali.core.data.source

import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.data.api.StoreEaseApi
import com.salihkinali.core.data.dto.detail.ResponseDetail
import com.salihkinali.core.data.dto.home.StoreProductItem
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private var api: StoreEaseApi) : RemoteDataSource {
    override suspend fun getAllStoreProduct(): NetworkResponse<List<StoreProductItem>> =
        try {
            val response = api.getAllStoreProduct()
            NetworkResponse.Success(response)
        } catch (e: Exception) {
            NetworkResponse.Error(e)
        }

    override suspend fun getProductDetail(id: Int): NetworkResponse<ResponseDetail> =
        try {
            val response = api.getProductDetail(id)
            NetworkResponse.Success(response)
        } catch (e: Exception) {
            NetworkResponse.Error(e)
        }

}
