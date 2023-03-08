package com.salihkinali.core.data.api

import com.salihkinali.core.data.dto.detail.ResponseDetail
import com.salihkinali.core.data.dto.home.StoreProductItem
import retrofit2.http.GET
import retrofit2.http.Path

interface StoreEaseApi {

    @GET("products/")
    suspend fun getAllStoreProduct(): List<StoreProductItem>

    @GET("products/{product_id}")
    suspend fun getProductDetail(@Path("product_id") productId: Int): ResponseDetail

}