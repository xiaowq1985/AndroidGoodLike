package com.godlike.arouter;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.james.godlike.R;
import com.james.godlike.databinding.ArouterPrcActivityBinding;

@Route(path = ArouterConstance.AROUTER_PATH)
public class ARouterActivity extends AppCompatActivity {
    @Autowired(name = "height")
    int height;

    @Autowired(name = "James")
    James james;
    ArouterPrcActivityBinding arouterPrcActivityBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ARouter.getInstance().inject(this);
        arouterPrcActivityBinding = DataBindingUtil.setContentView(this, R.layout.arouter_prc_activity);
        arouterPrcActivityBinding.arouterTxt.setText(james.toString() + ":  " + height);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(RESULT_OK);
    }
}
