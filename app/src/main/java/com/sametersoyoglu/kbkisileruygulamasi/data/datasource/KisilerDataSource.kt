package com.sametersoyoglu.kbkisileruygulamasi.data.datasource

import android.util.Log
import com.sametersoyoglu.kbkisileruygulamasi.data.entity.Kisiler
import com.sametersoyoglu.kbkisileruygulamasi.retrofit.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource (var kisilerDao: KisilerDao) {

    suspend fun kisileriYukle() : List<Kisiler> =
        withContext(Dispatchers.IO) {
            return@withContext kisilerDao.kisileriYukle().kisiler
        }

    suspend fun ara (aramaKelimesi : String) : List<Kisiler> =
        withContext(Dispatchers.IO) {
            return@withContext kisilerDao.arama(aramaKelimesi).kisiler
        }




    // KisiKayitFragment ında ki butona basınca kaydet işlemini burda da tanımlıyoruz suspend şeklinde coroutine kullanacağımız için geri dönüş olmadığı için return de olmaz.
    suspend fun kaydet(kisi_ad : String, kisi_tel :String) = kisilerDao.kaydet(kisi_ad,kisi_tel)

    // KisiDetay Güncellemeyi datasource ta yapıp bağlantı kura kura fragment'a gidicez.
    suspend fun guncelle (kisi_id : Int,kisi_ad : String, kisi_tel :String) {
        kisilerDao.guncelle(kisi_id,kisi_ad,kisi_tel)
    }

    // adapterda yaptığımız silme işlemini datasource a da yapıcaz.
    suspend fun sil(kisi_id : Int) {
        kisilerDao.sil(kisi_id)
    }
}