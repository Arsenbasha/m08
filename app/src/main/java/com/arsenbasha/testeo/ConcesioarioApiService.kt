package com.arsenbasha.testeo

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ConcesioarioApiService {
 //courses.json
    @GET("courses.json")
    fun getDataFromJson(@Query("q") query: String):Call<RecycleViewList>
}