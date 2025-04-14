package com.natiqhaciyef.abb_hw_2.data.di

import android.content.Context
import androidx.room.Room
import com.natiqhaciyef.abb_hw_2.data.repository.DatabaseRepository
import com.natiqhaciyef.abb_hw_2.data.roomdb.AppDao
import com.natiqhaciyef.abb_hw_2.data.roomdb.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun getDao(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AppDatabase::class.java,"app_database")
            .fallbackToDestructiveMigration()
            .build()
            .getDao()

    @Provides
    @Singleton
    fun provideLocalRepo(dao: AppDao) = DatabaseRepository(dao)
}