package com.sametersoyoglu.kbkisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sametersoyoglu.kbkisileruygulamasi.R
import com.sametersoyoglu.kbkisileruygulamasi.databinding.FragmentKisiKayitBinding

class KisiKayitFragment : Fragment() {

    private lateinit var binding: FragmentKisiKayitBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentKisiKayitBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.toolbarKisiKayit.title = "Kişi Kayıt"
        binding.buttonKaydet.setOnClickListener {
            val kisi_ad = binding.editTextKisiAd.text.toString()
            val kisi_tel = binding.editTextKisiTel.text.toString()
            kaydet(kisi_ad,kisi_tel)

        }

    }

    fun kaydet(kisi_ad : String, kisi_tel :String) {
        Log.e("Kişi Kyadet","$kisi_ad - $kisi_tel")
    }
}