package com.atesyigit.kentsimgeleri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.atesyigit.kentsimgeleri.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var landmarkList : ArrayList<Landmark>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        landmarkList = ArrayList<Landmark>()

        val pisa = Landmark("Pisa","Italy",R.drawable.pisa)
        val collosseum = Landmark("Collosseum", "Italy", R.drawable.colesseum)
        val eiffel = Landmark("Eiffel Tower", "France", R.drawable.eifel)
        val londonBridge = Landmark("London Bridge","England", R.drawable.londonbridge)
        val hagiaSophia = Landmark("Hagia Sophia", "Turkey", R.drawable.hagiasophia)
        val brandenburgGate = Landmark("Brandenburg Gate", "Germany", R.drawable.brandenburg)
        val sagraDaFamilia = Landmark("Sagra Da Familia", "Spain", R.drawable.sagradafamilia)
        val pyramidsOfGiza = Landmark("Pyramids Of Giza", "Egypt", R.drawable.pyramidsofgiza)
        val bigBuddha = Landmark("Big Buddha", "Thailand", R.drawable.bigbuddha)
        val christTheReedemer = Landmark("Christ The Reedemer", "Brasil", R.drawable.christtheredeemer)
        val redSquare = Landmark("Red Square", "Russia", R.drawable.redsquare)
        val acropolis = Landmark("Acropolis", "Greece", R.drawable.acropolis)
        val svetiStefan = Landmark("Sveti Stefan", "Montenegro", R.drawable.svetistefan)
        val statueOfLiberty = Landmark("Statue Of Liberty", "USA", R.drawable.statueofliberty)
        val tajMahal = Landmark("Taj Mahal", "India", R.drawable.tajmahal)
        val greatWallOfChina = Landmark("Great Wall Of China", "China", R.drawable.greatwallofchina)
        val chickenitza = Landmark("Chickhen Itza", "Mexico", R.drawable.chichenitza)


        landmarkList.add(pisa)
        landmarkList.add(collosseum)
        landmarkList.add(eiffel)
        landmarkList.add(londonBridge)
        landmarkList.add(hagiaSophia)
        landmarkList.add(brandenburgGate)
        landmarkList.add(sagraDaFamilia)
        landmarkList.add(pyramidsOfGiza)
        landmarkList.add(bigBuddha)
        landmarkList.add(christTheReedemer)
        landmarkList.add(redSquare)
        landmarkList.add(acropolis)
        landmarkList.add(svetiStefan)
        landmarkList.add(statueOfLiberty)
        landmarkList.add(tajMahal)
        landmarkList.add(greatWallOfChina)
        landmarkList.add(chickenitza)




        binding.recyclerView.layoutManager= LinearLayoutManager(this)
        val landmarkAdapter = LandmarkAdapter(landmarkList)
        binding.recyclerView.adapter = landmarkAdapter




    }
}