package com.sametersoyoglu.kbkisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.sametersoyoglu.kbkisileruygulamasi.R
import com.sametersoyoglu.kbkisileruygulamasi.databinding.FragmentKisiDetayBinding

class KisiDetayFragment : Fragment() {

    private lateinit var binding: FragmentKisiDetayBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // xml de  yaptığımız databinding nesnesi bunu tanımlayarak buttonGuncellede ki işlemleri yapmamıza yarar.
        binding.kisiDetayFragment = this

        binding.kisiDetayToolbarBaslik = "Kişi Detay"

        // gönderilen veriyi alma
        val bundle:KisiDetayFragmentArgs by navArgs()
        val gelenKisi = bundle.kisi
        binding.kisiNesnesi = gelenKisi  // xmlde tanımladığımız gelen verilerin edittext de görünmesi işlemi için yaptığımız işlemi tanımladık.


    }

    // kayit eklemede ad ile tel bize yeterli olurken güncellemede id de almamız lazım ek olarak.
    fun buttonGuncelle (kisi_id : Int,kisi_ad : String, kisi_tel :String) {
        Log.e("Kişi Güncelle","$kisi_id - $kisi_ad - $kisi_tel")
    }

}