package com.godlike.arouter;

import android.content.Context;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;


@Route(path = "/service/hello", name = "NB")
public class MyService implements IService {

    @Override
    public void sayHello(Context context) {
        Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init(Context context) {

    }
}

