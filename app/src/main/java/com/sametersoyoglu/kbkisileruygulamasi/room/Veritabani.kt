package com.sametersoyoglu.kbkisileruygulamasi.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sametersoyoglu.kbkisileruygulamasi.data.entity.Kisiler

// Kisiler::class kısmına kaç tane tablomuz varsa o kadar yazmalıyız 10 tane tablomuz varsa 10 tane tablomuzu da böyle yazmalıyız buraya.
@Database(entities = [Kisiler::class], version = 1)
abstract class Veritabani : RoomDatabase() {
    // abstract class yapmak zorundayız interface özelliği olan bir sınıf yapmak için
    // Veritabani erişim sınıfı : room veritabanına erişmek için oluşturduğumuz sınıf bu sınıf hem erişim hem de kopyalama işlemi yapıcak. veritabanımızı temsil eden sınıftır.
    // bu sınıf sayesinde veritabanı üzerinde işlemler yapabiliriz.

    // KisilerDao interface'ine erişmek için fonksiyon tanımladık
    abstract fun getKisilerDao() : KisilerDao
}