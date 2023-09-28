package com.sametersoyoglu.kbkisileruygulamasi.data.repo

import com.sametersoyoglu.kbkisileruygulamasi.data.datasource.KisilerDataSource
import com.sametersoyoglu.kbkisileruygulamasi.data.entity.Kisiler

class KisilerRepository {
    // kds KisilerDataSource u burada tanımlıyarak repository ile datasource arasında bağlantı kurarak işlemlerimizi yaparız.
    val kds = KisilerDataSource()
    suspend fun kaydet(kisi_ad : String, kisi_tel :String) = kds.kaydet(kisi_ad,kisi_tel)

    suspend fun guncelle (kisi_id : Int,kisi_ad : String, kisi_tel :String) = kds.guncelle(kisi_id,kisi_ad,kisi_tel)

    suspend fun sil(kisi_id : Int) = kds.sil(kisi_id)

    suspend fun kisileriYukle() : List<Kisiler> = kds.kisileriYukle()


}