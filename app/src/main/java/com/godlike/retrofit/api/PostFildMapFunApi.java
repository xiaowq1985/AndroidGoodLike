package com.godlike.retrofit.api;

import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostFildMapFunApi {
    @FormUrlEncoded
    @POST("api/fieldMapParam")
    Call<ResponseBody> postFildMapFun(@FieldMap Map<String, String> map);
}
