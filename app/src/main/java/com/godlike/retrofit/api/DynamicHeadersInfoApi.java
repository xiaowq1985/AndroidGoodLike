package com.godlike.retrofit.api;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface DynamicHeadersInfoApi {
    @GET("api/dynamicHeadersInfo")
    Call<ResponseBody> getDynamicHeadersInfo(@HeaderMap Map<String, String> headers);
}
