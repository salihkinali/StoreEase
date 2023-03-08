package com.salihkinali.core.data.source

import com.salihkinali.core.common.NetworkResponse
import com.salihkinali.core.data.dto.detail.ResponseDetail
import com.salihkinali.core.data.dto.home.StoreProductItem

interface RemoteDataSource {
    suspend fun getAllStoreProduct(): NetworkResponse<List<StoreProductItem>>
    suspend fun getProductDetail(id:Int): NetworkResponse<ResponseDetail>
}