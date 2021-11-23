package com.godlike.retrofit;

import android.os.Bundle;
import android.view.View;

import com.james.godlike.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RetrofitAct extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = RetrofitAct.class.getName();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_one);
        initView();
    }

    private void initView() {
        RecyclerView rv = findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            list.add(String.valueOf(i));
        }
        JamesAdapter adapter = new JamesAdapter(R.layout.item_one, list);
        rv.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

    }
}
