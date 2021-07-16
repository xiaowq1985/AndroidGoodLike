package com.godlike.retrofit.api;

import com.godlike.retrofit.bean.PostBodyBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface PostBodyFunApi {
    @POST("api/bodyParam")
    Call<ResponseBody> postBodyFun(@Body PostBodyBean postBodyBean);
}
