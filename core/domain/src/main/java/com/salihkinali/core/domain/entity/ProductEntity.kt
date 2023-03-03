package com.salihkinali.core.domain.entity

data class ProductEntity(
    val category: String,
    val description: String,
    val id: Int,
    val image: String,
    val price: Double,
    val rating: Double,
    val title: String
)
