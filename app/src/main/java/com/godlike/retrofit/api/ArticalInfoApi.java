package com.godlike.retrofit.api;

import com.godlike.retrofit.bean.ArticalInfo;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface ArticalInfoApi {
    @GET("api/getArticalInfo")
    Call<ArticalInfo> getArticalInfo(@QueryMap Map<String, String> params);
}
