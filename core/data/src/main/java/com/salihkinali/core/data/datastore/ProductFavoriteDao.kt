package com.salihkinali.core.data.datastore

import androidx.room.*
import com.salihkinali.core.domain.entity.FavoriteProduct

@Dao
interface ProductFavoriteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addProductItem(item: FavoriteProduct)

    @Delete
    suspend fun deleteProductItem(item: FavoriteProduct)

    @Query("DELETE FROM favorite_table")
    suspend fun deleteAllProductFromFavorite()

    @Query("SELECT * FROM favorite_table ORDER BY id ASC")
    suspend fun getAllFavoriteProducts():List<FavoriteProduct>


}