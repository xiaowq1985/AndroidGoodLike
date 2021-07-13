package com.godlike.retrofit.api;

import com.godlike.retrofit.bean.UserInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserInfoAPI {
    @GET("api/getUserInfo")
    Call<UserInfo> getUserInfo(@Query("id") String id);
}
