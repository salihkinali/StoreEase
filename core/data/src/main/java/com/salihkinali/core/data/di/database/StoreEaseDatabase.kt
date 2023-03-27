package com.salihkinali.core.data.di.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.salihkinali.core.data.datastore.ProductFavoriteDao
import com.salihkinali.core.domain.entity.FavoriteProduct

@Database(entities = [FavoriteProduct::class], version = 1, exportSchema = false)
abstract class StoreEaseDatabase : RoomDatabase() {

    abstract fun favoriteDao (): ProductFavoriteDao

}