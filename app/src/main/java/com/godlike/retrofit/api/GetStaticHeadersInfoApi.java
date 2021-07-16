package com.godlike.retrofit.api;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface GetStaticHeadersInfoApi {
    @Headers("version:1.1")
    @GET("api/staticHeaderInfo")
    Call<Response> getStaticHeaderInfo();
}
