package com.lalan.android_learning.service

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface FormResponseService {

    @FormUrlEncoded
    @POST("formResponse")
    fun count(
        @Field("entry.700384962") p1: String,
        @Field("entry.1767562699") p2: String
    ): Call<String>
}