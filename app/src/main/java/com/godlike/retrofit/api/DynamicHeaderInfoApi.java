package com.godlike.retrofit.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface DynamicHeaderInfoApi {
    @GET("api/dynamicHeadersInfo")
    Call<ResponseBody> getDynamicHeaderInfo(@Header("version") String version);

}
