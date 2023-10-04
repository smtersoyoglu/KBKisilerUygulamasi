package com.sametersoyoglu.kbkisileruygulamasi.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sametersoyoglu.kbkisileruygulamasi.data.entity.Kisiler
import com.sametersoyoglu.kbkisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnasayfaViewModel @Inject constructor(var kisilerRepository: KisilerRepository): ViewModel() {

    //var kisilerRepository = KisilerRepository() bu bağımlılığı hilt kullanarak dışardan alırız.
    var kisilerListesi = MutableLiveData<List<Kisiler>>()


    // init AnasayfaViewModel'in oluşturulduğu anda çalış demek.
    init { // AnasayfaViewModel ilk çalıştığı anda kisileriYukle() fonksiyonunu çalıştırsın ve bana verileri getirsin demek.
        // init kullanırız. bunu yapmazsak uygulama ilk açıldığında veri getirmez. uygulama ilk açıldığında otomatik olarak verileri çekmek istediğimizden bunu yaparız.
        kisileriYukle()
    }

    fun sil(kisi_id : Int) {
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepository.sil(kisi_id)
            // silme işleminden sonra anasayfada yani recyclerview de silinen kişinin görünmemesi için verileri tekrar yükleriz en son güncel halde tekrar alırız verileri.
            kisileriYukle()
        }
    }

    fun kisileriYukle() {
        CoroutineScope(Dispatchers.Main).launch {
            // bu çalıştığı anda içerisinde veritabanından gelen kişiler olucak LiveData kullanarak yapıyoruz.
            kisilerListesi.value = kisilerRepository.kisileriYukle()
        }
    }

    fun ara (aramaKelimesi : String) {

        CoroutineScope(Dispatchers.Main).launch {
            // bu çalıştığı anda içerisinde veritabanından gelen kişiler olucak LiveData kullanarak yapıyoruz.Arama için verileri getirir.
            kisilerListesi.value = kisilerRepository.ara(aramaKelimesi)
        }

    }

}