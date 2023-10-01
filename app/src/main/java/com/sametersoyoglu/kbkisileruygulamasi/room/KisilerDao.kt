package com.sametersoyoglu.kbkisileruygulamasi.room

import androidx.room.Dao
import androidx.room.Query
import com.sametersoyoglu.kbkisileruygulamasi.data.entity.Kisiler


@Dao
interface KisilerDao {
    // Dao interface'i Veritabanı üzerindeki tablolarımızda yapacağımız işlemleri temsil eden sınıf.Örn; Silme, Ekleme vb işlemleri yaptığımız yer.
    // veritabanı üzerinde bizim sorgular oluşturmamızı sağlayan yerdir bu sorgularla veritabanı üzerinde işlemler yaparız.

   @Query("SELECT * FROM kisiler")
   suspend fun kisileriYukle(): List<Kisiler>
    // kisiler tablomuzda ki,veritabanımızdaki bütün bilgileri(tüm verileri) almak için sorgu oluşturduk.



}