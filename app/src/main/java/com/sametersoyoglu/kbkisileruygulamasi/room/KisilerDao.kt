package com.sametersoyoglu.kbkisileruygulamasi.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.sametersoyoglu.kbkisileruygulamasi.data.entity.Kisiler


@Dao
interface KisilerDao {
    // Dao interface'i Veritabanı üzerindeki tablolarımızda yapacağımız işlemleri temsil eden sınıf.Örn; Silme, Ekleme vb işlemleri yaptığımız yer.
    // veritabanı üzerinde bizim sorgular oluşturmamızı sağlayan yerdir bu sorgularla veritabanı üzerinde işlemler yaparız.

   @Query("SELECT * FROM kisiler")
   suspend fun kisileriYukle(): List<Kisiler>
    // kisiler tablomuzda ki,veritabanımızdaki bütün bilgileri(tüm verileri) almak için sorgu oluşturduk.

   // veritabanına ekleme kodu  Insert ile de kayıt yapıcak diyoruz
   @Insert
   suspend fun kaydet(kisi: Kisiler)

   // veritabanında güncelleme işlemini yapma
   @Update
   suspend fun guncelle(kisi:Kisiler)

   // veritabanından silme işlemi
   @Delete
   suspend fun sil(kisi: Kisiler)

   // Veritabanında Arama işlemi
   @Query("SELECT * FROM kisiler WHERE kisi_ad like '½' || :aramaKelimesi || '½'") // aramaKelimesini sorgumuza aktarmak bu şekilde oluyor.
   suspend fun ara (aramaKelimesi : String) : List<Kisiler>
}