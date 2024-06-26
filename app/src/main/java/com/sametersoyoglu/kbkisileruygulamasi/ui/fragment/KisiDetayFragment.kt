package com.sametersoyoglu.kbkisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sametersoyoglu.kbkisileruygulamasi.R
import com.sametersoyoglu.kbkisileruygulamasi.databinding.FragmentKisiDetayBinding
import com.sametersoyoglu.kbkisileruygulamasi.ui.viewmodel.KisiDetayViewModel
import com.sametersoyoglu.kbkisileruygulamasi.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiDetayFragment : Fragment() {

    private lateinit var binding: FragmentKisiDetayBinding
    private lateinit var viewModel: KisiDetayViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay,container,false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewModeli bağlama - onCreate içersinde olur bu işlem
        val tempViewModel : KisiDetayViewModel by viewModels() // gecici bir viewmodele atayıp ordan bizim viewmodelimize bağlarız.
        viewModel = tempViewModel
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
        viewModel.guncelle(kisi_id,kisi_ad,kisi_tel)
        val action = KisiDetayFragmentDirections.kisiDetayAnasayfaGecis()
        findNavController().navigate(action)
    }

}