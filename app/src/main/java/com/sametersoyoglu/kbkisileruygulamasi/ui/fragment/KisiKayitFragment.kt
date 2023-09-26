package com.sametersoyoglu.kbkisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.sametersoyoglu.kbkisileruygulamasi.R
import com.sametersoyoglu.kbkisileruygulamasi.databinding.FragmentKisiKayitBinding

class KisiKayitFragment : Fragment() {

    private lateinit var binding: FragmentKisiKayitBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_kayit,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // xml de yaptığımız kisiKayitFragment nesnemizi this e aktardık ulaşabilmesi için.
        binding.kisiKayitFragment = this

        binding.kisiKayitToolbarBaslik = "Kişi Kayıt"


    }

    fun buttonKaydet(kisi_ad : String, kisi_tel :String) {
        Log.e("Kişi Kyadet","$kisi_ad - $kisi_tel")
    }
}