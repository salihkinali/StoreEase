package com.salihkinali.storeease.data.api

import com.salihkinali.storeease.data.dto.home.StoreProductItem
import retrofit2.http.GET

interface StoreEaseApi {

    @GET("products/")
    suspend fun getAllStoreProduct(): List<StoreProductItem>

}