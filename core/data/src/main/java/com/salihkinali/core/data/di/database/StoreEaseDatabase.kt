package com.salihkinali.core.data.di.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.salihkinali.core.data.datastore.ProductFavoriteDao
import com.salihkinali.core.data.dto.favorite.FavoriteData
import javax.inject.Inject

@Database(entities = [FavoriteData::class], version = 1, exportSchema = false)
abstract class StoreEaseDatabase @Inject constructor(): RoomDatabase() {

    abstract fun favoriteDao (): ProductFavoriteDao

}