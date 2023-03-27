package com.salihkinali.core.data.di.database

import android.content.Context
import androidx.room.Room
import com.salihkinali.core.data.datastore.ProductFavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ): StoreEaseDatabase =
        Room.databaseBuilder(
            context,
            StoreEaseDatabase::class.java,
            "product_database"
        ).build()

    @Provides
    fun provideProductDao(database: StoreEaseDatabase): ProductFavoriteDao = database.productDao()

}