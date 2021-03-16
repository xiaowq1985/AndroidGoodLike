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
import com.james.godlike.R;
import com.james.godlike.databinding.MainActivityBinding;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import eventbus.JamesEvent;

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
        ARouter.getInstance().inject(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_skip:
                EventBus.getDefault().postSticky(new JamesEvent("牛比"));
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