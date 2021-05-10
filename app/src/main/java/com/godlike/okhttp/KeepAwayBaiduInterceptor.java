package com.godlike.okhttp;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class KeepAwayBaiduInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (request.url().host().equals("http://www.baidu.com")) {
            Request newRequest = request.newBuilder().url("http://www.soso.com").build();
            return chain.proceed(newRequest);
        }
        return chain.proceed(request);
    }
}
