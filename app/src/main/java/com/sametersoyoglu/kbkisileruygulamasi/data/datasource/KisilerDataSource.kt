package com.sametersoyoglu.kbkisileruygulamasi.data.datasource

import android.util.Log
import com.sametersoyoglu.kbkisileruygulamasi.data.entity.Kisiler
import com.sametersoyoglu.kbkisileruygulamasi.room.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource(var kisilerDao: KisilerDao) {
// KisilerDao interface ine erişmek için yukarıda parantezde tanımlıyoruz interface de yaptığımız room işlemlerini yapabilmek için.
// var kisilerDao: KisilerDao bunun sayesinde aşağıda verileri alıp kullanıyım diyoruz.
    suspend fun kisileriYukle() : List<Kisiler> =
        withContext(Dispatchers.IO) {
            // kisilerDao ile KisilerDao interface inde ki kisileriYukle() fonksiyonuna eriştik. bize listeyi getirdi
            return@withContext kisilerDao.kisileriYukle()
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
        val yeniKisi = Kisiler(0,kisi_ad,kisi_tel) // id 0 gireriz bir etkisi yok.
        kisilerDao.kaydet(yeniKisi)
    }

    // KisiDetay Güncellemeyi datasource ta yapıp bağlantı kura kura fragment'a gidicez.
    suspend fun guncelle (kisi_id : Int,kisi_ad : String, kisi_tel :String) {
        val guncellenenKisi = Kisiler(kisi_id,kisi_ad,kisi_tel) // id belirtmemiz lazım id ye göre güncelleme yapağımız için.
        kisilerDao.guncelle(guncellenenKisi)
    }

    // adapterda yaptığımız silme işlemini datasource a da yapıcaz.
    suspend fun sil(kisi_id : Int) {
        val silinenKisi = Kisiler(kisi_id,"","") // silme için sadece id ye ihtiyaç var. ad ve tel'i boş geçiyoruz.
        kisilerDao.sil(silinenKisi)
    }
}