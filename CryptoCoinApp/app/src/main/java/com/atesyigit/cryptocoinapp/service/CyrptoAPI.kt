package com.atesyigit.cryptocoinapp.service

import io.reactivex.Observable
import retrofit2.http.GET
import com.atesyigit.cryptocoinapp.model.CyrptoModel

interface CyrptoAPI {


    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")

    fun getData(): Observable<List<CyrptoModel>>
}