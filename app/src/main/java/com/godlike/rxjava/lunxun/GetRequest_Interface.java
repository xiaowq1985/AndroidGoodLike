package com.godlike.rxjava.lunxun;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface GetRequest_Interface {
    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20world")
    Observable<Translation> getCall();
}
