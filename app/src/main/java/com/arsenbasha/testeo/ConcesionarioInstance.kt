package com.arsenbasha.testeo

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ConcesionarioInstance {

    companion object{
        val Base_uRL ="https://www.github.com/search"
        fun getConcesionaroInstance():Retrofit{
            return Retrofit.Builder()
                .baseUrl(Base_uRL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}