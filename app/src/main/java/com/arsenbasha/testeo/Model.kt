package com.arsenbasha.testeo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Model : ViewModel() {
   var recyclerListData: MutableLiveData<RecycleViewList>
    var recycleViewAdapter: RecyclerViewAdapter

    init {
        recyclerListData = MutableLiveData()
        recycleViewAdapter = RecyclerViewAdapter()
    }
    fun getAdapter(): RecyclerViewAdapter {
        return recycleViewAdapter
    }
    fun setAdapterData(data: ArrayList<RecyclerData>) {
        recycleViewAdapter.setDataList(data)
        recycleViewAdapter.notifyDataSetChanged()
    }



    fun getRecyclerListDataObeserver(): MutableLiveData<RecycleViewList> {
        return recyclerListData
    }


    fun makeApi(input: String) {
        val concesionarioInstance = ConcesionarioInstance.getConcesionaroInstance()
            .create(ConcesioarioApiService::class.java)
        val call = concesionarioInstance.getDataFromJson(input)
        call.enqueue(object : Callback<RecycleViewList> {
            override fun onFailure(call: Call<RecycleViewList>, t: Throwable) {
                recyclerListData.postValue(null)
            }

            override fun onResponse(call: Call<RecycleViewList>, response: Response<RecycleViewList>) {
                if (response.isSuccessful) {
                    recyclerListData.postValue(response.body())
                } else {
                    recyclerListData.postValue(null)
                }
            }
        })
    }
}