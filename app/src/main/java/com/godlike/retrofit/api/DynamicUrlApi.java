package com.godlike.retrofit.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface DynamicUrlApi {
    @GET
    Call<ResponseBody> getDynamicUrl(@Url String url);
}
