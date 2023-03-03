package com.salihkinali.common.mapper

interface StoreMapper<INPUT,OUTPUT> {
    fun map(input:INPUT):OUTPUT
}

