package com.godlike.rxjava;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.james.godlike.R;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Predicate;

public class RxJavaActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        initRxJava();
    }

    private void initRxJava() {
        Observable.range(1, 10).filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) throws Throwable {
                return integer < 5;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Throwable {
                Log.e(TAG, integer + "");
            }
        });
    }
}

