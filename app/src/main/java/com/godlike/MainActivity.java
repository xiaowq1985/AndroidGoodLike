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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_skip:
//                James james = new James(11, "King");
//                ARouter.getInstance().build(ArouterConstance.AROUTER_PATH)
//                        .withInt("height", 23)
//                        .withParcelable("James", james)
//                        .withTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
//                        .navigation(this, 123);
                ARouter.getInstance().build(ArouterConstance.AROUTER_PATH).navigation();
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
}