package com.godlike.retrofit.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BlueService {
    @GET("book/search")
    Call<ResponseBody> getSearchBooks(@Query("q") String name,
                                      @Query("tag") String tag,
                                      @Query("start") int start,
                                      @Query("count") int count
    );
}
