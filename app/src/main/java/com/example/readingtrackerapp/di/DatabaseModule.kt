package com.example.readingtrackerapp.di

import android.content.Context
import androidx.room.Room
import com.example.readingtrackerapp.data.local.dao.BookDao
import com.example.readingtrackerapp.data.local.dao.StatsDao
import com.example.readingtrackerapp.data.local.database.BookDatabase
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
    fun providesDatabase(
        @ApplicationContext context: Context
    ): BookDatabase =
        Room.databaseBuilder(
            context,
            BookDatabase::class.java,
            "books_db"
        )
            .fallbackToDestructiveMigration()
            .build()

    @Provides
    @Singleton
    fun providesDao(db: BookDatabase): BookDao =
        db.bookDao()

    @Provides
    @Singleton
    fun providesStatDao(db: BookDatabase): StatsDao =
        db.statsDao()
}