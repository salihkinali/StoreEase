package com.salihkinali.core.domain.entity

data class ProductDetailEntity(
    val id: Int,
    val category: String,
    val description: String,
    val image: String,
    val price: Double,
    val count: Int,
    val rate: Double,
    val title: String
)