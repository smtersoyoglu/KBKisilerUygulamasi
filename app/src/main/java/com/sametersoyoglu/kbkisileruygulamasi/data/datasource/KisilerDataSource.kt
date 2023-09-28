package com.sametersoyoglu.kbkisileruygulamasi.data.datasource

import android.util.Log
import com.sametersoyoglu.kbkisileruygulamasi.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource {


    suspend fun kisileriYukle() : List<Kisiler> =
        withContext(Dispatchers.IO) {
            val kisilerListesi = ArrayList<Kisiler>()
            val k1 = Kisiler(1,"Ahmet","1111")
            val k2 = Kisiler(2,"Zeynep","2222")
            val k3 = Kisiler(3,"Beyza","3333")
            val k4 = Kisiler(4,"Metin","4444")
            kisilerListesi.add(k1)
            kisilerListesi.add(k2)
            kisilerListesi.add(k3)
            kisilerListesi.add(k4)
            return@withContext kisilerListesi
        }

    suspend fun ara (aramaKelimesi : String) : List<Kisiler> =
        withContext(Dispatchers.IO) {
            val kisilerListesi = ArrayList<Kisiler>()
            val k1 = Kisiler(1,"Ahmet","1111")
            kisilerListesi.add(k1)
            return@withContext kisilerListesi
        }




    // KisiKayitFragment ında ki butona basınca kaydet işlemini burda da tanımlıyoruz suspend şeklinde coroutine kullanacağımız için geri dönüş olmadığı için return de olmaz.
    suspend fun kaydet(kisi_ad : String, kisi_tel :String) {
        Log.e("Kişi Kyadet","$kisi_ad - $kisi_tel")
    }

    // KisiDetay Güncellemeyi datasource ta yapıp bağlantı kura kura fragment'a gidicez.
    suspend fun guncelle (kisi_id : Int,kisi_ad : String, kisi_tel :String) {
        Log.e("Kişi Güncelle","$kisi_id - $kisi_ad - $kisi_tel")
    }

    // adapterda yaptığımız silme işlemini datasource a da yapıcaz.
    suspend fun sil(kisi_id : Int) {
        Log.e("Kişi Sil",kisi_id.toString())
    }
}