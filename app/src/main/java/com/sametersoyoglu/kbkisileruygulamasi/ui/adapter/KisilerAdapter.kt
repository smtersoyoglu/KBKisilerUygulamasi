package com.sametersoyoglu.kbkisileruygulamasi.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.sametersoyoglu.kbkisileruygulamasi.data.entity.Kisiler
import com.sametersoyoglu.kbkisileruygulamasi.databinding.CardTasarimBinding
import com.sametersoyoglu.kbkisileruygulamasi.ui.fragment.AnasayfaFragmentDirections

class KisilerAdapter (var mContext: Context, var kisilerListesi : List<Kisiler>) : RecyclerView.Adapter<KisilerAdapter.CardTasarimTutucu> () {

    inner class  CardTasarimTutucu( var tasarim : CardTasarimBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        // binding oluştur ilk önce
        val binding = CardTasarimBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardTasarimTutucu(binding)
    }



    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kisi = kisilerListesi.get(position) // position sırayla arraylist içerisindeki verileri bize vericek.
        val t = holder.tasarim // cardtasarima erişmek için kullandık.
        t.textViewKisiAd.text = kisi.kisi_ad // card_tasarim da ki yapılara erişmemizi sağlar.
        t.textViewKisiTel.text = kisi.kisi_tel

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.kisiDetayGecis(kisi = kisi)
            Navigation.findNavController(it).navigate(gecis)

        }

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${kisi.kisi_ad} silinsin mi?",Snackbar.LENGTH_SHORT)
                .setAction("EVET") {
                    sil(kisi.kisi_id)
                }.show()
        }

    }

    override fun getItemCount(): Int {
        return kisilerListesi.size
    }

    // veritabanlarında silme id ile olur id sine göre sileriz.
    fun sil(kisi_id : Int) {
        Log.e("Kişi Sil",kisi_id.toString())
    }
}