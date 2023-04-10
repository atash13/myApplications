package com.atesyigit.cryptocoinapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.atesyigit.cryptocoinapp.R
import com.atesyigit.cryptocoinapp.adapter.RecyclerViewAdapter
import com.atesyigit.cryptocoinapp.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import com.atesyigit.cryptocoinapp.model.CyrptoModel
import com.atesyigit.cryptocoinapp.service.CyrptoAPI

class MainActivity : AppCompatActivity(), RecyclerViewAdapter.Listener {
    private lateinit var binding: ActivityMainBinding

    private val BASE_URL ="https://raw.githubusercontent.com/"
    private var cryptoModels: ArrayList<CyrptoModel>? = null
    private var recyclerViewAdapter : RecyclerViewAdapter? = null

    //Disposable
    private var compositeDisposable: CompositeDisposable? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json
        //https://api.nomics.com/v1/prices?key=2187154b76945f2373394aa34f7dc98a
        //2187154b76945f2373394aa34f7dc98a

        compositeDisposable = CompositeDisposable()

        //RecyclerView

        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager

        loadData()

    }

    private fun loadData() {

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(CyrptoAPI::class.java)


        compositeDisposable?.add(retrofit.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse))




    }

    private fun handleResponse(cryptoList : List<CyrptoModel>){
        cryptoModels = ArrayList(cryptoList)

        cryptoModels?.let {
            recyclerViewAdapter = RecyclerViewAdapter(it,this@MainActivity)
            binding.recyclerView.adapter = recyclerViewAdapter
        }
    }

    override fun onItemClick(cryptoModel: CyrptoModel) {
        Toast.makeText(this,"Clicked : ${cryptoModel.currency}", Toast.LENGTH_LONG ).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        compositeDisposable?.clear()
    }

}