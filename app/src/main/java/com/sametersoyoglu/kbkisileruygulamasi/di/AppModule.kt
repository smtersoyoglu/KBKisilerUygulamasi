package com.sametersoyoglu.kbkisileruygulamasi.di

import android.content.Context
import androidx.room.Room
import com.sametersoyoglu.kbkisileruygulamasi.data.datasource.KisilerDataSource
import com.sametersoyoglu.kbkisileruygulamasi.data.repo.KisilerRepository
import com.sametersoyoglu.kbkisileruygulamasi.room.KisilerDao
import com.sametersoyoglu.kbkisileruygulamasi.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton // kisilerDao yu aktarmamız lazım cünkü KisilerDataSource ta bağımlılık yaptık KisilerDao interface ini alabilmek için bağımlılıktan kurtulmak için de hilt kullanarak burada da tanımlamamız lazım.
    fun provideKisilerDataSource(kisilerDao: KisilerDao) : KisilerDataSource {
        return  KisilerDataSource(kisilerDao) // bu fonksiyon sayesinde KisilerDataSource'u KisilerRepository'e orda tanımladığımız KisilerDataSource'a ileticez.
    }

    @Provides
    @Singleton
    fun provideKisilerRepository(kds : KisilerDataSource) : KisilerRepository {
        return KisilerRepository(kds) // KisilerRepository den nesne oluşturacaksak KisilerDataSource ta tanımlı olduğu için KisilerDataSource' u da tanımlamamız lazım burda.
    }

    @Provides
    @Singleton // @ApplicationContext context: Context bunu kullanmamızın sebebi bize Context gerekiyor bunu dışarıdan ver dedik. bunu normalde dışarıdan sağlamamız gerekiyor fakat @ApplicationContext bu notasyon sayesinde hilt kütüphanesi bize bunu kendisi vericek.
    fun provideKisilerDao(@ApplicationContext context: Context) : KisilerDao {
        // veri tabanı ile ilgili çalışma yapmamız gerek onu tetiklemek çalıştırmak ve kopyalama işlemleri için
        val veriTabani = Room.databaseBuilder(context,Veritabani::class.java,"rehber.sqlite")
            .createFromAsset("rehber.sqlite").build() // ilk satırda veritabanına erişme işlemini , .createFromAsset("rehber.sqlite").build() bölümündede kopyalama işlemini yaptık. uygulama ilk çalıştığında 1 kere kopyalama yapıcak daha sonra erişmeye başlıcak
        return  veriTabani.getKisilerDao()  // bu fonksiyon sayesinde KisilerDao'u KisilerDataSource'a orda tanımladığımız kisilerDao 'a ileticez.
    }
}