package com.arsenbasha.m08.Interfaz

import com.arsenbasha.m08.Model.Marcas

import retrofit2.Call
import retrofit2.http.GET

interface JsonApi {

    @GET("courses.json")
    fun getDataFromJson(): Call<List<Marcas>>
}
