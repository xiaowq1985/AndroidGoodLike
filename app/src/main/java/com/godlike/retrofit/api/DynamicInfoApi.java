package com.godlike.retrofit.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DynamicInfoApi {
    @GET("api/getDynamicInfo/{param}/data")
    Call<ResponseBody> getDynamicInfo(@Path("param") String param);
}
