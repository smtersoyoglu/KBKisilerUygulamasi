package com.sametersoyoglu.kbkisileruygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sametersoyoglu.kbkisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiDetayViewModel @Inject constructor(var kisilerRepository: KisilerRepository) : ViewModel() {

    //var kisilerRepository = KisilerRepository() hilt ile yukarıda tanımladık.

    fun guncelle (kisi_id : Int,kisi_ad : String, kisi_tel :String) {
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepository.guncelle(kisi_id,kisi_ad,kisi_tel)
        }
    }
}