package com.arsenbasha.m08

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.arsenbasha.m08.Interfaz.JsonApi
import com.arsenbasha.m08.Interfaz.Instancia
import com.arsenbasha.m08.Model.Marcas
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val boton = findViewById<Button>(R.id.button)
        boton.setOnClickListener { v ->
            callGetMarcas()
        }
    }

    private fun callGetMarcas() {
        val interfaz: JsonApi = Instancia.getinstancia().create(JsonApi::class.java)
        val resultados: Call<List<Marcas>> = interfaz.getDataFromJson()

        resultados.enqueue(object : Callback<List<Marcas>> {
            override fun onFailure(call: Call<List<Marcas>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Marcas>>, response: Response<List<Marcas>>) {
                val lista=
                Toast.makeText(this@MainActivity, "bien", Toast.LENGTH_SHORT).show()
            }
        })
    }


}