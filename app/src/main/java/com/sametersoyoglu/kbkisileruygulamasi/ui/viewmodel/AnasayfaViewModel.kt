package com.sametersoyoglu.kbkisileruygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sametersoyoglu.kbkisileruygulamasi.data.entity.Kisiler
import com.sametersoyoglu.kbkisileruygulamasi.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AnasayfaViewModel : ViewModel() {

    var kisilerRepository = KisilerRepository()
    var kisilerListesi = MutableLiveData<List<Kisiler>>()


    // init AnasayfaViewModel'in oluşturulduğu anda çalış demek.
    init { // AnasayfaViewModel ilk çalıştığı anda kisileriYukle() fonksiyonunu çalıştırsın ve bana verileri getirsin demek.
        // init kullanırız. bunu yapmazsak uygulama ilk açıldığında veri getirmez. uygulama ilk açıldığında otomatik olarak verileri çekmek istediğimizden bunu yaparız.
        kisileriYukle()
    }

    fun sil(kisi_id : Int) {
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepository.sil(kisi_id)
        }
    }

    fun kisileriYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            // bu çalıştığı anda içerisinde veritabanından gelen kişiler olucak LiveData kullanarak yapıyoruz.
            kisilerListesi.value = kisilerRepository.kisileriYukle()
        }
    }

}