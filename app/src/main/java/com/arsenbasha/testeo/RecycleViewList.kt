package com.arsenbasha.testeo


data class RecycleViewList(val item:ArrayList<RecyclerData>)
data class RecyclerData(
    val imgSrcUrl: String,
    val numero_seminari: Int,
    val titol: String,
    val empresa_organitzadora: String
)