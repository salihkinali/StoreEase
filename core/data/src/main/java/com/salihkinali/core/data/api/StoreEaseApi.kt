package com.salihkinali.core.data.api

import com.salihkinali.core.data.dto.home.StoreProductItem
import retrofit2.http.GET

interface StoreEaseApi {

    @GET("products/")
    suspend fun getAllStoreProduct(): List<StoreProductItem>

}