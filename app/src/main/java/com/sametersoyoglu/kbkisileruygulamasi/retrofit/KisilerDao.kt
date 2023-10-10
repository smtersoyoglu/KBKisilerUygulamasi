package com.sametersoyoglu.kbkisileruygulamasi.retrofit

import com.sametersoyoglu.kbkisileruygulamasi.data.entity.KisilerCevap
import retrofit2.http.GET

interface KisilerDao {
    // http://kasimadalan.pe.hu/kisiler/tum_kisiler.php
    // http://kasimadalan.pe.hu/ -> base url
    // kisiler/tum_kisiler.php -> webservis url

    @GET("kisiler/tum_kisiler.php")
    suspend fun kisileriYukle() : KisilerCevap
}