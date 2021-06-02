package com.godlike.rxjava.lunxun;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RxJavafixRxjava extends AppCompatActivity {
    private final String TAG = "RxJavafixRxjava";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initRXJava();
    }

    private void initRXJava() {
        Observable.interval(2, TimeUnit.SECONDS).doOnNext(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://fy.iciba.com/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build();
                GetRequest_Interface getRequest_interface = retrofit.create(GetRequest_Interface.class);
                Observable<Translation> observable = getRequest_interface.getCall();
                observable.subscribe(new Consumer<Translation>() {
                    @Override
                    public void accept(Translation translation) throws Exception {
                        translation.show();
                    }
                });
            }
        }).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) {
                Log.e(TAG, String.valueOf(aLong));
            }
        });
    }
}
