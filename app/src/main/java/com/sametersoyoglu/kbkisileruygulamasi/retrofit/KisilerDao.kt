package com.sametersoyoglu.kbkisileruygulamasi.retrofit

import com.sametersoyoglu.kbkisileruygulamasi.data.entity.CRUDCevap
import com.sametersoyoglu.kbkisileruygulamasi.data.entity.KisilerCevap
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KisilerDao {
    // http://kasimadalan.pe.hu/kisiler/tum_kisiler.php
    // http://kasimadalan.pe.hu/ -> base url
    // kisiler/tum_kisiler.php -> webservis url

    //TümKisiler
    @GET("kisiler/tum_kisiler.php")
    suspend fun kisileriYukle() : KisilerCevap

    //KisiEkleme webservise
    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded // veri gönderirken türkçe desteği olsun diye kullanırız.
    suspend fun kaydet(@Field("kisi_ad") kisi_ad:String,@Field("kisi_tel") kisi_tel:String) : CRUDCevap

    //KisiGüncelleme - webservis
    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    suspend fun guncelle(@Field("kisi_id") kisi_id:Int,@Field("kisi_ad") kisi_ad:String,
                         @Field("kisi_tel") kisi_tel:String) : CRUDCevap

    //Silme
    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    suspend fun sil(@Field("kisi_id") kisi_id:Int) : CRUDCevap

    // Arama
    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    suspend fun arama(@Field("kisi_ad") aramaKelimesi:String) : KisilerCevap



}
// @Field("kisi_ad") bu isimle gönderilecek diyoruz."" içerisindekiler webservisle aynı olmak zorunda.