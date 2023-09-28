package com.sametersoyoglu.kbkisileruygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sametersoyoglu.kbkisileruygulamasi.data.repo.KisilerRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class KisiDetayViewModel : ViewModel() {

    var kisilerRepository = KisilerRepository()

    fun guncelle (kisi_id : Int,kisi_ad : String, kisi_tel :String) {
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepository.guncelle(kisi_id,kisi_ad,kisi_tel)
        }
    }
}