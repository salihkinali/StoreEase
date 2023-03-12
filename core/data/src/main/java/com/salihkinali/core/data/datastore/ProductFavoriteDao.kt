package com.salihkinali.core.data.datastore

import androidx.room.*
import com.salihkinali.core.data.dto.favorite.FavoriteData

@Dao
interface ProductFavoriteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProductItem(item: FavoriteData)

    @Delete
    suspend fun deleteProductItem(item: FavoriteData)

    @Query("DELETE FROM favorite_table")
    suspend fun deleteAllProductFromFavorite()


}