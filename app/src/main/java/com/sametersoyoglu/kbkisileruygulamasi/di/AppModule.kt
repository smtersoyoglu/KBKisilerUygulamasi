package com.sametersoyoglu.kbkisileruygulamasi.di

import com.sametersoyoglu.kbkisileruygulamasi.data.datasource.KisilerDataSource
import com.sametersoyoglu.kbkisileruygulamasi.data.repo.KisilerRepository
import com.sametersoyoglu.kbkisileruygulamasi.retrofit.ApiUtils
import com.sametersoyoglu.kbkisileruygulamasi.retrofit.KisilerDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideKisilerDataSource(kisilerDao: KisilerDao) : KisilerDataSource {
        return  KisilerDataSource(kisilerDao) // bu fonksiyon sayesinde KisilerDataSource'u KisilerRepository'e orda tanımladığımız KisilerDataSource'a ileticez.
    }

    @Provides
    @Singleton
    fun provideKisilerRepository(kds : KisilerDataSource) : KisilerRepository {
        return KisilerRepository(kds) // KisilerRepository den nesne oluşturacaksak KisilerDataSource ta tanımlı olduğu için KisilerDataSource' u da tanımlamamız lazım burda.
    }

    @Provides
    @Singleton
    fun provideKisilerDao() : KisilerDao {
        return ApiUtils.getKisilerDao() // bu fonksiyon sayesinde KisilerDataSource'u KisilerRepository'e orda tanımladığımız KisilerDataSource'a ileticez.
    }
}