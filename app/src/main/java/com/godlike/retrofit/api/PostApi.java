package com.godlike.retrofit.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PostApi {
    @FormUrlEncoded
    @POST("api/fieldParam")
    Call<ResponseBody> postFieldFun(@Field("key") String key);
}
