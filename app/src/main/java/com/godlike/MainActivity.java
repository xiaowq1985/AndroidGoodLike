package com.godlike;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.godlike.arouter.ArouterConstance;
import com.godlike.arouter.IService;
import com.godlike.okhttp.KeepAwayBaiduInterceptor;
import com.james.godlike.R;
import com.james.godlike.databinding.MainActivityBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.io.IOException;

import eventbus.JamesEvent;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    MainActivityBinding mainActivityBinding;
    String TAG = MainActivity.class.getSimpleName();
    @Autowired(name = "/service/hello")
    IService iService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivityBinding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        mainActivityBinding.btnSkip.setOnClickListener(this);
        initOkhttp();
    }

    private void initOkhttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new KeepAwayBaiduInterceptor()).build();
        Request request = new Request.Builder().url("http://www.baidu.com").build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                Log.e(TAG, response.body().string());
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_skip:
                EventBus.getDefault().post(new JamesEvent("牛比"));
                ARouter.getInstance().build(ArouterConstance.EVENT_PATH).navigation();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, requestCode + "");
        Log.e(TAG, resultCode + "");
    }

    @Subscribe()
    public void onShow(JamesEvent event) {
        Log.e(TAG, event.getMessage());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}