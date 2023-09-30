package com.sametersoyoglu.kbkisileruygulamasi.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.sametersoyoglu.kbkisileruygulamasi.data.repo.KisilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class KisiKayitViewModel @Inject constructor(var kisilerRepository: KisilerRepository): ViewModel() {

    //var kisilerRepository  = KisilerRepository() - hilt ile yukarıda tanımladık
    fun kaydet(kisi_ad : String, kisi_tel :String) { // fonksiyon suspend coroutine olduğu için CoroutineScope kullanarak yazmalıyız cevirmemiz için.
        CoroutineScope(Dispatchers.Main).launch {
            kisilerRepository.kaydet(kisi_ad,kisi_tel)
        }
    }
}