package com.sametersoyoglu.kbkisileruygulamasi.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView.OnQueryTextListener
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.sametersoyoglu.kbkisileruygulamasi.R
import com.sametersoyoglu.kbkisileruygulamasi.data.entity.Kisiler
import com.sametersoyoglu.kbkisileruygulamasi.databinding.FragmentAnasayfaBinding
import com.sametersoyoglu.kbkisileruygulamasi.ui.adapter.KisilerAdapter
import com.sametersoyoglu.kbkisileruygulamasi.ui.viewmodel.AnasayfaViewModel
import com.sametersoyoglu.kbkisileruygulamasi.ui.viewmodel.KisiKayitViewModel
import com.sametersoyoglu.kbkisileruygulamasi.util.gecisYap
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {

    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel // ViewModeli tanımlama


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // ViewModeli bağlama - onCreate içersinde olur bu işlem
        val tempViewModel : AnasayfaViewModel by viewModels() // gecici bir viewmodele atayıp ordan bizim viewmodelimize bağlarız.
        viewModel = tempViewModel
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_anasayfa,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.anasayfaFragment = this
        binding.anasayfaToolbarBaslik = "Kişiler"




        binding.searchView.setOnQueryTextListener(object : OnQueryTextListener{
            override fun onQueryTextChange(newText: String?): Boolean {
                // harf girdikçe harf sildikçe sonuç getiren fonksiyon
                viewModel.ara(newText!!)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                // arama iconuna bastığımız zaman arama yapar arama yap dediğimiz zaman.
                viewModel.ara(query)
                return true
            }
        })

        // recyclerView tanımlama
        //binding.recyclerView.layoutManager = LinearLayoutManager(requireContext()) -- bu kodlamayı xml de recyclerview içerisinde basitçe yaptık.
        //binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL) // yanyana gözükme

        /* bu işlemi LiveData kullanarak DataSource'ta yapıyoruz.
        val kisilerListesi = ArrayList<Kisiler>()
        val k1 = Kisiler(1,"Ahmet","1111")
        val k2 = Kisiler(2,"Zeynep","2222")
        val k3 = Kisiler(3,"Beyza","3333")
        val k4 = Kisiler(4,"Metin","4444")
        kisilerListesi.add(k1)
        kisilerListesi.add(k2)
        kisilerListesi.add(k3)
        kisilerListesi.add(k4)
         */

        //LiveData yapısını kurduk - fragmentta olduğumuz için viewLifecycleOwner deriz
        viewModel.kisilerListesi.observe(viewLifecycleOwner) {
            // artık veri yükleme işlemini bunun içine aktardık.
            // adapter tanımlama - nesne oluşturma
            val kisilerAdapter = KisilerAdapter(requireContext(),it,viewModel)
            binding.kisilerAdapter = kisilerAdapter // adapterı recyclerView'e aktarma-görüntülemeyi sağlar

        }



    }

    fun fabTikla(it: View) {
        Navigation.gecisYap(it,R.id.kisiKayitGecis)
    }

    // kaydetme güncelleme gibi işlemleri yaptıktan sonra anasayfaya dönünce verilerin güncellenmesi en son hale gelmesi için kişileri yükleriz.
    override fun onResume() {
        super.onResume()
        viewModel.kisileriYukle() // bu kod sayesinde fab butona tıklayıp kişi kaydetme yaptıktan sonra anasayfaya döndüğümüzde kaydettiğimiz veriyi görürüz.
    }

}