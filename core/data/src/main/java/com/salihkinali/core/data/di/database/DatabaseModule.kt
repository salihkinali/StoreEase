package com.salihkinali.core.data.di.database

import android.content.Context
import androidx.room.Room
import com.salihkinali.core.data.datastore.ProductFavoriteDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): StoreEaseDatabase =
        Room.databaseBuilder(
            context,
            StoreEaseDatabase::class.java,
            "store_database")
            .build()

    @Provides
    @Singleton
    fun provideFavoriteDao(database: StoreEaseDatabase): ProductFavoriteDao = database.favoriteDao()
}